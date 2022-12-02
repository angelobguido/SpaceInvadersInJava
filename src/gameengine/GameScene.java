/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

/**
 *
 * @author angelo
 */
public class GameScene {
    private ArrayList<GameObject> sceneEntities = sceneEntities = new ArrayList<>();
    private Scene fxScene;
    private StackPane gameRoot;
    private GraphicsContext gameScreen;
    
    public Scene getScene(){
        return fxScene;
    }
    
    public StackPane getRoot(){
        return gameRoot;
    }
    
    public void setScene(Scene fxScene){
        this.fxScene = fxScene;
    }
    
    public void setRoot(StackPane gameRoot){
        this.gameRoot = gameRoot;
    }
    
    public void setCanvasPane(GraphicsContext canvasPane){
        this.gameScreen = canvasPane;
    }
    
    public GraphicsContext gameScreen(){
        return gameScreen;
    }
    
    public void addEntity(GameObject newEntity){
        sceneEntities.add(newEntity);
    }
    
    public ArrayList<GameObject> getEntities(){
        
        ArrayList<GameObject> entityList = new ArrayList<>();
        
        for(int i = 0; i < sceneEntities.size(); i++){
            entityList.add(new GameObject(sceneEntities.get(i)));
        }
        
        return entityList;
    }
}
