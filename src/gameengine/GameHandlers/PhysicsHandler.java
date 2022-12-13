/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.PhysicsElement;
import gamemath.Vector2D;
import java.util.Stack;

/**
 * Represents the physics of the game. It will save all the movements to do
 * them all after update.
 *
 * @author angelo
 */
public class PhysicsHandler {
    
    private static Stack<PhysicsElement> buffer = new Stack<>();
    
    /**
     * Will put the physics element inside the buffer.
     * 
     * @param pe 
     */
    public static void putInBuffer(PhysicsElement pe){
        buffer.push(pe);
    }
    
    /**
     * Will update the state of the handler. Moving the position of all 
     * entities inside the physics elements.
     */
    public static void update(){
        while(!buffer.empty()){
            moveEntity(buffer.pop());
        }
    }
    
    private static void moveEntity(PhysicsElement pe){
        pe.entity.setPosition(Vector2D.addVectors(pe.entity.position(), pe.translation));
    }
    
    /**
     * Will reset this handler. Removing all PhysicsElement's.
     */
    public static void reset(){
        buffer.clear();
    }
}
