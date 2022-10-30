/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;
import gameengine.Observer.Subscriber;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class AlienMatrixLife extends Component implements Subscriber {
    private int life = 0;
    private boolean hasFoundAliens = false;
    private Physics aliensPhysics;
    
    public AlienMatrixLife(GameObject gameObject){
        super(gameObject, ComponentId.AlienMatrixLife);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        AlienMatrixLife newAlienMatrixLife = new AlienMatrixLife(gameObject);
        return newAlienMatrixLife;
    }
    
    @Override
    public void update(){
        if(!hasFoundAliens){
            ArrayList<GameObject> aliens = EntityHandler.findAllWithTag("Alien");
            for(int i = 0; i < aliens.size(); i++){
                hasFoundAliens = true;
                ((Hit)aliens.get(i).getComponent(ComponentId.Hit)).deathEvent.subscribe(this);
                life++;
            }
        }
    }
    
    @Override
    public void start(){
        aliensPhysics = (Physics)gameObject.getComponent(ComponentId.Physics);
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
    }
    
    @Override
    public void onNotified(){
        life--;
        Vector2D newVelocity = Vector2D.multiplyByScalar(aliensPhysics.velocity, 1.02f);
        aliensPhysics.velocity = newVelocity;
    }
}