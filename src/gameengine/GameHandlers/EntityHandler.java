/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameObject;
import java.util.Vector;
import java.util.Stack;


/**
 *
 * @author angelo
 */
public class EntityHandler {
    private static Vector<GameObject> entities = new Vector<>();
    private static Stack<GameObject> newEntities = new Stack<>(); //buffer that will store recent added entities
    private static Stack<GameObject> removeBuffer = new Stack<>(); //buffer that will store entities that need to be removed in update
    
    public static void addEntity(GameObject gameObject){
        newEntities.push(gameObject);
    }
    
    public static void removeEntity(GameObject gameObject){
        removeBuffer.push(gameObject);
    }
    
    public static void update(){
        
        entities.forEach(entity -> {entity.update();});
        
        while(newEntities.empty()==false){
            GameObject newEntity = newEntities.pop();
            newEntity.start();
            entities.add(newEntity);
        }
        
        while(removeBuffer.empty()==false){
            GameObject removedEntity = removeBuffer.pop();
            removedEntity.destroy();
            entities.remove(removedEntity);
        }
        
        
    } 
}
