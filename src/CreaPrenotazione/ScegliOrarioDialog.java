package CreaPrenotazione;

import Oggetti.ErroreDialog;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ScegliOrarioDialog {

    private EffettuaPrenotazioneControl control;
    private List<LocalDateTime> orariDisponibili;
    private DefaultListModel<LocalDateTime> listModel;
    private JPanel panel;
    private JButton confermaButton;
    private JCalendar calendario;
    private JList list1;
    private JFrame frame;

    public ScegliOrarioDialog(EffettuaPrenotazioneControl control, List<LocalDateTime> orariDisponibili) {
        listModel = new DefaultListModel<>();
        this.control = control;
        this.orariDisponibili = orariDisponibili;
        frame = new JFrame("SPRINT - Scegli data e ora per la visita");
        $$$setupUI$$$();
        aggiornaOrari();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scegliOrario();
            }
        });
        calendario.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                aggiornaOrari();
            }
        });
    }

    public void scegliOrario() {
        if (list1.getSelectedIndex() > 0) {
            LocalDate giornoScelto = calendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime oraScelta = (LocalTime) list1.getSelectedValue();
            control.finalizzaPrenotazione(LocalDateTime.of(giornoScelto, oraScelta));
        } else {
            new ErroreDialog("Selezionare data e ora");
        }
    }

    private void aggiornaOrari() {
        list1.clearSelection();
        DefaultListModel model = listModel;
        model.clear();
        for (LocalDateTime data : orariDisponibili) {
            LocalDate convertedDate = data.toLocalDate();
            if (convertedDate.equals(calendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
                model.addElement(data.toLocalTime());
            }
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.add(calendario, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        list1 = new JList();
        panel1.add(list1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        confermaButton = new JButton();
        confermaButton.setText("Conferma");
        panel.add(confermaButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        calendario = new JCalendar(new Locale("IT"));
        calendario.setMinSelectableDate(new Date());
        //noinspection Duplicates
        calendario.getDayChooser().addDateEvaluator(new IDateEvaluator() {
            @Override
            public boolean isSpecial(Date date) {
                return false;
            }

            @Override
            public Color getSpecialForegroundColor() {
                return null;
            }

            @Override
            public Color getSpecialBackroundColor() {
                return null;
            }

            @Override
            public String getSpecialTooltip() {
                return null;
            }

            @Override
            public boolean isInvalid(Date date) {
                for (LocalDateTime dataDisponibile : orariDisponibili) {
                    LocalDate convertedDate = dataDisponibile.toLocalDate();
                    if (convertedDate.equals(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
                        System.out.println(convertedDate + "non appatta");
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Color getInvalidForegroundColor() {
                return null;
            }

            @Override
            public Color getInvalidBackroundColor() {
                return null;
            }

            @Override
            public String getInvalidTooltip() {
                return "Giorno non disponibile";
            }
        });

        list1 = new JList(listModel);
    }

    public void dispose() {
        frame.dispose();
    }
}
