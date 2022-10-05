/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.*;

/**
 *
 * @author angelo
 */

public class GameObjectBuilder {
    enum Prefab{Alien, Player, Obstacle}
    
    public static GameObject create(Prefab prefab){
        
        GameObject gameObject = new GameObject();
        
        switch(prefab){
            case Alien: 
                
                gameObject.addComponent(new SpriteRenderer(gameObject, null));
                gameObject.addComponent(new Physics(gameObject));
                
                break;
            
            case Player:
                
                gameObject.addComponent(new SpriteRenderer(gameObject, null));
                gameObject.addComponent(new Physics(gameObject));
                
                break;
            
            case Obstacle:
                
                gameObject.addComponent(new SpriteRenderer(gameObject, null));
                gameObject.addComponent(new Physics(gameObject));
                
                break;
        }
        
        return gameObject;
    }
    
}
