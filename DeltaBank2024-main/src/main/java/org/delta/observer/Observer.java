package org.delta.observer;
import java.util.Observable;
public interface Observer {
    public void update();
    public void setSubject(Subject s);
}