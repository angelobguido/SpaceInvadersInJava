/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
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
    private int attackCooldown = 20;
    
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
        
        if(attackCooldownTimer <= 0){
            canAttack = true;
            
        }else{
            attackCooldownTimer--;        
        }
        
        
        Command move = InputHandler.getMoveCommand();

        switch(move){
            case Stop: playerPhysics.velocity = Vector2D.zero; break;
            case Left: playerPhysics.velocity = new Vector2D(-1, 0); break;
            case Right: playerPhysics.velocity = new Vector2D(1, 0); break;
        
        }

        
        Command action = InputHandler.getActionCommand();

        switch(action){
            case Shoot: attack(); break;
           
        }

        
        
        
    }
    
    private void attack(){
        
        if(canAttack){
            playerAttack.attack();
            canAttack = false;
            attackCooldownTimer = attackCooldown;
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
