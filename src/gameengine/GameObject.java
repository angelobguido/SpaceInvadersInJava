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
    private Vector2D position;
    private Vector<Component> components;
    private Vector<GameObject> children;
    private GameObject parent;
    
    public GameObject(){
        position = new Vector2D(0,0);
        components = new Vector<>();
        children = new Vector<>();
    }
    
    public GameObject(GameObject copy){
        
        position = new Vector2D(copy.position);
        
        components = new Vector<>();
        
        for(int i = 0; i<copy.components.size(); i++){
            components.add(copy.components.elementAt(i).createCopy(this));
        }
        
        children = new Vector<>();
        
        for(int i = 0; i<copy.children.size(); i++){
            children.add(new GameObject(copy.children.elementAt(i)));
        }
        
    }
    
    public void addChild(GameObject newChild) throws SameGameObjectException{
        if(newChild == this){
            throw new SameGameObjectException();
        }
        newChild.parent = this;
        children.add(newChild);
    }
    
    public void setParent(GameObject parent) throws SameGameObjectException{
        if(parent == this){
            throw new SameGameObjectException();
        }
        parent.children.add(this);
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
        children.forEach(child -> {child.update();});
    }
    
    //Get the first component with chosen component id, don't search in children
    public Component getComponent(ComponentId id){
        
        for(int i = 0; i<components.size(); i++){
            
            if(components.elementAt(i).id == id){
                return components.elementAt(i);
            }
        }
        return null;
    }
    
    //Get all components with the chosen component id, search in children
    public Vector<Component> getComponents(ComponentId id){
        
        Vector<Component> componentsFound = new Vector<>();
        
        for(int i = 0; i < components.size(); i++){
            
            Component currentComponent = components.elementAt(i);
            
            if(currentComponent.id == id){
                componentsFound.add(currentComponent);
            }
        }
        
        _getComponents(id, componentsFound);
        
        return componentsFound;
    }
    
    private void _getComponents(ComponentId id, Vector<Component> componentsFound){
        
        for(int i = 0; i < components.size(); i++){
            
            Component currentComponent = components.elementAt(i);
            
            if(currentComponent.id == id){
                componentsFound.add(currentComponent);
            }
        }
        
        for(int i = 0; i < children.size(); i++){
            children.elementAt(i)._getComponents(id, componentsFound);
        }
        
        
    }
    
    public void setPosition(Vector2D newPosition){
        Vector2D deslocation = Vector2D.subtractVectors(newPosition, position);
        
        position.x = newPosition.x;
        position.y = newPosition.y;
        children.forEach(child -> {child.setPosition(Vector2D.addVectors(child.position, deslocation));});
    }
    
    public Vector2D position(){
        return new Vector2D(position);
    }
    
    public Vector2D getPositionReference(){
        return position;
    }
    
}
