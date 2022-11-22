/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.GameHandlers.InputHandler;
import gameengine.GameHandlers.SceneManager;
import graphics.GraphicInterface;
import graphics.TerminalInterface;
import graphics.VisualInterface;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.SceneId.GameMain;

/**
 *
 * @author angelo
 */
public class GameInitializer {
    
    private static boolean hasStopped = false;
    
    public static void init(Stage primaryStage) throws Exception{
        SceneManager.setStage(primaryStage);
        Graphics.setGraphics(new GraphicInterface());
        SceneManager.loadScene(SceneBuilder.create(GameMain));
        SceneManager.update();
        
        Thread t = new Thread( () ->{
            
            while(hasStopped == false){
                
                Graphics.update();
                CollisionHandler.update();
                EventHandler.update();
                EntityHandler.update();
                SceneManager.update();

                try{
                    Thread.sleep(50);
                }catch(Exception e){
                    System.exit(1);
                }
                
                InputHandler.update();

            }
            
        });
        
        t.start();
        
    }
    
    public static void stop(){
        hasStopped = true;
    }
}
