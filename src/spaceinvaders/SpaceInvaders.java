/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import graphics.GraphicsId;
import gameengine.Components.Physics;
import gameengine.Components.Collider;
import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.*;
import gameengine.Components.AlienAttack;
import gameengine.Components.PlayerAttack;
import gameengine.GameHandlers.EntityHandler;
import gamemath.*;
import static java.lang.Math.random;
import java.util.ArrayList;
/**
 *
 * @author angelo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Graphics.setGraphics(GraphicsId.Terminal);
        
        GameObject player = GameObjectBuilder.create(Prefab.Player);
        GameObject aliens = GameObjectBuilder.create(Prefab.AliensMatrix);
        Physics aliensPhysics = (Physics)aliens.getComponent(ComponentId.Physics);
        aliensPhysics.velocity = new Vector2D(0.5f,0);
        aliens.setPosition(Vector2D.up);
        
        
        aliens.setPosition(new Vector2D(0,30));
        
        GameObject bullet = GameObjectBuilder.create(Prefab.Bullet);
        bullet.setPosition(new Vector2D(10,0));
        
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
        
        int i = 0;
        
        EntityHandler.addEntity(aliens);
        EntityHandler.addEntity(player);
        EntityHandler.addEntity(obstacle1);
        EntityHandler.addEntity(obstacle2);
        EntityHandler.addEntity(obstacle3);
        EntityHandler.addEntity(obstacle4);
        
        bullet.setPosition(new Vector2D(8, 3));
        
        while(true){
            i++;
            Graphics.clean();
            
            if(i%36 == 0){
                aliensPhysics.velocity = Vector2D.multiplyByScalar(aliensPhysics.velocity, -1);
                playerPhysics.velocity = Vector2D.multiplyByScalar(playerPhysics.velocity, -1);
                aliens.setPosition(Vector2D.addVectors(aliens.position(), new Vector2D(0, -0.25f)));
            }
            
            if(i%30 == 0){
                ArrayList<Component> aliensAttack = aliens.getComponents(ComponentId.Attack);
                
                for(int j = 0; j < aliensAttack.size(); j++){
                    if(random()<0.01){
                        ((AlienAttack)aliensAttack.get(j)).attack();
                    }
                    
                }
                
                
            }
            
            if(i%15 == 0){
                playerAttack.attack();
            }
            
            Graphics.update();
            CollisionHandler.update();
            EntityHandler.update();
            Thread.sleep(50);
        }
        
        
    }
    
}
