/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Collider;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.SpaceInvaders.HealthManager;
import gameengine.GameObject;

/**
 *
 * @author angelo
 */
public class PlayerHit extends Hit {
    
    private static final int maxPlayerHealth = 3;
    
    public PlayerHit(GameObject gameObject){
        super(gameObject, maxPlayerHealth);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        PlayerHit newHit = new PlayerHit(gameObject);
        newHit.maxHealth = maxPlayerHealth;
        return newHit;
    }
    
    @Override
    public void onHit(){
        HealthManager.takeHit();
    }
}
