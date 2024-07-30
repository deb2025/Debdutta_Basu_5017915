package ProxyPatternExample;

public class ProxyImage implements Image {

    private String imageurl;
    private RealImage real;

    public ProxyImage(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public void display() {
        if (real == null) {
            real = new RealImage(imageurl);
        }
        real.display();
    }

}
