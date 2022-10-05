/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class Physics extends Component{
    
    private Vector2D velocity = Vector2D.zero;
    
    public Physics(GameObject gameObject){
        super(gameObject, ComponentId.Physics);
    }
    
    public void move(Vector2D newPosition){
        gameObject.setPosition(newPosition);
    }
    
    public Vector2D velocity(){
        return velocity;
    }
    
    public void setVelocity(Vector2D newVelocity){
        velocity = newVelocity;
    }
    
    public void update(){
        move(Vector2D.addVectors(velocity, gameObject.position()));
    }
}
