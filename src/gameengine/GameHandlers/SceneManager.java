/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import gameengine.GameHandlers.SpaceInvaders.HealthManager;
import gameengine.GameObject;
import gameengine.GameScene;
import gameengine.MenuScene;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author angelo
 */
public class SceneManager {

    private static GameScene current;
    private static boolean canChange = false;
    private static Stage stage;
    
    public static void loadGameScene(GameScene scene){
        current = scene;
        canChange = true;
    }
    
    public static void loadMenuScene(MenuScene scene){
        GameAudioHandler.stopPlayingBackGround();
        if(scene.isMain) 
            GameAudioHandler.playMainScreenMusic();
        
        if(scene.isGameOver) 
            GameAudioHandler.playGameOver();
        
        if(stage != null){
                Platform.runLater(()->{stage.setScene(scene.getScene());});
        }
    }
    
    public static GraphicsContext getGameScreen(){
        return current.gameScreen();
    }
    
    public static void setStage(Stage stage){
        SceneManager.stage = stage;
    }
    
    public static void update(){
        if(canChange == true){
            ArrayList<GameObject> newEntities = current.getEntities();
            
            HealthManager.reset();
            EntityHandler.reset();
            EventHandler.reset();
            PhysicsHandler.reset();
            
            EntityHandler.addEntitiesNow(newEntities);
            
            canChange = false;
            
            if(stage != null){
                Platform.runLater(()->{stage.setScene(current.getScene());});
            }
            
        }
    }
    
}
