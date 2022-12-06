/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.Components.SpaceInvaders.*;
import gameengine.Components.*;
import gameengine.*;
import gamemath.Vector2D;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Builder used to build the space invaders game objects.
 * @author angelo
 */

public class GameObjectBuilder {
   
    public enum Prefab{UFO, Alien, MiddleAlien, FrontAlien, Player, Obstacle, BigObstacle, AliensMatrix, PowerUp, Effect}
    
    
    private static GameObject powerUp;
    private static GameObject effect;
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
            
            case Effect:
                if(effect != null) return new GameObject(effect);
                
                gameObject = createEffect();
                effect = new GameObject(gameObject);
                
                break;
            
            case PowerUp:
                if(powerUp != null) return new GameObject(powerUp);
                
                gameObject = createPowerUp();
                powerUp = new GameObject(gameObject);
                
                break;

            
            case UFO:
                
                if(ufo != null) return new GameObject(ufo);
                
                gameObject = createUFO();
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
                
                gameObject = createPlayer();
                player = new GameObject(gameObject);
                
                break;
            
            case Obstacle:
                
                
                if(obstacle != null) return new GameObject(obstacle);
                
                gameObject = createObstacle();
                obstacle = new GameObject(gameObject);
                
                break;
            
            case BigObstacle:
                
                if(bigObstacle != null) return new GameObject(bigObstacle);
                
