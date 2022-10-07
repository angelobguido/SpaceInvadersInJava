/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.GameObject;
import gameengine.Sprite;
import gameengine.Graphics;
import gameengine.GraphicsId;
import gamemath.Vector2D;
import java.util.Vector;
/**
 *
 * @author angelo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Graphics.setGraphics(GraphicsId.Terminal);
        
        GameObject alien = GameObjectBuilder.create(Prefab.Alien);
        
        while(true){
            Graphics.clean();
            alien.update();
            Thread.sleep(500);
        }
        
        
    }
    
}
