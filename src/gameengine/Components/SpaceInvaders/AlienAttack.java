/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Collider;
import gameengine.Components.Physics;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 * Represents the alien attack.
 *
 * @author angelo
 */
public class AlienAttack extends Attack{
    
    
    public AlienAttack(GameObject gameObject, GameObject bulletPrefab){
        super(gameObject, bulletPrefab);
    }
    

    @Override
    public Component createCopy(GameObject gameObject){
        
        AlienAttack newAttack = new AlienAttack(gameObject, bulletPrefab);
        
        return newAttack;
    }
    

    @Override
    protected void setBulletVelocity(GameObject bullet){
        Physics physics = (Physics)bullet.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(0,-2f);
    }
    
   
    @Override
    protected void setBulletCollisions(GameObject bullet){
        Collider collider = (Collider)bullet.getComponent(ComponentId.Collider);
        ArrayList<GameObject> playerTagged = EntityHandler.findWithTag("Player");
        ArrayList<GameObject> obstacleTagged = EntityHandler.findWithTag("BigObstacle");
        
        for(int i = 0; i < playerTagged.size(); i++){
            Collider playerCollider = (Collider)playerTagged.get(i).getComponent(ComponentId.Collider);
            collider.addTwoWayCollider(playerCollider);
        }
        
        for(int i = 0; i < obstacleTagged.size(); i++){
            
            ArrayList<Component> obstacleColliders = obstacleTagged.get(i).getComponents(ComponentId.Collider);
            
            for(int j = 0; j < obstacleColliders.size(); j++){
                collider.addTwoWayCollider((Collider)obstacleColliders.get(j));
            }
          
        }
        
        
    }
}
