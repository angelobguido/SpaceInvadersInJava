/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class GameObject {
    private Vector2D position;
    private Vector<Component> components;
    
    public GameObject(){
        position = Vector2D.zero;
        components = new Vector<>();
    }
    
    public Vector2D position(){
        return position;
    }
    
    public void addComponent(Component newComponent){
        components.add(newComponent);
    }
    
    public void setPosition(Vector2D newPosition){
        position = newPosition;
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
