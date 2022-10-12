/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.Components.Collider;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class CollisionHandler {
    
    private static Stack<Collider> buffer = new Stack<>(); //will store all the colliders that collided for update
   
    public static void putInCollisionBuffer(Collider c){
        if(buffer.contains(c) == false){
            buffer.push(c);
        }
        
    }
    
    public static void update(){
        while(buffer.empty()==false){
            (buffer.pop()).notifyCollision();
        }
    }
}
