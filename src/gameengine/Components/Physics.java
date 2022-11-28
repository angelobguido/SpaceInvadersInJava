/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.PhysicsHandler;
import gameengine.GameObject;
import gameengine.PhysicsElement;
import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class Physics extends Component{
    
    /**
     *  Vector2D that represnents the velocity of the game object.
     */
    public Vector2D velocity = Vector2D.zero;
    
    public Physics(GameObject gameObject){
        super(gameObject, ComponentId.Physics);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        Physics newPhysics = new Physics(gameObject);
        newPhysics.velocity = new Vector2D(velocity);
        
        return newPhysics;
    }
    
    @Override
    public void update(){
        PhysicsHandler.putInBuffer(new PhysicsElement(gameObject, velocity));
    }
    
    @Override
    public void start(){
        
    }
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject=null;
    }
}
