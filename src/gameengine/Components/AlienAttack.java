/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameObject;

/**
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
        physics.velocity = new Vector2D(0,-1);
    }
    
    @Override
    protected void setBulletCollisions(GameObject bullet){
        
    }
}
