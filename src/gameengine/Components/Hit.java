/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Collider;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;
import gameengine.Observer.Subscriber;

/**
 *
 * @author angelo
 */
public class Hit extends Component implements Subscriber{
    
    private Collider col;
    private int health;
    private int maxHealth = 1;
    
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
    }
    
    @Override
    public void onNotified(){
        health--;
        if(health<=0){
            EntityHandler.removeEntity(gameObject);
        }
    }
}
