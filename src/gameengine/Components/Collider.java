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
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class Collider extends Component {
    
    private Publisher publisher;
    private Rectangle colliderBox;
    private ArrayList<Collider> colliders; //colliders that this collider will collide with
    private ArrayList<Collider> otherColliders; //colliders that will collide with this collider
    private Stack<Collider> removedCollidersBuffer; //buffer that will store all colliders that will be removed
    
    public Collider(GameObject gameObject){
        super(gameObject, ComponentId.Collider);
        
        publisher = new Publisher();
        
        colliderBox = new Rectangle(gameObject.getPositionReference());
        
        colliders = new ArrayList<>();
        otherColliders = new ArrayList<>();
        removedCollidersBuffer = new Stack<>();
        
    }
    
    public Collider(GameObject gameObject, float width, float height){
        super(gameObject, ComponentId.Collider);
        
        publisher = new Publisher();
        
        colliderBox = new Rectangle(width, height, gameObject.getPositionReference());
        
        colliders = new ArrayList<>();
        otherColliders = new ArrayList<>();
        removedCollidersBuffer = new Stack<>();
        
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        Collider newCollider = new Collider(gameObject);
        
        newCollider.publisher = new Publisher();
        
        newCollider.colliderBox = new Rectangle(colliderBox.width(), colliderBox.height(), gameObject.getPositionReference());
        
        newCollider.colliders = new ArrayList<>(colliders);
        newCollider.otherColliders = new ArrayList<>(otherColliders);
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
            if(colliderBox.isInContact(colliders.get(i).getColliderBox()) == true){
                CollisionHandler.putInCollisionBuffer(this);
                CollisionHandler.putInCollisionBuffer(colliders.get(i));
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
    
    /**
     *  Will get the current collider box.
     * 
     * @return the rectangle that represents the collider.
     */
    public Rectangle getColliderBox(){
        return new Rectangle(colliderBox);
    }
    
    /**
     * Will change the collider box dimensions.
     *
     * @param newWidth
     * @param newHeight
     */
    public void changeColliderBoxDimensions(float newWidth, float newHeight){
        colliderBox.setDimensions(newWidth, newHeight);
    }
    
    /**
     * Will subscribe an object to listen collisions.
     *
     * @param s
     */
    public void subscribe(Subscriber s){
        publisher.subscribe(s);
    }
    
    /**
     * Will unsubscribe an object to not listen collisions.
     *
     * @param s
     */
    public void unsubscribe(Subscriber s){
        publisher.unsubscribe(s);
    }
    
    /**
     * Will add a new collider to collide with.
     *
     * @param c
     */
    public void addCollider(Collider c){
        if(c == null){
            return;
        }
        
        if(colliders.contains(c) == false){
            colliders.add(c);
        }
        
        if(c.otherColliders.contains(this) == false){
            c.otherColliders.add(this);
        }
        
    }
    
    /**
     * Will add a new collider to this and will add this collider to the new collider.
     *
     * @param c
     */
    public void addTwoWayCollider(Collider c){
        
        
        addCollider(c);
        
        if(c == null){
            return;
        }
        
        c.addCollider(this);
    }
    
    /**
     * Will remove a collider in the next update or destroy.
     *
     * @param c
     */
    public void removeCollider(Collider c){
        removedCollidersBuffer.push(c);
    }
    
    /**
     * Will notify a collision to all subscribers.
     *
     */
    public void notifyCollision(){
        publisher.notifySubscribers();
    }
    
}
