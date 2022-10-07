/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.*;
import gamemath.Vector2D;
import java.util.Vector;

/**
 *
 * @author angelo
 */

enum Prefab{Alien, Player, Obstacle}

public class GameObjectBuilder {
    
    
    public static GameObject create(Prefab prefab){
        
        GameObject gameObject = new GameObject();
        
        switch(prefab){
            case Alien: 
                
                Vector<Vector2D> alienStructure = new Vector<>();
                
                alienStructure.add(Vector2D.zero);
                alienStructure.add(Vector2D.up);
                alienStructure.add(Vector2D.multiplyByScalar(Vector2D.up, 1));
                alienStructure.add(Vector2D.multiplyByScalar(Vector2D.up, 2));
                alienStructure.add(Vector2D.multiplyByScalar(Vector2D.right, 1));
                alienStructure.add(Vector2D.multiplyByScalar(Vector2D.right, 2));

                Sprite alien = new Sprite('$', alienStructure);
                
                gameObject.addComponent(new SpriteRenderer(gameObject, alien));
                
                Physics alienPhysics = new Physics(gameObject);
                alienPhysics.setVelocity(Vector2D.right);
                gameObject.addComponent(alienPhysics);
                
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
