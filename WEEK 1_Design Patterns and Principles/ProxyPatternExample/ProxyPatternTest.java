package ProxyPatternExample;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("https://youtube.com/image");

        img.display();
        System.out.println();

        img.display();
        System.out.println();
    }

}
