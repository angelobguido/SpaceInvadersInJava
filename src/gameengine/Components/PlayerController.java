/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameObject;
import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class PlayerController extends Component{
    private final static float maxX = 35;
    private final static float minX = 1;
    private boolean isRight = true;
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
        newPlayerController.isRight = isRight;
        
        return newPlayerController;
    }
    
    @Override
    public void update(){
        
        if(isRight){
            if(gameObject.position().x > maxX){
                isRight = false;
                invertVelocity();
            }
        }else{
            if(gameObject.position().x < minX){
                isRight = true;
                invertVelocity(); 
            }
        }
        
        attack();
        
        
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
        
        playerPhysics.velocity = new Vector2D(0.5f, 0);
        
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        playerPhysics = null;
        playerAttack = null;
    }
    
}
