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
    
    public Component(GameObject gameObject, ComponentId id){
        this.gameObject = gameObject;
        this.id = id;
    }
    
    public Component createCopy(GameObject gameObject){
        switch(id){
            case SpriteRenderer: return new SpriteRenderer(gameObject, ((SpriteRenderer)this).sprite());
            case Physics: return new Physics(gameObject);
            case Collider: return new Collider(gameObject);
        }
        return null;
    }
    
    public abstract void update();
}
