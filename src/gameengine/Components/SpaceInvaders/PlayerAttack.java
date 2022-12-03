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
import gameengine.GameHandlers.SpaceInvaders.PowerManager;
import gameengine.GameObject;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 * Represents the attack of a player.
 *
 * @author angelo
 */
public class PlayerAttack extends Attack{
    
    private GameObject normalBullet;
    private GameObject specialBullet;
    
    private static final int maxSpecialBullets = 5;
    private int specialBulletsLeft = 0;
    
    public PlayerAttack(GameObject gameObject, GameObject normalBulletPrefab, GameObject specialBulletPrefab){
        super(gameObject, normalBulletPrefab);
        
        normalBullet = normalBulletPrefab;
        specialBullet = specialBulletPrefab;
    }
    
    @Override
    public void update(){
        if(PowerManager.getPower() == true){
            specialBulletsLeft = maxSpecialBullets;
        }
        
        if(specialBulletsLeft == 0){
            bulletPrefab = normalBullet;
        }
        else{
            bulletPrefab = specialBullet;
        }
    }
    
    @Override
    protected void onAttack(){
        if(specialBulletsLeft > 0){
            specialBulletsLeft--;
        }
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        PlayerAttack newAttack = new PlayerAttack(gameObject, normalBullet, specialBullet);
        
        return newAttack;
    }
    
    @Override
    protected void setBulletVelocity(GameObject bullet){
        Physics physics = (Physics)bullet.getComponent(ComponentId.Physics);
        physics.velocity = new Vector2D(0,2f);
    }
    
    @Override
    protected void setBulletCollisions(GameObject bullet){
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