package BuilderPatternExample;

public class BuilderPatternTest {
    public static void main(String args[]) {
        Computer officeComputer = new Computer.ComputerBuilder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("Office Computer: " + officeComputer);
    }

}
