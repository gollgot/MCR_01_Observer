package ObserverPattern;

import java.util.ArrayList;

public abstract class Subject {

    private ArrayList<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    /**
     * Attach a new observer to the subject
     * @param o The Observer we want to attach
     */
    public void attach(Observer o) {
        this.observers.add(o);
    }

    /**
     * Detach a specific observer from the subject
     * @param o The Observer we want to detach
     */
    public void detach(Observer o) {
        this.observers.remove(o);
    }

    /**
     * Notify all attached observers to update them
     */
    public void notifyObservers() {
        for(Observer o : this.observers){
            o.update();
        }
    }

}
