package VisualizzaFSE;

import javax.activation.MimeType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FSEDialog {

	private FSEControl control;
	private String content;
	private JButton stampaButton;
	private JPanel panel;
	private JEditorPane editorPane1;

	public FSEDialog(FSEControl control, String content) {
		this.control = control;
		this.content = content;

        JFrame frame = new JFrame("SPRINT - Fascicolo Sanitario Elettronico");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		editorPane1.setEditable(false);

		frame.pack();
		frame.setVisible(true);
		stampaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        		stampaFSE();
			}
		});
	}

	public void stampaFSE() {
		control.stampa();
	}

	public void storicoVisite() {

	}

	private void createUIComponents() {
	    editorPane1 = new JEditorPane("text/html", content);
	}
}