                GameObject obstacleCopy;
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(2*i, 0));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(2*i, 2*1));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -2; i < 3; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(2*i, 2*2));
                    gameObject.addChild(obstacleCopy);
                }
                
                for(int i = -1; i < 2; i++){
                    obstacleCopy = GameObjectBuilder.create(Prefab.Obstacle);
                    obstacleCopy.setPosition(new Vector2D(2*i, 2*3));
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
    
    /**
     * Static function that initialises all the objects that can be created.
     * It is useful to stop lag.
     */
    public static void init(){
        create(Prefab.Alien);
        create(Prefab.AliensMatrix);
        create(Prefab.BigObstacle);
        create(Prefab.Effect);
        create(Prefab.FrontAlien);
        create(Prefab.MiddleAlien);
        create(Prefab.Obstacle);
        create(Prefab.Player);
        create(Prefab.PowerUp);
        create(Prefab.UFO);
    }
    
    public static GameObject createEffect(){
        double size = 55;
        GameObject effect = new GameObject();
        Sprite sprite = new Sprite();
        sprite.charRepresentation = '5';
        ArrayList<Vector2D> structure = new ArrayList<>();
        structure.add(new Vector2D(0,0));
        sprite.spriteStructure = structure;
        sprite.image = new Image(GameObjectBuilder.class.getResource("images/effect1.png").toExternalForm(), size, size, true, false);
        
        Sprite sprite2 = new Sprite();
        sprite2.charRepresentation = '6';
        sprite2.spriteStructure = structure;
        sprite2.image = new Image(GameObjectBuilder.class.getResource("images/effect2.png").toExternalForm(), size, size, true, false);
        
        Sprite sprite3 = new Sprite();
        sprite3.charRepresentation = '5';
        sprite3.spriteStructure = structure;
        sprite3.image = new Image(GameObjectBuilder.class.getResource("images/effect3.png").toExternalForm(), size, size, true, false);
        
        Sprite sprite4 = new Sprite();
        sprite4.charRepresentation = '6';
        sprite4.spriteStructure = structure;
        sprite4.image = new Image(GameObjectBuilder.class.getResource("images/effect4.png").toExternalForm(), size, size, true, false);
        
        Sprite sprite5 = new Sprite();
        sprite5.charRepresentation = '5';
        sprite5.spriteStructure = structure;
        sprite5.image = new Image(GameObjectBuilder.class.getResource("images/effect5.png").toExternalForm(), size, size, true, false);
        
        
        effect.addComponent(new SpriteRenderer(effect, sprite));
        Animator animator = new Animator(effect, 5);
        animator.animation().add(sprite);
        animator.animation().add(sprite2);
        animator.animation().add(sprite3);
        animator.animation().add(sprite4);
        animator.animation().add(sprite5);
        effect.addComponent(animator);
        effect.addComponent(new EffectController(effect));
        
        return effect;
        
    }
    
    private static GameObject createDefaultEntity(String tag, Sprite sprite, int maxHealth, int colliderWidth, int colliderHeight){
        
        GameObject gameObject = new GameObject();
        
        gameObject.addComponent(new SpriteRenderer(gameObject, sprite));
        gameObject.addComponent(new Physics(gameObject));
        gameObject.addComponent(new Collider(gameObject, colliderWidth, colliderHeight));
        gameObject.addComponent(new Hit(gameObject, maxHealth));
        
        gameObject.setTag(tag);
        
        return gameObject;
    }
    
    public static GameObject createObstacle(){
        
        Sprite obstacleSprite = new Sprite();
        
        ArrayList<Vector2D> obstacleStructure = new ArrayList<>();         
        obstacleStructure.add(Vector2D.zero);
        
        obstacleSprite.charRepresentation = '@';
        obstacleSprite.spriteStructure = obstacleStructure;
        obstacleSprite.image = new Image(GameObjectBuilder.class.getResource("images/obstacle.png").toExternalForm(), 20, 20, true, false);

        GameObject obstacle = createDefaultEntity("Obstacle", obstacleSprite, 2, 1, 1);
        
        return obstacle;
    }
    
    public static GameObject createPowerUp(){

        Sprite sprite = new Sprite();
        
        ArrayList<Vector2D> structure = new ArrayList<>();

        structure.add(Vector2D.zero);

        sprite.charRepresentation = '?';
        sprite.spriteStructure = structure;

        sprite.image = new Image(GameObjectBuilder.class.getResource("images/power_up1.png").toExternalForm(), 40, 40, true, false);

        GameObject powerUp = createDefaultEntity("Collectable", sprite, 1, 3, 3);
        
        powerUp.addComponent(new PowerUpController(powerUp));
        powerUp.addComponent(new Animator(powerUp));
        
        Sprite sprite2 = new Sprite();
        sprite2.charRepresentation = '!';
        sprite2.spriteStructure = structure;
        sprite2.image = new Image(GameObjectBuilder.class.getResource("images/power_up2.png").toExternalForm(), 40, 40, true, false);
        
        Sprite sprite3 = new Sprite();
        sprite3.charRepresentation = ';';
        sprite3.spriteStructure = structure;
        sprite3.image = new Image(GameObjectBuilder.class.getResource("images/power_up3.png").toExternalForm(), 40, 40, true, false);
        
        ArrayList<Sprite> animation = ((Animator)powerUp.getComponent(ComponentId.Animator)).animation();
        animation.add(sprite);
        animation.add(sprite2);
        animation.add(sprite3);
        
        return powerUp;
    }
    
    public static GameObject createUFO(){
        Sprite sprite = new Sprite();
        
        ArrayList<Vector2D> structure = new ArrayList<>();
                
        structure.add(Vector2D.zero);

        sprite.charRepresentation = 'H';
        sprite.spriteStructure = structure;
        sprite.image = new Image(GameObjectBuilder.class.getResource("images/ufo1.png").toExternalForm(), 40, 40, true, false);

        GameObject ufo = createDefaultEntity("Alien", sprite, 1,  3, 3);
        
        ufo.addComponent(new UfoController(ufo));
        ufo.addComponent(new ScoreCounter(ufo, 200));
        ufo.addComponent(new Animator(ufo));
        
        ArrayList<Sprite> animation = ((Animator)ufo.getComponent(ComponentId.Animator)).animation();
        
        animation.add(sprite);
        
        Sprite sprite2 = new Sprite();
        sprite2.charRepresentation = 'V';
        sprite2.spriteStructure = structure;
        sprite2.image = new Image(GameObjectBuilder.class.getResource("images/ufo2.png").toExternalForm(), 40, 40, true, false);
        
        Sprite sprite3 = new Sprite();
        sprite3.charRepresentation = 'X';
        sprite3.spriteStructure = structure;
        sprite3.image = new Image(GameObjectBuilder.class.getResource("images/ufo3.png").toExternalForm(), 40, 40, true, false);
        
        Sprite sprite4 = new Sprite();
        sprite4.charRepresentation = 'T';
        sprite4.spriteStructure = structure;
        sprite4.image = new Image(GameObjectBuilder.class.getResource("images/ufo4.png").toExternalForm(), 40, 40, true, false);
        
        animation.add(sprite2);
        animation.add(sprite3);
        animation.add(sprite4);
        
        return ufo;
    }
    
    public static GameObject createPlayer(){
        
        Sprite playerSprite = new Sprite();
        
        ArrayList<Vector2D> playerStructure = new ArrayList<>();
        playerStructure.add(Vector2D.zero);
        playerStructure.add(new Vector2D(0,-1));
        playerStructure.add(new Vector2D(1,-1));
        playerStructure.add(new Vector2D(-1,-1));
        playerSprite.charRepresentation = '%';
        playerSprite.spriteStructure = playerStructure;
            
        Image playerImage = new Image(GameObjectBuilder.class.getResource("images/player.png").toExternalForm(), 50, 50, true, false);
        playerSprite.image = playerImage;

        
        Sprite specialPlayerSprite = new Sprite();
        specialPlayerSprite.charRepresentation = '§';
        specialPlayerSprite.spriteStructure = playerStructure;    
        Image specialPlayerImage = new Image(GameObjectBuilder.class.getResource("images/special_player.png").toExternalForm(), 50, 50, true, false);
        specialPlayerSprite.image = specialPlayerImage;

        
        GameObject playerBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/player_bullet.png").toExternalForm(), 30, 30, true, false)));
        GameObject extraBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/extra_bullet.png").toExternalForm(), 30, 30, true, false)));
        GameObject specialBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/special_bullet.png").toExternalForm(), 30, 30, true, false)));
        specialBullet.addComponent(new SpecialBulletController(specialBullet, extraBullet));

        GameObject player = createDefaultEntity("Player", playerSprite, 3,  4, 3);
        
        player.addComponent(new PlayerAttack(player, playerBullet, specialBullet, playerSprite, specialPlayerSprite));
        player.addComponent(new PlayerController(player));
        player.addComponent(new PlayerHit(player));
        
        return player;
    }
    
    private static GameObject createAlien(Sprite alienSprite, GameObject alienBullet, int points){
        
        GameObject alien = createDefaultEntity("Alien", alienSprite, 1, 3, 3);
        
        alien.addComponent(new AlienAttack(alien, alienBullet));
        alien.addComponent(new ScoreCounter(alien, points));
        alien.addComponent(new AlienController(alien));
        
        return alien;
    }
    
    public static GameObject createBasicAlien(){
        
        Sprite alienSprite = new Sprite();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();            
        alienStructure.add(Vector2D.zero);
        alienSprite.charRepresentation = '$';
        alienSprite.spriteStructure = alienStructure;

        alienSprite.image = new Image(GameObjectBuilder.class.getResource("images/enemy.png").toExternalForm(), 40, 40, true, false);
        
        GameObject alienBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/alien_bullet.png").toExternalForm(), 30, 30, true, false)));
        
        GameObject alien = createAlien(alienSprite, alienBullet, 30);
        
        return alien;
    }
    
    public static GameObject createMiddleAlien(){
        
        Sprite alienSprite = new Sprite();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();            
        alienStructure.add(Vector2D.zero);
        alienSprite.charRepresentation = '8';
        alienSprite.spriteStructure = alienStructure;

        alienSprite.image = new Image(GameObjectBuilder.class.getResource("images/middle_enemy.png").toExternalForm(), 40, 40, true, false);
        
        GameObject alienBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/middle_alien_bullet.png").toExternalForm(), 30, 30, true, false)));
        
        GameObject alien = createAlien(alienSprite, alienBullet, 30);
        
        return alien;
        
    }
    
    public static GameObject createFrontAlien(){
        
        Sprite alienSprite = new Sprite();
        
        ArrayList<Vector2D> alienStructure = new ArrayList<>();            
        alienStructure.add(Vector2D.zero);
        alienSprite.charRepresentation = '8';
        alienSprite.spriteStructure = alienStructure;

        alienSprite.image = new Image(GameObjectBuilder.class.getResource("images/front_enemy.png").toExternalForm(), 40, 40, true, false);
        
        GameObject alienBullet = createBullet(createBulletSprite(new Image(GameObjectBuilder.class.getResource("images/front_alien_bullet.png").toExternalForm(), 30, 30, true, false)));
        
        GameObject alien = createAlien(alienSprite, alienBullet, 30);
        
        return alien;
        
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
        gameObject.addComponent(new Collider(gameObject, 1, 1));
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
        
        bulletSprite.image = bulletImage;
        
        return bulletSprite;
    }
}
