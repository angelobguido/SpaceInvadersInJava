/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Physics;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import gameengine.GameObject;
import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class UfoController extends Component{
    private final static float maxX = 100;
    private final static Vector2D initialPosition = new Vector2D(-10, 65);
    private Physics ufoPhysics;
    private boolean removed = false;
    
    public UfoController(GameObject gameObject){
        super(gameObject, ComponentId.UfoController);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        return new UfoController(gameObject);
    }
    
    @Override
    public void update(){
        
        if(removed == true) return;
        
        if(gameObject.getPositionReference().x > maxX){
            ((Hit)gameObject.getComponent(ComponentId.Hit)).deathEvent.disable();
            EntityHandler.removeEntity(gameObject);
            removed = true;
        }
    }
    
    
    @Override
    public void start(){
        ufoPhysics = (Physics)gameObject.getComponent(ComponentId.Physics);
        ufoPhysics.velocity = new Vector2D(0.8f, 0);
        Vector2D position = gameObject.getPositionReference();
        position.x = initialPosition.x;
        position.y = initialPosition.y;
        
        GameAudioHandler.playUFOaudio();
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        ufoPhysics = null;
        
        GameAudioHandler.stopPlayingUFOaudio();
    }
    
}
