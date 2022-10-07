/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameExceptions.SameGameObjectException;
import gamemath.Vector2D;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class GameObject {
    public Vector2D position;
    private Vector<Component> components;
    private Vector<GameObject> children;
    private GameObject parent;
    
    public GameObject(){
        position = Vector2D.zero;
        components = new Vector<>();
        children = new Vector<>();
    }
    
    public GameObject(GameObject copy){
        position = new Vector2D(copy.position);
        components = new Vector<>(components);
        children = new Vector<>(children);
    }
    
    public void addChild(GameObject newChild) throws SameGameObjectException{
        if(newChild == this){
            throw new SameGameObjectException();
        }
        newChild.setParent(this);
        newChild.position = Vector2D.addVectors(position, newChild.position);
        children.add(newChild);
    }
    
    public void setParent(GameObject parent){
        this.parent = parent;
    }
    
    public GameObject parent(){
        return new GameObject(parent);
    }
    
    public GameObject getChild(int index){
        return children.elementAt(index);
    }
    
    public int childCount(){
        return children.size();
    }
    
    public void addComponent(Component newComponent){
        components.add(newComponent);
    }
    
    public void update(){
        components.forEach(component -> {component.update();});
    }
    
    public Component getComponent(ComponentId id){
        for(int i = 0; i<components.size(); i++){
            if(components.elementAt(i).id == id){
                return components.elementAt(i);
            }
        }
        return null;
    }
    
}
