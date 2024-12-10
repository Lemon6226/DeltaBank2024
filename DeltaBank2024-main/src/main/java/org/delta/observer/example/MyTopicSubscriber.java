package org.delta.observer.example;
import org.delta.observer.Observer;
import org.delta.observer.Subject;
import java.util.List;
public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;
    public MyTopicSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println("No new message received");
        }
        else {
            System.out.println("Consuming message: " + msg);
        }
    }
    @Override
    public void setSubject(Subject subject) {
        topic = subject;
    }
}