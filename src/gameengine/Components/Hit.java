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
    
    public Hit(GameObject gameObject){
        super(gameObject, ComponentId.Hit);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        Hit newHit = new Hit(gameObject);
        
        return newHit;
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        col = (Collider)gameObject.getComponent(ComponentId.Collider);
        col.subscribe(this);
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
        EntityHandler.removeEntity(gameObject);
    }
}
