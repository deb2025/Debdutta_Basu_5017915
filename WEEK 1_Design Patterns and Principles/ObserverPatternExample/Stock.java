package ObserverPatternExample;

public interface Stock {
    void register(Observer o);

    void remove(Observer o);

    void notifyAllObservers();

}
