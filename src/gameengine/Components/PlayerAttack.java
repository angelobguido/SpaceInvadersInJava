/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class PlayerAttack extends Attack{
    
    public PlayerAttack(GameObject gameObject, GameObject bulletPrefab){
        super(gameObject, bulletPrefab);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        PlayerAttack newAttack = new PlayerAttack(gameObject, bulletPrefab);
        
        return newAttack;
    }
    
    @Override
    protected void setBulletVelocity(GameObject bullet){
        Physics physics = (Physics)bullet.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(0,0.1f);
    }
    
    @Override
    protected void setBulletCollisions(GameObject bullet){
        Collider collider = (Collider)bullet.getComponent(ComponentId.Collider);
        ArrayList<GameObject> aliensMatrixTagged = EntityHandler.findWithTag("AliensMatrix");
        ArrayList<Component> aliensColliders = aliensMatrixTagged.get(0).getComponents(ComponentId.Collider);
        
        for(int i = 0; i < aliensColliders.size(); i++){
            collider.addTwoWayCollider(((Collider)aliensColliders.get(i)));
        }
        
    }
}