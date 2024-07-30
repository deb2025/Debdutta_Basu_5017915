package FactoryMethodPatternExample;

public class ConcretePdfDocument implements PdfDocument {
    public void open() {
        System.out.println("Opening the document");
    }

    public void close() {
        System.out.println("Closing the document");
    }

    public void save() {
        System.out.println("Saving the document");
    }

    public void encrypt() {
        System.out.println("Encrypting pdf document");
    }

}
