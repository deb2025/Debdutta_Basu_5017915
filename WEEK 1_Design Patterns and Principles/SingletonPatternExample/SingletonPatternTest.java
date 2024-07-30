package SingletonPatternExample;

public class SingletonPatternTest {
    public static void main(String args[]) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        if (log1 == log2) {
            System.out.println("Singelton Pattern Verified: Both instances are same");
        } else {
            System.out.println("Singleton pattern not applicable");
        }

        log1.log("This is testing the functionality implementation");

    }

}
