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
import static java.lang.Math.random;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class AlienMatrixController extends Component{
    private float maxX = 20;
    private float minX = 1;
    private boolean isRight = true;
    private Physics aliensPhysics;
    private boolean canAttack = true;
    private int attackCooldownTimer;
    private int attackCooldown = 20;
    
    public AlienMatrixController(GameObject gameObject){
        super(gameObject, ComponentId.AlienMatrixMovement);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        AlienMatrixController newAlienMatrixMovement = new AlienMatrixController(gameObject);
        newAlienMatrixMovement.isRight = isRight;
        
        return newAlienMatrixMovement;
    }
    
    @Override
    public void update(){
        
        if(isRight){
            if(gameObject.position().x > 20){
                isRight = false;
                invertVelocity();
                goDown();
            }
        }else{
            if(gameObject.position().x < 1){
                isRight = true;
                invertVelocity(); 
                goDown();
            }
        }
        
        if(gameObject.position().x > 9 && gameObject.position().x < 15){
            attackWithRandomAliens();
        }
        
        
    }
    
    private void attackWithRandomAliens(){
        
        if(canAttack){
            ArrayList<Component> aliensAttack = gameObject.getComponents(ComponentId.Attack);
                
            for(int j = 0; j < aliensAttack.size(); j++){
                if(random()<0.02){
                    ((AlienAttack)aliensAttack.get(j)).attack();
                }

            }
            
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
    
    private void goDown(){
        gameObject.setPosition(Vector2D.addVectors(gameObject.position(), new Vector2D(0, -1f)));
    }
    
    private void invertVelocity(){
        aliensPhysics.velocity.x = -aliensPhysics.velocity.x; 
    }
    
    @Override
    public void start(){
        aliensPhysics = (Physics)gameObject.getComponent(ComponentId.Physics);
        aliensPhysics.velocity = new Vector2D(0.5f, 0);
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        aliensPhysics = null;
    }
    
}
