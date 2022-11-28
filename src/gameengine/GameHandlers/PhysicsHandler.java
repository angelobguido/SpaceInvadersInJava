/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.PhysicsElement;
import gamemath.Vector2D;
import java.util.Stack;

/**
 *
 * @author angelo
 */
public class PhysicsHandler {
    
    private static Stack<PhysicsElement> buffer = new Stack<>();
    
    public static void putInBuffer(PhysicsElement pe){
        buffer.push(pe);
    }
    
    public static void update(){
        while(!buffer.empty()){
            moveEntity(buffer.pop());
        }
    }
    
    private static void moveEntity(PhysicsElement pe){
        pe.entity.setPosition(Vector2D.addVectors(pe.entity.position(), pe.translation));
    }
    
    public static void reset(){
        buffer.clear();
    }
}
