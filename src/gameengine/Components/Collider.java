/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameObject;
import gameengine.Observer.Publisher;
import gameengine.Observer.Subscriber;
import gameengine.Shape.Rectangle;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class Collider extends Component {
    
    private Publisher publisher;
    private Rectangle colliderBox;
    private Vector<Collider> colliders; //colliders that this collider will collide with
    private Vector<Collider> otherColliders; //colliders that will collide with this collider
    private Stack<Collider> removedCollidersBuffer; //buffer that will store all colliders that will be removed
    
    public Collider(GameObject gameObject){
        super(gameObject, ComponentId.Collider);
        
        publisher = new Publisher();
        
        colliderBox = new Rectangle(gameObject.getPositionReference());
        
        colliders = new Vector<>();
        otherColliders = new Vector<>();
        removedCollidersBuffer = new Stack<>();
        
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        Collider newCollider = new Collider(gameObject);
        
        newCollider.publisher = new Publisher();
        
        newCollider.colliderBox = new Rectangle(gameObject.getPositionReference());
        
        newCollider.colliders = new Vector<>(colliders);
        newCollider.otherColliders = new Vector<>(otherColliders);
        newCollider.removedCollidersBuffer = (Stack<Collider>)removedCollidersBuffer.clone();
        
        return newCollider;
    }
    
    @Override
    public void update(){
        
        //will first remove all colliders that needs to be removed
        while(removedCollidersBuffer.isEmpty() == false){
            colliders.remove(removedCollidersBuffer.pop());
        }
        
        checkCollisions();
        
    }
    
    private void checkCollisions(){
        for(int i = 0; i < colliders.size(); i++){
            if(colliderBox.isInContact(colliders.elementAt(i).getColliderBox()) == true){
                CollisionHandler.putInCollisionBuffer(this);
                CollisionHandler.putInCollisionBuffer(colliders.elementAt(i));
            }
        }
    }
    
    @Override
    public void start(){
        
    }
    
    @Override
    public void destroy(){
        
        colliders.clear();
        colliders = null;
        
        otherColliders.forEach(collider -> {collider.removeCollider(this);});
        otherColliders = null;
        
        gameObject.removeComponent(this);
        gameObject = null;
    
    }
    
    public Rectangle getColliderBox(){
        return new Rectangle(colliderBox);
    }
    
    public void subscribe(Subscriber s){
        publisher.subscribe(s);
    }
    
    public void unsubscribe(Subscriber s){
        publisher.unsubscribe(s);
    }
    
    public void addCollider(Collider c){
        colliders.add(c);
        c.otherColliders.add(this);
    }
    public void removeCollider(Collider c){
        removedCollidersBuffer.push(c);
    }
    
    public void notifyCollision(){
        publisher.notifySubscribers();
    }
    
}