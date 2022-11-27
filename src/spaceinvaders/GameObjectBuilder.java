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
import gameengine.Components.SpaceInvaders.AlienController;
import gameengine.Components.SpaceInvaders.PlayerHit;
import gameengine.Components.SpaceInvaders.PowerUpController;
import gameengine.Components.SpaceInvaders.ScoreCounter;
import gameengine.Components.SpaceInvaders.UfoController;
import gamemath.Vector2D;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Builder used to build the space invaders game objects.
 * @author angelo
 */

public class GameObjectBuilder {
   
    public enum Prefab{UFO, Alien, MiddleAlien, FrontAlien, Player, Obstacle, BigObstacle, AliensMatrix, PowerUp}
    
    
    private static GameObject powerUp;
    private static GameObject ufo;
    private static GameObject alien;
    private static GameObject middleAlien;
    private static GameObject frontAlien;
    private static GameObject player;
    private static GameObject obstacle;
    private static GameObject bigObstacle;
    private static GameObject aliensMatrix;

    
    /**
     * Static function that builds the desired game object.
     * @param prefab is the id of the game object you want to build.
     * @return the game object builded.
     */
    public static GameObject create(Prefab prefab){
        
        GameObject gameObject = new GameObject();
        
        switch(prefab){
            
            case PowerUp:
                if(powerUp != null) return new GameObject(powerUp);
                
                
                ArrayList<Vector2D> powerUpStructure = new ArrayList<>();
                
                powerUpStructure.add(Vector2D.zero);
                
                Sprite powerUpSprite = new Sprite();
                powerUpSprite.charRepresentation = '?';
                powerUpSprite.spriteStructure = powerUpStructure;
                
                GameAnimation powerUpAnimation = new GameAnimation(40, 40);
                powerUpAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/power_up1.png").toExternalForm()));
                powerUpAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/power_up2.png").toExternalForm()));
                powerUpAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/power_up3.png").toExternalForm()));
                
                powerUpSprite.content = powerUpAnimation;
                
                gameObject.addComponent(new SpriteRenderer(gameObject, powerUpSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new Collider(gameObject, 3, 3));
                gameObject.addComponent(new Hit(gameObject));
                gameObject.addComponent(new PowerUpController(gameObject));
                
                gameObject.setTag("PowerUp");
                
                powerUp = new GameObject(gameObject);
                
                break;

            
            case UFO:
                
                if(ufo != null) return new GameObject(ufo);
                
                
                ArrayList<Vector2D> ufoStructure = new ArrayList<>();
                
                ufoStructure.add(Vector2D.zero);
                
                Sprite ufoSprite = new Sprite();
                ufoSprite.charRepresentation = 'H';
                ufoSprite.spriteStructure = ufoStructure;
                
                GameAnimation ufoAnimation = new GameAnimation(40, 40);
                ufoAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/ufo1.png").toExternalForm()));
                ufoAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/ufo2.png").toExternalForm()));
                ufoAnimation.addImage(new Image(GameObjectBuilder.class.getResource("images/ufo3.png").toExternalForm()));
                
                ufoSprite.content = ufoAnimation;
                
                gameObject.addComponent(new SpriteRenderer(gameObject, ufoSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new Collider(gameObject, 3, 3));
                gameObject.addComponent(new Hit(gameObject));
                gameObject.addComponent(new UfoController(gameObject));
                gameObject.addComponent(new ScoreCounter(gameObject, 200));
                
                gameObject.setTag("Alien");
                
                ufo = new GameObject(gameObject);
                
                break;

            
            case Alien: 
                
                if(alien != null) return new GameObject(alien);
                
                gameObject = createBasicAlien();
                alien = new GameObject(gameObject);
                
                break;
                
            case MiddleAlien: 

                if(middleAlien != null) return new GameObject(middleAlien);

                gameObject = createMiddleAlien();
                middleAlien = new GameObject(gameObject);

                break;

            case FrontAlien: 

                if(frontAlien != null) return new GameObject(frontAlien);

                gameObject = createFrontAlien();
                frontAlien = new GameObject(gameObject);
                
                break;
            
            case Player:
                
                if(player != null) return new GameObject(player);
                
                ArrayList<Vector2D> playerStructure = new ArrayList<>();
                
                playerStructure.add(Vector2D.zero);
                playerStructure.add(new Vector2D(0,-1));
                playerStructure.add(new Vector2D(1,-1));
                playerStructure.add(new Vector2D(-1,-1));
        
                GameObject playerBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/player_bullet.png").toExternalForm())));
                GameObject specialBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/special_bullet.png").toExternalForm())));
                
                Sprite playerSprite = new Sprite();
                playerSprite.charRepresentation = '%';
                playerSprite.spriteStructure = playerStructure;
                Image playerImage = new Image(GameObjectBuilder.class.getResource("images/player.png").toExternalForm());
                
                playerSprite.content = new GameImage(playerImage, 50, 50);
                
                Collider playerCollider = new Collider(gameObject);
                playerCollider.changeColliderBoxDimensions(4, 3);
                gameObject.addComponent(playerCollider);
                gameObject.addComponent(new SpriteRenderer(gameObject, playerSprite));
                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new PlayerAttack(gameObject, playerBullet, specialBullet));
                gameObject.addComponent(new PlayerController(gameObject));
                gameObject.addComponent(new PlayerHit(gameObject));
                
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
                obstacleSprite.content = new GameImage(new Image(GameObjectBuilder.class.getResource("images/obstacle.png").toExternalForm()), 20, 20);
                
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
                
            case AliensMatrix:
                
                if(aliensMatrix != null) return new GameObject(aliensMatrix);
                
                GameObject aliensLineCopy;
                
                for(int i = 0; i < 2; i++){
                    aliensLineCopy = createAliensLine(create(Prefab.FrontAlien));
                    aliensLineCopy.setPosition(new Vector2D(0, 5.3f*i));
                    gameObject.addChild(aliensLineCopy);
                }
                
                for(int i = 2; i < 4; i++){
                    aliensLineCopy = createAliensLine(create(Prefab.MiddleAlien));
                    aliensLineCopy.setPosition(new Vector2D(0, 5.3f*i));
                    gameObject.addChild(aliensLineCopy);
                }
                
                aliensLineCopy = createAliensLine(create(Prefab.Alien));
                aliensLineCopy.setPosition(new Vector2D(0, 5.3f*4));
                gameObject.addChild(aliensLineCopy);

                gameObject.addComponent(new Physics(gameObject));
                gameObject.addComponent(new AlienMatrixLife(gameObject));
                gameObject.addComponent(new AlienMatrixController(gameObject));
                
                gameObject.setTag("AliensMatrix");
                
                aliensMatrix = new GameObject(gameObject);
                
                break;
            
            
        }
        
        return gameObject;
    }
    
    public static GameObject createBasicAlien(){
        
        GameObject gameObject = new GameObject();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();
                
        alienStructure.add(Vector2D.zero);

        Sprite alienSprite = new Sprite();
        alienSprite.charRepresentation = '$';
        alienSprite.spriteStructure = alienStructure;
        alienSprite.content = new GameImage(new Image(GameObjectBuilder.class.getResource("images/enemy.png").toExternalForm()), 40, 40);

        gameObject.addComponent(new SpriteRenderer(gameObject, alienSprite));
        gameObject.addComponent(new Physics(gameObject));
        gameObject.addComponent(new Collider(gameObject, 3, 3));
        gameObject.addComponent(new Hit(gameObject));
        gameObject.addComponent(new AlienAttack(gameObject, createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/alien_bullet.png").toExternalForm())))));
        gameObject.addComponent(new ScoreCounter(gameObject, 30));
        gameObject.addComponent(new AlienController(gameObject));

        gameObject.setTag("Alien");

        return gameObject;
    }
    
    public static GameObject createMiddleAlien(){
        
        GameObject gameObject = new GameObject();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();
                
        alienStructure.add(Vector2D.zero);

        Sprite alienSprite = new Sprite();
        alienSprite.charRepresentation = '8';
        alienSprite.spriteStructure = alienStructure;
        alienSprite.content = new GameImage(new Image(GameObjectBuilder.class.getResource("images/middle_enemy.png").toExternalForm()), 40, 40);

        gameObject.addComponent(new SpriteRenderer(gameObject, alienSprite));
        gameObject.addComponent(new Physics(gameObject));
        gameObject.addComponent(new Collider(gameObject, 3, 3));
        gameObject.addComponent(new Hit(gameObject));
        gameObject.addComponent(new AlienAttack(gameObject, createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/middle_alien_bullet.png").toExternalForm())))));
        gameObject.addComponent(new ScoreCounter(gameObject, 20));
        gameObject.addComponent(new AlienController(gameObject));

        gameObject.setTag("Alien");

        return gameObject;
    }
    
    public static GameObject createFrontAlien(){
        
        GameObject gameObject = new GameObject();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();
                
        alienStructure.add(Vector2D.zero);

        Sprite alienSprite = new Sprite();
        alienSprite.charRepresentation = '+';
        alienSprite.spriteStructure = alienStructure;
        alienSprite.content = new GameImage(new Image(GameObjectBuilder.class.getResource("images/front_enemy.png").toExternalForm()), 40, 40);

        gameObject.addComponent(new SpriteRenderer(gameObject, alienSprite));
        gameObject.addComponent(new Physics(gameObject));
        gameObject.addComponent(new Collider(gameObject, 3, 3));
        gameObject.addComponent(new Hit(gameObject));
        gameObject.addComponent(new AlienAttack(gameObject, createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/front_alien_bullet.png").toExternalForm())))));
        gameObject.addComponent(new ScoreCounter(gameObject, 10));
        gameObject.addComponent(new AlienController(gameObject));

        gameObject.setTag("Alien");

        return gameObject;
    }
    
    public static GameObject createAliensLine(GameObject alien){
        
        GameObject gameObject = new GameObject();
        GameObject alienCopy;
        
       for(int i = 0; i<11; i++){
            alienCopy = new GameObject(alien);
            alienCopy.setPosition(new Vector2D(5*i, 0));
            gameObject.addChild(alienCopy);
        }

        return gameObject;
    }
    
    public static GameObject createBullet(Sprite bulletSprite){
        
        GameObject gameObject = new GameObject();
        
        Physics bulletPhysics = new Physics(gameObject);
        
        gameObject.addComponent(bulletPhysics);
        gameObject.addComponent(new Collider(gameObject));
        gameObject.addComponent(new SpriteRenderer(gameObject, bulletSprite));
        gameObject.addComponent(new Hit(gameObject));
        gameObject.addComponent(new BulletLife(gameObject));

        gameObject.setTag("Bullet");

        return gameObject;
    }
    
    private static Sprite createBulletSprite(Image bulletImage){
        ArrayList<Vector2D> bulletStructure = new ArrayList<>();

        bulletStructure.add(Vector2D.zero);

        Sprite bulletSprite = new Sprite();
        bulletSprite.charRepresentation = '0';
        bulletSprite.spriteStructure = bulletStructure;
        bulletSprite.content = new GameImage(bulletImage, 30, 30);
        
        return bulletSprite;
    }
}
