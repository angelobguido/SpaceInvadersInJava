/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameObject;
import java.util.Vector;
import java.util.Stack;


/**
 * Will handle all the entities of the game. The creantion, removal, and the update.
 * 
 * @author angelo
 */
public class EntityHandler {
    private static Vector<GameObject> entities = new Vector<>(); //list of all present game objects
    private static Stack<GameObject> newEntities = new Stack<>(); //buffer that will store recent added entities
    private static Stack<GameObject> removeBuffer = new Stack<>(); //buffer that will store entities that need to be removed in update
    
    /**
     * This function will find a collection of game objects that have the chosen tag.
     * 
     * @param tag is the tag that represents all the game objects you want to find in the game world.
     * @return the list of game objects that have the chosen tag.
     */
    public static Vector<GameObject> findWithTag(String tag){ 
        
        Vector<GameObject> taggedEntities = new Vector<>();
        
        for(int i = 0; i < entities.size(); i++){
            
            GameObject currentEntity = entities.elementAt(i);
            
            if(currentEntity.tagIsEqual(tag)){
                taggedEntities.add(currentEntity);
            }
        }
        
        return taggedEntities;
    
    }
    
    /**
     * Add a new game object to the game world.
     * 
     * @param gameObject is the game object you want to add.
     */
    public static void addEntity(GameObject gameObject){
        newEntities.push(gameObject);
    }
    
    /**
     * Remove a game object that existis in the entities list of all game objects in the world.
     * 
     * @param gameObject is the game object that you want to remove
     */
    public static void removeEntity(GameObject gameObject){
        removeBuffer.push(gameObject);
    }
    
    /**
     * Will update all game objects inside the entities list.
     */
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
