/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.Observer.Publisher;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Handles all game events.
 * 
 * @author angelo
 */
public class EventHandler {
    private static ConcurrentLinkedQueue<Publisher> events = new ConcurrentLinkedQueue<>(); //stores all the events
    
    /**
     * Add an event to the queue.
     * 
     * @param p 
     */
    public static void addEvent(Publisher p){
        events.add(p);
    }
    
    /**
     * Remove an event from the queue.
     * 
     * @param p 
     */
    public static void removeEvent(Publisher p){
        events.remove(p);
    }
    
    /**
     * Will notfy all the event's subscribers.
     */
    public static void update(){
        while(events.isEmpty() == false){
            events.remove().notifySubscribers();
        }
    }
    
}
