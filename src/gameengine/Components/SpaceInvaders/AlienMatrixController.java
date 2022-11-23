/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Physics;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SceneManager;
import gameengine.GameInitializer;
import gameengine.GameObject;
import gamemath.Vector2D;
import static java.lang.Math.random;
import java.util.ArrayList;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.MenuSceneId.GameOver;

/**
 * Represents the movement and attack of an alien matrix.
 *
 * @author angelo
 */
public class AlienMatrixController extends Component{
    private final static float maxX = 20;
    private final static float minX = 1;
    private boolean isRight = true;
    private Physics aliensPhysics;
    private boolean canAttack = true;
    private int attackCooldownTimer;
    private int attackCooldown = 20;
    
    public AlienMatrixController(GameObject gameObject){
        super(gameObject, ComponentId.AlienMatrixController);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        AlienMatrixController newAlienMatrixController = new AlienMatrixController(gameObject);
        newAlienMatrixController.isRight = isRight;
        
        return newAlienMatrixController;
    }
    
    @Override
    public void update(){
        
        if(gameObject.position().y < 0){
            System.out.println("END");
            GameInitializer.stop();
            SceneManager.loadMenuScene(SceneBuilder.createMenu(GameOver));
        }
        
        if(isRight){
            if(gameObject.position().x > maxX){
                isRight = false;
                invertVelocity();
                goDown();
            }
        }else{
            if(gameObject.position().x < minX){
                isRight = true;
                invertVelocity(); 
                goDown();
            }
        }
        
        
        attackWithRandomAliens();
        
        
        
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
        aliensPhysics.velocity = new Vector2D(0.2f, 0);
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        aliensPhysics = null;
    }
    
}
