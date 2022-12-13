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
 * Represents the manager of scenes. It will change scene to be a desired Game Scene,
 * or Menu Scene.
 *
 * @author angelo
 */
public class SceneManager {

    private static GameScene current;
    private static boolean canChange = false;
    private static Stage stage;
    
    /**
     * Will load a new Game Scene.
     * 
     * @param scene 
     */
    public static void loadGameScene(GameScene scene){
        current = scene;
        canChange = true;
    }
    
    /**
     * Will load a new Menu Scene. 
     * 
     * @param scene 
     */
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
    
    /**
     * Will get the current GraphicsContext that represents the game screen.
     * 
     * @return the game screen.
     */
    public static GraphicsContext getGameScreen(){
        return current.gameScreen();
    }
    
    /**
     * Will set the JavaFX stage of the game.
     * 
     * @param stage 
     */
    public static void setStage(Stage stage){
        SceneManager.stage = stage;
    }
    
    /**
     * Will update the manager state. After each frame will verify if the 
     * Game Scene was required to change, and change it.
     */
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
