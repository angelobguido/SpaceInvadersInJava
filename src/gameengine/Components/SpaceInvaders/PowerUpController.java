/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import static gameengine.ComponentId.Collider;
import gameengine.Components.Collider;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import gameengine.GameHandlers.SpaceInvaders.PowerManager;
import gameengine.GameObject;
import gamemath.Vector2D;
import static java.lang.Math.random;

/**
 * Represents the behaviour of the power up. It is used to notify the PowerManager.
 *
 * @author angelo
 */
public class PowerUpController extends Component{
    private final static float maxX = 50;
    private final static float minX = 0;
    
    private int timer = 0;
    private int timeAlive = 120;
    private boolean hasBeenTaken = true;
    
    public PowerUpController(GameObject gameObject){
        super(gameObject, ComponentId.PowerUpController);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        return new PowerUpController(gameObject);
    }
    
    @Override
    public void update(){
        timer++;
        if(timer>=timeAlive){
            EntityHandler.removeEntity(gameObject);
            hasBeenTaken = false;
        }
    }
    
    
    @Override
    public void start(){
        GameObject player = EntityHandler.findWithTag("Player").get(0);
        Float yPosition = player.position().y;
        Vector2D position = gameObject.getPositionReference();
        position.x = ((float)random())*maxX + minX;
        position.y = yPosition;
        
        Collider playerCollider = (Collider)player.getComponent(Collider);
        ((Collider)gameObject.getComponent(Collider)).addCollider(playerCollider);
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        
        if(hasBeenTaken){
            PowerManager.addPower();
            GameAudioHandler.playPowerUp();
        }
        
    }
}
