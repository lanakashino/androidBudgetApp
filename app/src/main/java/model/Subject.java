package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void notifyObserver(Double num) {
        for (Observer o: observers) {
            o.update(num);
        }
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

}
