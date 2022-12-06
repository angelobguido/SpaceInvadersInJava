/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Collider;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameObject;
import gameengine.Observer.Publisher;
import gameengine.Observer.Subscriber;

/**
 * Represents the ability to get hit to something and lose health.
 *
 * @author angelo
 */
public class Hit extends Component implements Subscriber{
    
    private Collider col;
    protected int health;
    protected int maxHealth = 1;

    /**
     * Is the publisher that stores all the subscribers that want to now about
     * this game object death.
     *
     */
    public final Publisher deathEvent = new Publisher();
    
    public Hit(GameObject gameObject){
        super(gameObject, ComponentId.Hit);
    }
    
    public Hit(GameObject gameObject, int maxHealth){
        super(gameObject, ComponentId.Hit);
        this.maxHealth = maxHealth;
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        Hit newHit = new Hit(gameObject);
        newHit.maxHealth = maxHealth;
        return newHit;
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        col = (Collider)gameObject.getComponent(ComponentId.Collider);
        col.subscribe(this);
        health = maxHealth;
    }
    
    @Override
    public void destroy(){
        col.unsubscribe(this);
        col = null;
        gameObject.removeComponent(this);
        gameObject = null;
        
        if(health>0) deathEvent.disable();
        
        if(deathEvent.hasSubscribers()){
            EventHandler.addEvent(deathEvent);
        }
        
    }
    
    @Override
    public void onNotified(){
        health--;
        onHit();
        if(health<=0){
            EntityHandler.removeEntity(gameObject);
        }
    }
    
    protected void onHit(){
        //Action when entity takes a hit
    }
}
