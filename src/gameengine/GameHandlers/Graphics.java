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
 *
 * @author angelo
 */
public class Graphics {
    
    private static VisualInterface visualInterface;
    private static Stack<Drawable> buffer = new Stack<>();
   
    public static void setGraphics(GraphicsId id){
        switch(id){
            case Terminal: visualInterface = new TerminalInterface(40, 40); break;
            case GraphicInterface: break;
        }
    }
    public static void putInRenderBuffer(Drawable object){
        buffer.push(object);
    }
    
    public static void clean(){
        visualInterface.clean();
    }
    
    public static void update(){
        while(buffer.empty()==false){
            visualInterface.draw(buffer.pop());
        }
        visualInterface.update();
    }
}
