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
        alien2Physics.setVelocity(Vector2D.addVectors(Vector2D.multiplyByScalar(Vector2D.up, 3), Vector2D.right));
        
        GameObject player = GameObjectBuilder.create(Prefab.Player);
        Physics playerPhysics = (Physics)player.getComponent(ComponentId.Physics);
        playerPhysics.setVelocity(Vector2D.right);
        
        int i = 0;
        
        while(true){
            i++;
            Graphics.clean();
            alien.update();
            alien2.update();
            if(i%7 == 0){
                playerPhysics.setVelocity(Vector2D.multiplyByScalar(playerPhysics.velocity(), -1));
            }
            player.update();
            Graphics.update();
            Thread.sleep(500);
        }
        
        
    }
    
}
