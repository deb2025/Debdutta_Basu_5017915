package FactoryMethodPatternExample;

public class ConcreteExcelDocument implements ExcelDocument {
    public void open() {
        System.out.println("Opening the document");
    }

    public void close() {
        System.out.println("Closing the document");
    }

    public void save() {
        System.out.println("Saving the document");
    }

    public void addsheet() {
        System.out.println("Adding sheet to the document");
    }

}
