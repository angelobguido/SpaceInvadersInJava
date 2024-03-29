/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;

/**
 * Represents the component that destroy the game object after some frames. It is
 * used to destroy effects.
 * 
 * @author angelo
 */
public class EffectController extends Component {
    private static final int framesAlive = 20;
    private int frames = 0;

    public EffectController(GameObject gameObject){
        super(gameObject, ComponentId.EffectController);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        return new EffectController(gameObject);
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

    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
    }
}
