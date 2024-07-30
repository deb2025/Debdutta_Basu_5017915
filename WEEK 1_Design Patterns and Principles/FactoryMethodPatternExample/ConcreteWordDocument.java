package FactoryMethodPatternExample;

public class ConcreteWordDocument implements WordDocument {
    public void open() {
        System.out.println("Opening the document");
    }

    public void close() {
        System.out.println("Closing the document");
    }

    public void save() {
        System.out.println("Saving the document");
    }

    public void convertTopdf() {
        System.out.println("Converting the document to pdf");
    }

}
