/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import gameengine.GameHandlers.SpaceInvaders.HealthManager;
import gameengine.GameObject;
import spaceinvaders.GameObjectBuilder;
import spaceinvaders.GameObjectBuilder.Prefab;

/**
 *
 * @author angelo
 */
public class PlayerHit extends Hit {
    
    private static final int maxPlayerHealth = 3;
    private static final int invencibility = 30;
    private int timer = 0;
    private boolean canTakeHit = true;
    
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
    public void update(){
        
        if(canTakeHit == false){    
            timer++;
            if(timer>=invencibility){
                timer = 0;
                canTakeHit = true;
            }
        }
        
    }
    
    @Override
    public void onHit(){
        if(canTakeHit == true){
            GameObject effect = GameObjectBuilder.create(Prefab.Effect);
            effect.setPosition(gameObject.position());
            EntityHandler.addEntity(effect);
            
            HealthManager.takeHit();
            GameAudioHandler.playPlayerHit();
        }
        health++;
    }
}
