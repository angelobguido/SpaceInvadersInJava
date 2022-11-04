/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameObject;
import gameengine.GameHandlers.EntityHandler;

/**
 * Represents the ability to attack launching a bullet.
 *
 * @author angelo
 */
public abstract class Attack extends Component {
    
    protected GameObject bulletPrefab;
    
    public Attack(GameObject gameObject, GameObject bulletPrefab){
        super(gameObject, ComponentId.Attack);
        this.bulletPrefab = bulletPrefab;
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
   
    }
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        bulletPrefab = null;
    }
    
    public void attack(){
        
        GameObject bullet = new GameObject(bulletPrefab);
        bullet.setPosition(gameObject.position());
        
        setBulletVelocity(bullet);
        setBulletCollisions(bullet);
        
        EntityHandler.addEntity(bullet);
        
    }
    
    protected abstract void setBulletVelocity(GameObject bullet);
    protected abstract void setBulletCollisions(GameObject bullet);
}
