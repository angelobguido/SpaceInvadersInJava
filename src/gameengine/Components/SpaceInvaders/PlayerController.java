/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Physics;
import gameengine.Components.Physics;
import gameengine.GameHandlers.InputHandler;
import gameengine.GameHandlers.InputHandler.Command;
import gameengine.GameObject;
import gamemath.Vector2D;

/**
 * Represents the movement and attack of the player.
 *
 * @author angelo
 */
public class PlayerController extends Component{
    
    private Physics playerPhysics;
    private PlayerAttack playerAttack;
    private boolean canAttack = true;
    private int attackCooldownTimer;
    private int attackCooldown = 17;
    
    public PlayerController(GameObject gameObject){
        super(gameObject, ComponentId.PlayerController);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        PlayerController newPlayerController = new PlayerController(gameObject);
        
        return newPlayerController;
    }
    
    @Override
    public void update(){
        
        Command c = InputHandler.getCommand();
        
        switch(c){
            case Nothing: playerPhysics.velocity = Vector2D.zero; break;
            case Left: playerPhysics.velocity = new Vector2D(-2, 0); break;
            case Right: playerPhysics.velocity = new Vector2D(2, 0); break;
            case Shoot: playerAttack.attack(); break;
        }
        
    }
    
    private void attack(){
        
        if(canAttack){
            playerAttack.attack();
            canAttack = false;
            attackCooldownTimer = attackCooldown;
        }
        else{
            attackCooldownTimer--;
            
            if(attackCooldownTimer <= 0){
                canAttack = true;
            }
        }
        
    }
    
    private void invertVelocity(){
        playerPhysics.velocity.x = -playerPhysics.velocity.x; 
    }
    
    @Override
    public void start(){
        
        playerPhysics = (Physics)gameObject.getComponent(ComponentId.Physics);
        playerAttack = (PlayerAttack)gameObject.getComponent(ComponentId.Attack);
        
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        playerPhysics = null;
        playerAttack = null;
    }
    
}
