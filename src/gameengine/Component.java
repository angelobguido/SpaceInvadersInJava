/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

/**
 *
 * @author angelo
 */

enum ComponentId{Physics, SpriteRenderer}

public abstract class Component {
    
    protected final GameObject gameObject;
    protected ComponentId id;
    
    public Component(GameObject gameObject, ComponentId id){
        this.gameObject = gameObject;
        this.id = id;
    }
    
    public abstract void update();
}
