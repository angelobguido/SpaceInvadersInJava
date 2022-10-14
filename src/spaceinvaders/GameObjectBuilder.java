/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.Components.Hit;
import gameengine.Components.SpriteRenderer;
import gameengine.Components.Physics;
import gameengine.Components.Collider;
import gameengine.*;
import gamemath.Vector2D;
import java.util.Vector;

/**
 *
 * @author angelo
 */

enum Prefab{Alien, Player, Obstacle, AliensLine, AliensMatrix, Bullet}

public class GameObjectBuilder {
    
    private static GameObject alien;
    private static GameObject player;
    private static GameObject obstacle;
    private static GameObject aliensLine;
    private static GameObject aliensMatrix;
    private static GameObject bullet;

    
    public static GameObject create(Prefab prefab){
        
        GameObject gameObject = new GameObject();
        
        switch(prefab){
            case Alien: 
                
                if(alien != null) return new GameObject(alien);
                
                
                Vector<Vector2D> alienStructure = new Vector<>();
                
                alienStructure.add(Vector2D.zero);
                
                Sprite alienSprite = new Sprite('$', alienStructure);
                
                gameObject.addComponent(new SpriteRenderer(gameObject, alienSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new Collider(gameObject));
                gameObject.addComponent(new Hit(gameObject, 2));
                
                alien = new GameObject(gameObject);
                
                break;
            
            case Player:
                
                if(player != null) return new GameObject(player);
                
                Vector<Vector2D> playerStructure = new Vector<>();
                
                playerStructure.add(Vector2D.zero);
                
                Sprite playerSprite = new Sprite('0', playerStructure);
                
                gameObject.addComponent(new SpriteRenderer(gameObject, playerSprite));
                gameObject.addComponent(new Physics(gameObject));
                
                player = new GameObject(gameObject);
                
                break;
            
            case Obstacle:
                
                if(obstacle != null) return new GameObject(obstacle);
                
                gameObject.addComponent(new SpriteRenderer(gameObject, null));
                gameObject.addComponent(new Physics(gameObject));
                
                obstacle = new GameObject(gameObject);
                
                break;
            
            case AliensLine:
                
                if(aliensLine != null) return new GameObject(aliensLine);
                
                GameObject alienCopy;
                
                for(int i = 0; i<11; i++){
                    alienCopy = GameObjectBuilder.create(Prefab.Alien);
                    alienCopy.setPosition(new Vector2D(2*i, 0));
                    gameObject.addChild(alienCopy);
                }
                
                aliensLine = new GameObject(gameObject);
                
                break;
                
            case AliensMatrix:
                
                if(aliensMatrix != null) return new GameObject(aliensMatrix);
                
                GameObject aliensLineCopy;
                
                for(int i = 0; i < 5; i++){
                    aliensLineCopy = GameObjectBuilder.create(Prefab.AliensLine);
                    aliensLineCopy.setPosition(new Vector2D(0, 2*i));
                    gameObject.addChild(aliensLineCopy);
                }
                
                gameObject.addComponent(new Physics(gameObject));
                
                aliensMatrix = new GameObject(gameObject);
                
                break;
                
            case Bullet:
                
                if(bullet != null) return new GameObject(bullet);
                
                Vector<Vector2D> bulletStructure = new Vector<>();
                
                bulletStructure.add(Vector2D.zero);

                Sprite bulletSprite = new Sprite('O', bulletStructure);
                
                Physics bulletPhysics = new Physics(gameObject);
                bulletPhysics.velocity = new Vector2D(0,0.1f);
                
                gameObject.addComponent(bulletPhysics);
                gameObject.addComponent(new Collider(gameObject));
                gameObject.addComponent(new SpriteRenderer(gameObject, bulletSprite));
                gameObject.addComponent(new Hit(gameObject));
                
                gameObject.setPosition(new Vector2D(6,0));
                
                bullet = new GameObject(gameObject);
                
                break;
            
        }
        
        return gameObject;
    }
    
}
