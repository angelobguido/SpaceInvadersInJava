/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.ComponentId;
import gameengine.Components.SpaceInvaders.GameOverManager;
import gameengine.Components.Physics;
import gameengine.Components.SpaceInvaders.PlayerAttack;
import gameengine.GameObject;
import gameengine.GameScene;
import gamemath.Vector2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Builder used to build the space invaders scenes.
 * @author angelo
 */

public class SceneBuilder {
    public enum SceneId{GameOver, GameMain} 
    private static GameScene gameOver;
    private static GameScene gameMain;
    
    /**
     * Static function that builds the desired scene.
     * @param id is the id of the scene you want to build.
     * @return the desired scene.
     */
    public static GameScene create(SceneId id){
        
        GameScene scene = new GameScene();
        
        switch(id){
            case GameOver: 
                
                System.out.println("GAME OVER!");
                
                if(gameOver != null) return gameOver;
                
                gameOver = scene;
                
                break;
            
            case GameMain:
                
                if(gameMain != null) return gameMain;
                
                GameObject player = GameObjectBuilder.create(Prefab.Player);
                GameObject aliens = GameObjectBuilder.create(Prefab.AliensMatrix);

                aliens.setPosition(new Vector2D(0,30));

                PlayerAttack playerAttack = (PlayerAttack)player.getComponent(ComponentId.Attack);
                Physics playerPhysics = (Physics)player.getComponent(ComponentId.Physics);
                playerPhysics.velocity = new Vector2D(1,0);
                player.setPosition(new Vector2D(0,2));

                GameObject obstacle1 = GameObjectBuilder.create(Prefab.BigObstacle);
                GameObject obstacle2 = GameObjectBuilder.create(Prefab.BigObstacle);
                GameObject obstacle3 = GameObjectBuilder.create(Prefab.BigObstacle);
                GameObject obstacle4 = GameObjectBuilder.create(Prefab.BigObstacle);

                obstacle1.setPosition(new Vector2D(5,4));
                obstacle2.setPosition(new Vector2D(15,4));
                obstacle3.setPosition(new Vector2D(25,4));
                obstacle4.setPosition(new Vector2D(35,4));
                
                GameObject gameOverManager = new GameObject();
                gameOverManager.addComponent(new GameOverManager(gameOverManager));
                
                scene.addEntity(aliens);
                scene.addEntity(player);
                scene.addEntity(obstacle1);
                scene.addEntity(obstacle2);
                scene.addEntity(obstacle3);
                scene.addEntity(obstacle4);
                scene.addEntity(gameOverManager);
                
                StackPane gameRoot = new StackPane();
                gameRoot.setPrefSize(900, 600);
                
                StackPane root = new StackPane();
                root.setPrefSize(900, 600);
                
                Rectangle bg = new Rectangle(900, 600);
                
                root.getChildren().addAll(gameRoot, bg);
                
                scene.setRoot(gameRoot);
                
                scene.setScene(new Scene(root));
                
                gameMain = scene;
                
                break;
            
            
        }
        
        return scene;
    }
    
}