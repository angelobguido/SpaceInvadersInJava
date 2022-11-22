/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameObject;
import gameengine.GameScene;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author angelo
 */
public class SceneManager {

    private static GameScene current;
    private static boolean canChange = false;
    private static Stage stage;
    
    public static void loadScene(GameScene newScene){
        current = newScene;
        canChange = true;
    }
    
    public static StackPane getCurrentRoot(){
       return current.getRoot();
    }
    
    public static void setStage(Stage stage){
        SceneManager.stage = stage;
    }
    
    public static void update(){
        if(canChange == true){
            ArrayList<GameObject> newEntities = current.getEntities();
            
            EntityHandler.removeAllEntities();
            EntityHandler.addEntitiesNow(newEntities);
            
            canChange = false;
            
            if(stage != null){
                Platform.runLater(()->{stage.setScene(current.getScene());});
            }
            
        }
    }
    
}
