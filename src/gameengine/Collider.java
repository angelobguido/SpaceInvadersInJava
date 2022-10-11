/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.Observer.Publisher;
import gameengine.Observer.Subscriber;
import gameengine.Shape.Rectangle;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class Collider extends Component {
    
    private Publisher publisher;
    private Rectangle colliderBox;
    private boolean isColliding;
    private Vector<Collider> colliders; //colliders that will collide with this collider
    
    public Collider(GameObject gameObject){
        super(gameObject, ComponentId.Collider);
        publisher = new Publisher();
        colliderBox = new Rectangle(gameObject.getPositionReference());
        colliders = new Vector<>();
        isColliding = false;
    }
    
    public Rectangle getColliderBox(){
        return new Rectangle(colliderBox);
    }
    
    public void subscribe(Subscriber s){
        publisher.subscribe(s);
    }
    
    public void addCollider(Collider c){
        colliders.add(c);
    }
    
    public void notifyCollision(){
        publisher.notifySubscribers();
    }
    
    @Override
    public void update(){
        checkCollisions();
        if(isColliding){
            CollisionHandler.putInCollisionBuffer(this);
        }
    }
    
    @Override
    public void start(){
        
    }
    
    private void checkCollisions(){
        for(int i = 0; i < colliders.size(); i++){
            if(colliderBox.isInContact(colliders.elementAt(i).getColliderBox()) == true){
                isColliding = true;
                return;
            }
        }
        isColliding = false;
    }
}
