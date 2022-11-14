/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.GameHandlers.SceneManager;
import graphics.VisualInterface;
import javafx.stage.Stage;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.SceneId.GameMain;

/**
 *
 * @author angelo
 */
public class GameInitializer {
    public static void init(VisualInterface vi, Stage primaryStage) throws Exception{
        SceneManager.setStage(primaryStage);
        Graphics.setGraphics(vi);
        SceneManager.loadScene(SceneBuilder.create(GameMain));
        SceneManager.update();
        
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
