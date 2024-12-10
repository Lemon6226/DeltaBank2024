package org.delta.observer.example;
import org.delta.observer.Observer;
import org.delta.observer.Subject;
import java.util.ArrayList;
import java.util.List;
public class MyTopic implements Subject {
    String message;
    boolean changed;
    Object MUTEX = new Object();
    List<Observer> observers;
    public MyTopic() {
        this.observers = new ArrayList<Observer>();
    }
    @Override
    public void register(Observer o) {
        if (o == null) {
            throw new NullPointerException("Null Observer");
        }
        synchronized (MUTEX) {
            if (!observers.contains(o)) {
                observers.add(o);
                o.setSubject(this);
            }
        }
    }
    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
    @Override
    public Object getUpdate(Observer o) {
        return message;
    }
    public void postMessage(String message) {
        System.out.println("Message:" + message);
        this.message = message;
        this.changed = true;
        this.notifyObservers();
    }
}