/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class Graphics {
    
    private static VisualInterface visualInterface;
   
    public static void setGraphics(GraphicsId id){
        
        switch(id){
            case Terminal: visualInterface = new TerminalInterface(30, 30); break;
            case GraphicInterface: break;
        }
    }
    
    public static void draw(Sprite sprite, Vector2D position){
        visualInterface.draw(sprite, position);
    }
}
