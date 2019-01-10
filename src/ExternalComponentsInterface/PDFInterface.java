package ExternalComponentsInterface;

public class PDFInterface {
    private static PDFInterface instance = new PDFInterface();

    public static PDFInterface getInstance() {
        return instance;
    }

    private PDFInterface() {
    }

    public void stampa(String html){

    }
}
