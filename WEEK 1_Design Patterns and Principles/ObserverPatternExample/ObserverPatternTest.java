package ObserverPatternExample;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webApp1);

        stockMarket.setStockPrice(100.50);
        System.out.println("");
        stockMarket.notifyAllObservers();

        stockMarket.remove(mobileApp2);
        stockMarket.setStockPrice(101.75);
    }

}
