package ObserverPatternExample;

public class WebApp implements Observer {

    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received stock price update: " + price);
    }

}
