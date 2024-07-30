package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private List<Observer> observers;
    private double price;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setStockPrice(double price) {
        this.price = price;
        notifyAllObservers();
    }
}
