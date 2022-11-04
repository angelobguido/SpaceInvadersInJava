/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Observer;

/**
 * Represents the interface of objects that can be notified.
 * 
 * @author angelo
 */
public interface Subscriber {

    /**
     *  Will be called when this subscriber is notified.
     */
    public void onNotified();
}
