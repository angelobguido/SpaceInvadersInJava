/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.Drawable;
import gameengine.GraphicsId;
import gameengine.TerminalInterface;
import gameengine.VisualInterface;
import gamemath.Vector2D;
import java.util.Stack;

/**
 * Will store the drawable objects until the next update call. 
 * Delegating the drawing to the visual interface.
 * 
 * @author angelo
 */
public class Graphics {
    
    private static VisualInterface visualInterface; //visual interface that will draw the stored drawables
    private static Stack<Drawable> buffer = new Stack<>(); //will store the drawables for the next update
   
    /**
     * Set the current visual interface.
     * 
     * @param id is the representation of the desired visual interface
     */
    public static void setGraphics(GraphicsId id){
        switch(id){
            case Terminal: visualInterface = new TerminalInterface(40, 40); break;
            case GraphicInterface: break;
        }
    }
    
    /**
     * Will put the drawable object inside the buffer.
     * 
     * @param object is the object tha you want to draw in the next update.
     */
    public static void putInRenderBuffer(Drawable object){
        buffer.push(object);
    }
    
    /**
     * Will clear the screen of the visual interface.
     */
    public static void clean(){
        visualInterface.clean();
    }
    
    /**
     * Will draw all of the drawable objects that are stored inside the buffer.
     * Delegating the draw part to the visual interface.
     */
    public static void update(){
        while(buffer.empty()==false){
            visualInterface.draw(buffer.pop());
        }
        visualInterface.update();
    }
}
