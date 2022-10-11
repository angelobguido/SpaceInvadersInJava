/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.Observer.Publisher;
import gameengine.Observer.Subscriber;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class Collider extends Component {
    
    private Publisher publisher; 
    private boolean hasCollided;
    private Vector<Collider> colliders; //colliders that will collide with this collider
    
    public Collider(GameObject gameObject){
        super(gameObject, ComponentId.Collider);
        publisher = new Publisher();
    }
    
    public void subscribe(Subscriber s){
        publisher.subscribe(s);
    }
    
    public void addCollider(Collider c){
        colliders.add(c);
    }
    
    @Override
    public void update(){
        checkCollisions();
        if(hasCollided){
            //Collision Handler -> will notify all subscribers for this collider in update
        }
    }
    
    private void checkCollisions(){
        hasCollided = true;
    }
}
