/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.*;
import gamemath.*;
import java.util.Vector;
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
        
        GameObject alien = GameObjectBuilder.create(Prefab.Alien);
        GameObject alien2 = GameObjectBuilder.create(Prefab.Alien);
        Physics alien2Physics = (Physics)alien2.getComponent(ComponentId.Physics);
        alien2Physics.velocity = (Vector2D.addVectors(Vector2D.multiplyByScalar(Vector2D.up, 3), Vector2D.right));
        
        GameObject player = GameObjectBuilder.create(Prefab.Player);
        Physics playerPhysics = (Physics)player.getComponent(ComponentId.Physics);
        playerPhysics.velocity = (Vector2D.right);
        
        Physics alienPhysics = (Physics)alien.getComponent(ComponentId.Physics);
        alienPhysics.velocity = (Vector2D.addVectors(Vector2D.multiplyByScalar(Vector2D.up, 3), Vector2D.right));
        alien.position = new Vector2D(8.0f, 3.0f);
        
        SpriteRenderer playerSpriteRenderer = (SpriteRenderer)player.getComponent(ComponentId.SpriteRenderer);
        SpriteRenderer alienSpriteRenderer = (SpriteRenderer)alien.getComponent(ComponentId.SpriteRenderer);
        
        Sprite playerSpriteCopy = ((SpriteRenderer)player.getComponent(ComponentId.SpriteRenderer)).sprite();
        Sprite alienSpriteCopy = ((SpriteRenderer)alien.getComponent(ComponentId.SpriteRenderer)).sprite();
        
        int i = 0;
        
        while(true){
            i++;
            Graphics.clean();
            alien.update();
            alien2.update();
            if(i%7 == 0){
                playerPhysics.velocity = (Vector2D.multiplyByScalar(playerPhysics.velocity, -1));
                playerSpriteRenderer.setSprite(alienSpriteCopy);
            }
            if(i%5 == 0){
                alienPhysics.velocity = (Vector2D.multiplyByScalar(alienPhysics.velocity, -1));
                playerSpriteRenderer.setSprite(playerSpriteCopy);
            }
            if(i%3 == 0){
                alien2Physics.velocity = (Vector2D.multiplyByScalar(alien2Physics.velocity, -1));
            }
            player.update();
            Graphics.update();
            Thread.sleep(500);
        }
        
        
    }
    
}
