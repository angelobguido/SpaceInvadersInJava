/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameExceptions.SameGameObjectException;
import gameengine.GameHandlers.EntityHandler;
import gamemath.Vector2D;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Represents the base object of the game engine.
 * The game object will store all the needed components to represent something in the game.
 * 
 * @author angelo
 */
public class GameObject {
    private String tag = ""; //tag used to find this game object
    private Vector2D position; //position in the game world
    private ArrayList<Component> components = new ArrayList<>(); //list of all components used in this game object.
    private Stack<Component> removedComponentsBuffer = new Stack<>(); //buffer that will store all components that will be removed
    private ArrayList<GameObject> children = new ArrayList<>(); //list of all children of this game object
    private GameObject parent; //this game object parent.
    
    public GameObject(){
        position = new Vector2D(0,0);
        components = new ArrayList<>();
        children = new ArrayList<>();
        removedComponentsBuffer = new Stack<>();
    }
    
    public GameObject(GameObject copy){
        
        tag = copy.tag;
        
        position = new Vector2D(copy.position);
        
        for(int i = 0; i<copy.components.size(); i++){
            components.add(copy.components.get(i).createCopy(this));
        }
        
        for(int i = 0; i<copy.children.size(); i++){
            GameObject currentChild = new GameObject(copy.children.get(i));
            currentChild.parent = this;
            children.add(currentChild);
        }
        
    }
    
    /**
     * Update the state of this game object, calling the update of all stored components.
     */
    public void update(){
        
        while(removedComponentsBuffer.isEmpty() == false){
            components.remove(removedComponentsBuffer.pop());
        }
        
        components.forEach(component -> {component.update();});
        children.forEach(child -> {child.update();});
    }
    
    /**
     * Will call the start of all this game object components
     */
    public void start(){
        components.forEach(component -> {component.start();});
        children.forEach(child -> {child.start();});
    }
    
    /**
     * Will remove this game object from the game world.
     * This function will call the destroy of all components in this game object.
     */
    public void destroy(){
        
        if(Debug.bullet == this){
            Debug.bullet = null;
            Debug.entity = null;
            Debug.destroyFrame = GameInitializer.frame;
        }
        
        if(parent!=null){
            parent.children.remove(this);
        }
        
        destroyComponentsRecursive(this);
        
    }
    
    private void destroyComponentsRecursive(GameObject go){
        
        go.components.forEach(component -> component.destroy());
        
        components.clear();
        
        go.children.forEach(child -> destroyComponentsRecursive(child));
    
    }
    
    /**
     * Will add a new child to this game object.
     * 
     * @param newChild
     * @throws SameGameObjectException 
     */
    public void addChild(GameObject newChild) throws SameGameObjectException{
        if(newChild == this){
            throw new SameGameObjectException();
        }
        newChild.parent = this;
        children.add(newChild);
    }
    
    /**
     * Will set the game object parent.
     * 
     * @param parent
     * @throws SameGameObjectException 
     */
    public void setParent(GameObject parent) throws SameGameObjectException{
        if(parent == this){
            throw new SameGameObjectException();
        }
        parent.children.add(this);
        this.parent = parent;
    }
    
    /**
     * Will return a copy of this game object parent.
     * 
     * @return the parent game object copy. 
     */
    public GameObject parent(){
        return new GameObject(parent);
    }
    
    
    /**
     * Will get the child at the desired index.
     * 
     * @param index
     * @return the chosen game object.
     */
    public GameObject getChild(int index){
        return children.get(index);
    }
    
    /**
     * Will return how many children there are in this game object.
     * 
     * @return children size
     */
    public int childCount(){
        return children.size();
    }
    
    /**
     * Will add a new component to this game object
     * 
     * @param newComponent 
     */
    public void addComponent(Component newComponent){
        components.add(newComponent);
    }
    
    public void removeComponent(Component c){
        removedComponentsBuffer.push(c);
    }
    
    /**
     * Will get the first component with chosen id.
     * This function don't search in children.
     * 
     * @param id the id that represents the component you want.
     * @return the first Component with the id.
     */
    public Component getComponent(ComponentId id){
        
        for(int i = 0; i<components.size(); i++){
            
            if(components.get(i).id == id){
                return components.get(i);
            }
        }
        return null;
    }
    
    /**
     * Will get all the components with the chosen id.
     * This function search in children.
     * 
     * @param id the id that represents the components you want.
     * @return the list of all components with the id
     */
    public ArrayList<Component> getComponents(ComponentId id){
        
        ArrayList<Component> componentsFound = new ArrayList<>();
        
        _getComponents(id, componentsFound);
        
        return componentsFound;
    }
    
    private void _getComponents(ComponentId id, ArrayList<Component> componentsFound){
        
        for(int i = 0; i < components.size(); i++){
            
            Component currentComponent = components.get(i);
            
            if(currentComponent.id == id){
                componentsFound.add(currentComponent);
            }
        }
        
        for(int i = 0; i < children.size(); i++){
            children.get(i)._getComponents(id, componentsFound);
        }
        
        
    }
    
    /**
     * Will change the current position.
     * 
     * @param newPosition is the Vector2D that represents the new position.
     */
    public void setPosition(Vector2D newPosition){
        Vector2D deslocation = Vector2D.subtractVectors(newPosition, position);
        
        position.x = newPosition.x;
        position.y = newPosition.y;
        children.forEach(child -> {child.setPosition(Vector2D.addVectors(child.position, deslocation));});
    }
    
    /**
     * Will verify if the desired tag string is the same as this game object tag.
     * 
     * @param compare is the string tag you want to compare with.
     * @return a boolean that indicates if the tag is equal or not.
     */
    public boolean tagIsEqual(String compare){
        return compare.equals(tag);
    }
    
    /**
     * Will set a new tag to this game object.
     * 
     * @param newTag 
     */
    public void setTag(String newTag){
        this.tag = new String(newTag);
    }
    
    /**
     * Will get a copy of the current game object position.
     * 
     * @return a Vector2D representing the game object position.
     */
    public Vector2D position(){
        return new Vector2D(position);
    }
    
    /**
     * Will get an actual position reference of the game object.
     * 
     * @return this Vector2D position.
     */
    public Vector2D getPositionReference(){
        return position;
    }
    
}
