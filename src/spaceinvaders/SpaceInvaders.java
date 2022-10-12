/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.Components.Physics;
import gameengine.Components.Collider;
import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.*;
import gameengine.GameHandlers.EntityHandler;
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
        aliensPhysics.velocity = new Vector2D(0.5f,0);
        aliens.setPosition(Vector2D.up);
        
        
        aliens.setPosition(new Vector2D(0,30));
        
        GameObject bullet = GameObjectBuilder.create(Prefab.Bullet);
        bullet.setPosition(new Vector2D(10,0));
        
        Vector<Component> aliensColliders = aliens.getComponents(ComponentId.Collider);
        
        
        
        int i = 0;
        
        //EntityHandler.addEntity(bullet);
        EntityHandler.addEntity(aliens);
        
        
        bullet.setPosition(new Vector2D(8, 3));
        
        while(true){
            i++;
            Graphics.clean();
            
            if(i%36 == 0){
                aliensPhysics.velocity = Vector2D.multiplyByScalar(aliensPhysics.velocity, -1);
                aliens.setPosition(Vector2D.addVectors(aliens.position(), new Vector2D(0, -0.25f)));
            }
            
            if(i%30 == 0){
                GameObject bulletCopy = new GameObject(bullet);
                Collider collider = (Collider)bulletCopy.getComponent(ComponentId.Collider);
                aliensColliders = aliens.getComponents(ComponentId.Collider);
                
                for(int j = 0; j < aliensColliders.size(); j++){
                    collider.addCollider((Collider)aliensColliders.elementAt(j));
                    ((Collider)aliensColliders.elementAt(j)).addCollider(collider);
                }
                
                EntityHandler.addEntity(bulletCopy);
                
            }
            
            Graphics.update();
            EntityHandler.update();
            CollisionHandler.update();
            Thread.sleep(50);
        }
        
        
    }
    
}
