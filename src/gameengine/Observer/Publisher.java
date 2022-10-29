/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Observer;

import java.util.ArrayList;

/**
 * Represents the object that store subscribers and notify them. 
 * 
 * @author angelo
 */
public class Publisher {
    private ArrayList<Subscriber> subscribers;
    
    public Publisher(){
        subscribers = new ArrayList<>();
    }
    
    public void subscribe(Subscriber s){
        subscribers.add(s);
    }
    
    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }
    
    public void notifySubscribers(){
        for(int i = 0; i<subscribers.size(); i++){
            subscribers.get(i).onNotified();
        }
    }
    
}
