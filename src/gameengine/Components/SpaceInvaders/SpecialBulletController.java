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
import gameengine.GameHandlers.InputHandler;
import gameengine.GameObject;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class SpecialBulletController extends Component{
    
    private GameObject extraBullet;
    
    public SpecialBulletController(GameObject gameObject, GameObject extraBullet){
        super(gameObject, ComponentId.SpecialBulletController);    
        this.extraBullet = extraBullet;
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        SpecialBulletController newSpecialBulletController = new SpecialBulletController(gameObject, extraBullet);
        
        return newSpecialBulletController;
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        
    }
    
    
    @Override
    public void destroy(){
        
        spawnBullets();
        
        gameObject.removeComponent(this);
        gameObject = null;
        
    }
    
    private void spawnBullets(){
        
        Physics physics = null;
        GameObject bulletClone = new GameObject(extraBullet);
        bulletClone.setPosition(gameObject.position());
        
        bulletClone = new GameObject(bulletClone);
        physics = (Physics)bulletClone.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(1,1);
        setCollisions(bulletClone);
        
        EntityHandler.addEntity(bulletClone);
        
        bulletClone = new GameObject(bulletClone);
        physics = (Physics)bulletClone.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(-1,-1);
        setCollisions(bulletClone);
        
        EntityHandler.addEntity(bulletClone);
        
        bulletClone = new GameObject(bulletClone);
        physics = (Physics)bulletClone.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(1,-1);
        setCollisions(bulletClone);
        
        EntityHandler.addEntity(bulletClone);
        
        bulletClone = new GameObject(bulletClone);
        physics = (Physics)bulletClone.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(-1,1);
        setCollisions(bulletClone);
        
        EntityHandler.addEntity(bulletClone);
        
    }
    
    private void setCollisions(GameObject bullet){
        
        Collider collider = (Collider)bullet.getComponent(ComponentId.Collider);
        ArrayList<GameObject> aliens = EntityHandler.findAllWithTag("Alien");
        ArrayList<GameObject> obstacles = EntityHandler.findAllWithTag("Obstacle");
        
        for(int i = 0; i < aliens.size(); i++){
            Collider alienCollider = (Collider)aliens.get(i).getComponent(ComponentId.Collider);
            collider.addTwoWayCollider(alienCollider);
        }
        
        for(int i = 0; i < obstacles.size(); i++){
            Collider obstacleCollider = (Collider)obstacles.get(i).getComponent(ComponentId.Collider);
            collider.addTwoWayCollider(obstacleCollider);
        }
    
    }
    
}
