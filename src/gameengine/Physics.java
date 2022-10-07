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
    
    public Vector2D velocity = Vector2D.zero;
    
    public Physics(GameObject gameObject){
        super(gameObject, ComponentId.Physics);
    }
    
    
    @Override
    public void update(){
        gameObject.position = (Vector2D.addVectors(velocity, gameObject.position));
        for(int i = 0; i<gameObject.childCount(); i++){
            gameObject.getChild(i).position = Vector2D.addVectors(velocity, gameObject.getChild(i).position);
        }
    }
}
