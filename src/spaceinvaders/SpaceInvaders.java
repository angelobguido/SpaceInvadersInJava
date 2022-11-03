/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.SceneManager;
import graphics.TerminalInterface;
import static spaceinvaders.SceneBuilder.SceneId.GameMain;

/**
 *
 * @author angelo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Graphics.setGraphics(new TerminalInterface(40, 40));
        SceneManager.loadScene(SceneBuilder.create(GameMain));
        
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
