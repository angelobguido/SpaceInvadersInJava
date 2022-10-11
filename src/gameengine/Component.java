/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

/**
 *
 * @author angelo
 */

public abstract class Component {
    
    protected final GameObject gameObject;
    protected ComponentId id;
    protected boolean isEnabled;
    
    public Component(GameObject gameObject, ComponentId id){
        this.gameObject = gameObject;
        this.id = id;
        isEnabled = true;
    }
    
    public Component createCopy(GameObject gameObject){
        switch(id){
            case SpriteRenderer: return new SpriteRenderer(gameObject, ((SpriteRenderer)this).sprite());
            case Physics: return new Physics(gameObject);
            case Collider: return new Collider(gameObject);
            case Hit: return new Hit(gameObject);
        }
        return null;
    }
    
    public void disable(){
        isEnabled = false;
    }
    
    public void enable(){
        isEnabled = true;
    }
    
    public abstract void update();
    public abstract void start();
}
