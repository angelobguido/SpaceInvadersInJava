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
    
    public static Vector<GameObject> findWithTag(String tag){ //will find all entities with this tag, and return the collection of them
        
        Vector<GameObject> taggedEntities = new Vector<>();
        
        for(int i = 0; i < entities.size(); i++){
            
            GameObject currentEntity = entities.elementAt(i);
            
            if(currentEntity.tagIsEqual(tag)){
                taggedEntities.add(currentEntity);
            }
        }
        
        return taggedEntities;
    
    }
    
    public static void addEntity(GameObject gameObject){
        newEntities.push(gameObject);
    }
    
    public static void removeEntity(GameObject gameObject){
        removeBuffer.push(gameObject);
    }
    
    public static void update(){
        
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
        
        entities.forEach(entity -> {entity.update();});
    } 
}
