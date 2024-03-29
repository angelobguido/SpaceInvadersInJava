/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.SpaceInvaders.ScoreManager;
import gameengine.GameObject;
import gameengine.Observer.Subscriber;

/**
 * Represents the score counter. It is used to notify the ScoreManager.
 *
 * @author angelo
 */
public class ScoreCounter extends Component implements Subscriber {
    
    private int points;
    
    public ScoreCounter(GameObject gameObject, int points){
        super(gameObject, ComponentId.ScoreCounter);
        this.points = points;
    }
    
    @Override
    public Component createCopy(GameObject obj){
        return new ScoreCounter(obj, points);
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        ((Hit)gameObject.getComponent(ComponentId.Hit)).deathEvent.subscribe(this);
    }
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
    }
    
    @Override
    public void onNotified(){
        ScoreManager.increment(points);
    }
}
