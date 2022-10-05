/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.Graphics;
import gameengine.GraphicsId;
import gamemath.Vector2D;
/**
 *
 * @author angelo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graphics.setGraphics(GraphicsId.Terminal);
        Graphics.draw(null, Vector2D.up);
    }
    
}
