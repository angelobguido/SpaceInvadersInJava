/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import gameengine.GameObject;
import java.util.ArrayList;
import java.util.Stack;


/**
 * Will handle all the entities of the game. The creantion, removal, and the update.
 * 
 * @author angelo
 */
public class EntityHandler {
    private static ArrayList<GameObject> entities = new ArrayList<>(); //list of all present game objects
    private static Stack<GameObject> newEntities = new Stack<>(); //buffer that will store recent added entities
    private static Stack<GameObject> removeBuffer = new Stack<>(); //buffer that will store entities that need to be removed in update
    
    /**
     * This function will find a collection of game objects that have the chosen tag inside entities list.
     * 
     * @param tag is the tag that represents all the game objects you want to find in the game world.
     * @return the list of game objects that have the chosen tag.
     */
    public static ArrayList<GameObject> findWithTag(String tag){ 
        
        ArrayList<GameObject> taggedEntities = new ArrayList<>();
        
        for(int i = 0; i < entities.size(); i++){
            
            GameObject currentEntity = entities.get(i);
            
            if(currentEntity.tagIsEqual(tag)){
                taggedEntities.add(currentEntity);
            }
        }
        
        return taggedEntities;
    
    }
    
    /**
     * This function will find a collection of game objects that have the chosen tag inside entities list and all children.
     * 
     * @param tag is the tag that represents all the game objects you want to find in the game world.
     * @return the list of game objects that have the chosen tag.
     */
    public static ArrayList<GameObject> findAllWithTag(String tag){ 
                
        ArrayList<GameObject> taggedEntities = new ArrayList<>();
        
        for(int i = 0; i < entities.size(); i++){
            
            GameObject currentEntity = entities.get(i);
            
            if(currentEntity.tagIsEqual(tag)){
                taggedEntities.add(currentEntity);
            }
            
            _findTagRecursive(taggedEntities, currentEntity, tag);
        }
        
        return taggedEntities;
    
    }
    
    private static void _findTagRecursive(ArrayList<GameObject> taggedEntities, GameObject current, String tag){
        
        for(int i = 0; i < current.childCount(); i++){
            if(current.getChild(i).tagIsEqual(tag)){
                taggedEntities.add(current.getChild(i));
            }
            _findTagRecursive(taggedEntities, current.getChild(i), tag);
        }
        
    }
    
    /**
     * Add a new game object to the game world after frame.
     * 
     * @param gameObject is the game object you want to add.
     */
    public static void addEntity(GameObject gameObject){
        newEntities.push(gameObject);
    }
    
    /**
     * Add a list of new game object to the game world now.
     * It is not recommended to use inside game components.
     * 
     * @param gameObjects is the game object list you want to add at this moment.
     */
    public static void addEntitiesNow(ArrayList<GameObject> gameObjects){
        for(int i = 0; i < gameObjects.size(); i++){
            entities.add(gameObjects.get(i));
        }
        for(int i = 0; i < gameObjects.size(); i++){
            gameObjects.get(i).start();
        }
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
     * Remove all game objects that existis in the entities list.
     * 
     */
    public static void removeAllEntities(){
       while(entities.isEmpty() == false){
           entities.get(entities.size()-1).destroy();
           entities.remove(entities.size()-1);
       }
    }
    
    /**
     * Will update all game objects inside the entities list and manager the entities life cycle.
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
