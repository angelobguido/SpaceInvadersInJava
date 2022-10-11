/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Observer;

import java.util.Vector;

/**
 *
 * @author angelo
 */
public class Publisher {
    private Vector<Subscriber> subscribers;
    
    public Publisher(){
        subscribers = new Vector<>();
    }
    
    public void subscribe(Subscriber s){
        subscribers.add(s);
    }
    
    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }
    
    public void notifySubscribers(){
        for(int i = 0; i<subscribers.size(); i++){
            subscribers.elementAt(i).onNotified();
        }
    }
    
}
