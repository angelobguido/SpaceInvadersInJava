/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import graphics.GraphicsId;
import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.SceneManager;

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
        SceneManager.loadScene(SceneBuilder.create(SceneId.GameMain));
        
        while(true){
            Graphics.clean();
            Graphics.update();
            CollisionHandler.update();
            EventHandler.update();
            EntityHandler.update();
            SceneManager.update();
            Thread.sleep(50);
        }
        
    }
    
}
