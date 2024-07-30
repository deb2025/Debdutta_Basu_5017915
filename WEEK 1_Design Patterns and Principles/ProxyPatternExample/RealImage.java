package ProxyPatternExample;

public class RealImage implements Image {

    private String imageurl;

    public RealImage(String imageurl) {
        this.imageurl = imageurl;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading image from " + imageurl);
        // Simulate time-consuming operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displayig the image :" + imageurl);

    }

}
