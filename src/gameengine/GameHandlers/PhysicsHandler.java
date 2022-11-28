/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.PhysicsElement;
import java.util.Stack;

/**
 *
 * @author angelo
 */
public class PhysicsHandler {
    
    private static Stack<PhysicsElement> buffer;
    
    public static void putInBuffer(PhysicsElement pe){
        buffer.push(pe);
    }
    
    public static void update(){
        
    }
}
