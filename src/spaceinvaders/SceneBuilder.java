/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.ComponentId;
import gameengine.Components.Physics;
import gameengine.Components.PlayerAttack;
import gameengine.GameObject;
import gameengine.Scene;
import gamemath.Vector2D;

/**
 * Builder used to build the space invaders scenes.
 * @author angelo
 */

enum SceneId{GameOver, GameMain}

public class SceneBuilder {
    
    private static Scene gameOver;
    private static Scene gameMain;
    
    /**
     * Static function that builds the desired scene.
     * @param id is the id of the scene you want to build.
     * @return the desired scene.
     */
    public static Scene create(SceneId id){
        
        Scene scene = new Scene();
        
        switch(id){
            case GameOver: 
                
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
                
                scene.addEntity(aliens);
                scene.addEntity(player);
                scene.addEntity(obstacle1);
                scene.addEntity(obstacle2);
                scene.addEntity(obstacle3);
                scene.addEntity(obstacle4);
                
                gameMain = scene;
                
                break;
            
            
        }
        
        return scene;
    }
    
}