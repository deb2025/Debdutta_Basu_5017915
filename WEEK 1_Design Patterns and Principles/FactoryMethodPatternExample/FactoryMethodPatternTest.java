package FactoryMethodPatternExample;

public class FactoryMethodPatternTest {
    public static void main(String args[]) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();
        word.save();
        word.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        pdf.save();
        pdf.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
        excel.save();
        excel.close();
    }

}
