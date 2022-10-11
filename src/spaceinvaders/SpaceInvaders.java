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
        
        GameObject aliens = GameObjectBuilder.create(Prefab.AliensMatrix);
        Physics aliensPhysics = (Physics)aliens.getComponent(ComponentId.Physics);
        aliensPhysics.velocity = new Vector2D(1,0);
        aliens.setPosition(Vector2D.up);
        
        
        aliens.setPosition(new Vector2D(5,30));
        
        GameObject bullet = GameObjectBuilder.create(Prefab.Bullet);
        bullet.setPosition(new Vector2D(10,0));
        
        Vector<Component> aliensColliders = aliens.getComponents(ComponentId.Collider);
        
        Collider bulletCollider = (Collider)bullet.getComponent(ComponentId.Collider);
        
        for(int j = 0; j < aliensColliders.size(); j++){
            bulletCollider.addCollider((Collider)aliensColliders.elementAt(j));
        }
        
        int i = 0;
        
        aliens.start();
        bullet.start();
        
        while(true){
            i++;
            Graphics.clean();
            
            if(i%8 == 0){
                aliensPhysics.velocity = Vector2D.multiplyByScalar(aliensPhysics.velocity, -1);
                aliens.setPosition(Vector2D.addVectors(aliens.position(), Vector2D.down));
            }
            aliens.update();
            bullet.update();
            
            Graphics.update();
            CollisionHandler.update();
            Thread.sleep(500);
        }
        
        
    }
    
}
