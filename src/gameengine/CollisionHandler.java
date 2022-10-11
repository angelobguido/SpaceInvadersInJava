/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import java.util.Stack;

/**
 *
 * @author angelo
 */
public class CollisionHandler {
    
    private static Stack<Collider> buffer = new Stack<>();
   
    public static void putInCollisionBuffer(Collider c){
        buffer.push(c);
    }
    
    public static void update(){
        while(buffer.empty()==false){
            (buffer.pop()).notifyCollision();
        }
    }
}
