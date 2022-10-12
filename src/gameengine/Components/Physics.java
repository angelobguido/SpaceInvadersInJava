/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameObject;
import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class Physics extends Component{
    
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
        gameObject.setPosition(Vector2D.addVectors(velocity, gameObject.position()));
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
