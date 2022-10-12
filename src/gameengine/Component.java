/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.Components.Hit;
import gameengine.Components.SpriteRenderer;
import gameengine.Components.Physics;
import gameengine.Components.Collider;

/**
 *
 * @author angelo
 */

public abstract class Component {
    
    protected GameObject gameObject;
    protected ComponentId id;
    protected boolean isEnabled;
    
    public Component(GameObject gameObject, ComponentId id){
        this.gameObject = gameObject;
        this.id = id;
        isEnabled = true;
    }
    
    public void disable(){
        isEnabled = false;
    }
    
    public void enable(){
        isEnabled = true;
    }
    
    public abstract Component createCopy(GameObject gameObject);
    public abstract void update();
    public abstract void start();
    public abstract void destroy();
}
