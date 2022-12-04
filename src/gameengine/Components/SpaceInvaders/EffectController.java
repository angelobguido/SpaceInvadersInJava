/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;
import gamemath.Vector2D;
/**
 *
 * @author angelo
 */
public class EffectController extends Component {
    private static final int framesAlive = 20;
    private Vector2D initialPosition;
    private int frames = 0;

    public EffectController(GameObject gameObject, Vector2D initialPosition){
        super(gameObject, ComponentId.EffectController);
        this.initialPosition = initialPosition;
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        return new EffectController(gameObject, initialPosition);
    }
    
    @Override
    public void update(){
        frames++;
        if(frames>=framesAlive){
            EntityHandler.removeEntity(gameObject);
            frames = 0;
        }
    }
    
    @Override
    public void start(){
        gameObject.setPosition(initialPosition);
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
    }
}
