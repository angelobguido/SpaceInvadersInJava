/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.Drawable;
import graphics.GraphicsId;
import graphics.TerminalInterface;
import graphics.VisualInterface;
import gamemath.Vector2D;
import java.util.Stack;

/**
 * Will store the drawable objects until the next update call. 
 * Delegating the drawing to the visual interface.
 * 
 * @author angelo
 */
public class Graphics {
    
    private static VisualInterface visualInterface; //visual interface that will draw the stored drawables.
    private static Stack<Drawable> renderBuffer = new Stack<>(); //will store the drawables for the next update>
    private static Stack<Drawable> undrawBuffer = new Stack<>(); //will store all the draws that are going to be deleted in next update.
    
    /**
     * Set the current visual interface.
     * 
     * @param chosenInterface is desired visual interface
     */
    public static void setGraphics(VisualInterface chosenInterface){
        visualInterface = chosenInterface;
    }
    
    /**
     * Will put the drawable object inside the buffer.
     * 
     * @param object is the object tha you want to draw in the next update.
     */
    public static void putInRenderBuffer(Drawable object){
        renderBuffer.push(object);
    }
    
    /**
     * Will put the drawable object inside the buffer to undraw.
     * 
     * @param object is the object tha you want to undraw in the next update.
     */
    public static void putInUndrawBuffer(Drawable object){
        undrawBuffer.push(object);
    }
    
    /**
     * Will draw all of the drawable objects that are stored inside the buffer.
     * Delegating the draw part to the visual interface.
     */
    public static void update(){
        while(renderBuffer.empty()==false){
            visualInterface.draw(renderBuffer.pop());
        }
        
        while(undrawBuffer.empty()==false){
            visualInterface.undraw(undrawBuffer.pop());
        }
        
        visualInterface.update();
    }
}
