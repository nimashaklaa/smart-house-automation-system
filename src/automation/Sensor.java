package automation;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String eventType) {
        for (Observer observer : observers) {
            observer.update(eventType);
        }
    }

}