/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class Scene {
    private ArrayList<GameObject> sceneEntities;
    
    public Scene(){
        sceneEntities = new ArrayList<>();
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
