/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameObject;
import gameengine.Scene;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class SceneManager {

    private static Scene current;
    private static boolean canChange = false;
    
    public static void loadScene(Scene newScene){
        current = newScene;
        canChange = true;
    }
    
    public static void update(){
        if(canChange == true){
            ArrayList<GameObject> newEntities = current.getEntities();
            
            EntityHandler.removeAllEntities();
            
            while(newEntities.isEmpty() == false){
                EntityHandler.addEntity(newEntities.get(0));
                newEntities.remove(0);
            }
            
            canChange = false;
            
        }
    }
    
}
