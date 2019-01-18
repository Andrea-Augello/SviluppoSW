package ExternalComponentsInterface;

import Oggetti.ErroreDialog;
import org.pdfclown.documents.*;
import org.pdfclown.documents.contents.composition.BlockComposer;
import org.pdfclown.documents.contents.composition.PrimitiveComposer;
import org.pdfclown.documents.Page;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;
import org.pdfclown.documents.contents.fonts.Font;
import org.pdfclown.documents.contents.fonts.StandardType1Font;
import org.pdfclown.documents.contents.xObjects.FormXObject;
import org.pdfclown.files.*;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;


public class PDFInterface {
    private static PDFInterface instance = new PDFInterface();

    public static PDFInterface getInstance() {
        return instance;
    }

    public void stampa(String testo){
        File file = new File();
        Document document = file.getDocument();
        Page page = new Page(document);
        document.getPages().add(page);
        Dimension2D pageSize = page.getSize();
        PrimitiveComposer composer = new PrimitiveComposer(page);
        BlockComposer blockComposer = new BlockComposer(composer);
        composer.beginLocalState();
        Rectangle2D frame = new Rectangle2D.Double(50, 50, pageSize.getWidth()-100, pageSize.getHeight()-100);
        blockComposer.begin(frame, XAlignmentEnum.Left, YAlignmentEnum.Top);

        composer.setFont(new StandardType1Font(document, StandardType1Font.FamilyEnum.Helvetica, true, false), 20);
        blockComposer.showText("Cartella clinica");
        blockComposer.showBreak();
        blockComposer.showText("----------------------");
        blockComposer.showBreak();

        composer.setFont(new StandardType1Font(document, StandardType1Font.FamilyEnum.Helvetica, false, false), 12);
        StringTokenizer st = new StringTokenizer(testo,"\n");
        while(st.hasMoreTokens()){
            blockComposer.showText(st.nextElement().toString());
            blockComposer.showBreak();
        }
        blockComposer.end();
        composer.end();
        composer.flush();
        try {
            file.save("Fascicolo sanitario.pdf", SerializationModeEnum.Standard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
