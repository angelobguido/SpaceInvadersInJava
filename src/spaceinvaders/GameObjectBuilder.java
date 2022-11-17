/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.Components.SpaceInvaders.PlayerAttack;
import gameengine.Components.SpaceInvaders.PlayerController;
import gameengine.Components.SpaceInvaders.Hit;
import gameengine.Components.SpaceInvaders.AlienAttack;
import gameengine.Components.SpaceInvaders.BulletLife;
import gameengine.Components.SpaceInvaders.AlienMatrixLife;
import gameengine.Components.SpaceInvaders.AlienMatrixController;
import gameengine.Components.*;
import gameengine.*;
import gamemath.Vector2D;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static spaceinvaders.Prefab.Bullet;

/**
 * Builder used to build the space invaders game objects.
 * @author angelo
 */

enum Prefab{Alien, Player, Obstacle, BigObstacle, AliensLine, AliensMatrix, Bullet}

public class GameObjectBuilder {
    
    private static GameObject alien;
    private static GameObject player;
    private static GameObject obstacle;
    private static GameObject bigObstacle;
    private static GameObject aliensLine;
    private static GameObject aliensMatrix;
    private static GameObject bullet;

    
    /**
     * Static function that builds the desired game object.
     * @param prefab is the id of the game object you want to build.
     * @return the game object builded.
     */
    public static GameObject create(Prefab prefab){
        
        GameObject gameObject = new GameObject();
        
        switch(prefab){
            case Alien: 
                
                if(alien != null) return new GameObject(alien);
                
                ArrayList<Vector2D> alienStructure = new ArrayList<>();
                
                alienStructure.add(Vector2D.zero);
                
                Sprite alienSprite = new Sprite();
                alienSprite.charRepresentation = '$';
                alienSprite.spriteStructure = alienStructure;
                alienSprite.content = new GameImage();
                
                gameObject.addComponent(new SpriteRenderer(gameObject, alienSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new Collider(gameObject));
                gameObject.addComponent(new Hit(gameObject));
                gameObject.addComponent(new AlienAttack(gameObject, GameObjectBuilder.create(Bullet)));
                
                gameObject.setTag("Alien");
                
                alien = new GameObject(gameObject);
                
                break;
            
            case Player:
                
                if(player != null) return new GameObject(player);
                
                ArrayList<Vector2D> playerStructure = new ArrayList<>();
                
                playerStructure.add(Vector2D.zero);
                playerStructure.add(new Vector2D(0,-1));
                playerStructure.add(new Vector2D(1,-1));
                playerStructure.add(new Vector2D(-1,-1));
                
                ArrayList<Vector2D> playerBulletStructure = new ArrayList<>();
                
                playerBulletStructure.add(Vector2D.zero);

                Sprite playerBulletSprite = new Sprite();
                playerBulletSprite.charRepresentation = '1';
                playerBulletSprite.spriteStructure = playerBulletStructure;
                playerBulletSprite.content = new GameImage();
                
                
                GameObject playerBullet = GameObjectBuilder.create(Bullet);
                ((SpriteRenderer)playerBullet.getComponent(ComponentId.SpriteRenderer)).setSprite(playerBulletSprite);
                
                Sprite playerSprite = new Sprite();
                playerSprite.charRepresentation = '%';
                playerSprite.spriteStructure = playerStructure;
                Image playerImage = new Image(GameObjectBuilder.class.getResource("player.png").toExternalForm());
                
                playerSprite.content = new GameImage(playerImage, 60, 60);
                
                Collider playerCollider = new Collider(gameObject);
                playerCollider.changeColliderBoxDimensions(3, 3);
                gameObject.addComponent(playerCollider);
                gameObject.addComponent(new SpriteRenderer(gameObject, playerSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new PlayerAttack(gameObject, playerBullet));
                gameObject.addComponent(new PlayerController(gameObject));
                gameObject.addComponent(new Hit(gameObject, 3));
                
                gameObject.setTag("Player");
                
                player = new GameObject(gameObject);
                
                break;
            
            case Obstacle:
                
                
                if(obstacle != null) return new GameObject(obstacle);
                
                ArrayList<Vector2D> obstacleStructure = new ArrayList<>();
                
                obstacleStructure.add(Vector2D.zero);
                
                Sprite obstacleSprite = new Sprite();
                obstacleSprite.charRepresentation = '@';
                obstacleSprite.spriteStructure = obstacleStructure;
                obstacleSprite.content = new GameImage();
                
                gameObject.addComponent(new Collider(gameObject));
                gameObject.addComponent(new SpriteRenderer(gameObject, obstacleSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new Hit(gameObject, 2));
                
                gameObject.setTag("Obstacle");
                
                obstacle = new GameObject(gameObject);
                
                break;
            
            case BigObstacle:
                
                if(bigObstacle != null) return new GameObject(bigObstacle);
                
                GameObject obstacleCopy;
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(i, 0));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(i, 1));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(i, 2));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -1; i < 2; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(i, 3));
                    gameObject.addChild(obstacleCopy);
                }
                
                gameObject.setTag("BigObstacle");
                
                
                bigObstacle = new GameObject(gameObject);
                
                
                break;
                
            case AliensLine:
                
                if(aliensLine != null) return new GameObject(aliensLine);
                
                GameObject alienCopy;
                
                for(int i = 0; i<11; i++){
                    alienCopy = GameObjectBuilder.create(Prefab.Alien);
                    alienCopy.setPosition(new Vector2D(2*i, 0));
                    gameObject.addChild(alienCopy);
                }
                
                gameObject.setTag("AliensLine");
                
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
                gameObject.addComponent(new AlienMatrixLife(gameObject));
                gameObject.addComponent(new AlienMatrixController(gameObject));
                
                gameObject.setTag("AliensMatrix");
                
                aliensMatrix = new GameObject(gameObject);
                
                break;
                
            case Bullet:
                
                if(bullet != null) return new GameObject(bullet);
                
                ArrayList<Vector2D> bulletStructure = new ArrayList<>();
                
                bulletStructure.add(Vector2D.zero);

                Sprite bulletSprite = new Sprite();
                bulletSprite.charRepresentation = '0';
                bulletSprite.spriteStructure = bulletStructure;
                bulletSprite.content = new GameImage();
                
                Physics bulletPhysics = new Physics(gameObject);
                bulletPhysics.velocity = new Vector2D(0,0.1f);
                
                gameObject.addComponent(bulletPhysics);
                gameObject.addComponent(new Collider(gameObject));
                gameObject.addComponent(new SpriteRenderer(gameObject, bulletSprite));
                gameObject.addComponent(new Hit(gameObject));
                gameObject.addComponent(new BulletLife(gameObject));
                
                gameObject.setTag("Bullet");
                
                bullet = new GameObject(gameObject);
                
                break;
            
        }
        
        return gameObject;
    }
    
}
