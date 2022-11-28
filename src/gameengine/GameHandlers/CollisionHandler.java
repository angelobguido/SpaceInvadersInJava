/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.Components.Collider;
import gameengine.GameInitializer;
import java.util.Stack;

/**
 * Will handle all collisions of the game.
 * 
 * @author angelo
 */
public class CollisionHandler {
    
    private static Stack<Collider> buffer = new Stack<>(); //will store all the colliders that collided for update
   
    /**
     * This function will put the chosen collider to the collision buffer.
     * 
     * @param c is the collider that collided to something. 
     */
    public static void putInCollisionBuffer(Collider c){
        if(buffer.contains(c) == false){
            
            buffer.push(c);
        }
        
    }
    
    /**
     * Will notify the collision of all colliders stored in the buffer.
     */
    public static void update(){
        while(buffer.empty()==false){
            (buffer.pop()).notifyCollision();
        }
    }
    
    public static void reset(){
        buffer.clear();
    }
}
