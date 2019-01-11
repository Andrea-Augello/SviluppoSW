package ExternalComponentsInterface;

import Oggetti.ErroreDialog;

public class PDFInterface {
    private static PDFInterface instance = new PDFInterface();

    public static PDFInterface getInstance() {
        return instance;
    }

    private PDFInterface() {
    }

    public void stampa(String testo){
        new ErroreDialog("Funzionalità di stampa non ancora implementate");
    }
}
