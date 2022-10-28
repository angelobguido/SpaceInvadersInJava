/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;

/**
 * Represents the base of all visual interfaces.
 * 
 * @author angelo
 */
public abstract class VisualInterface {
    
    public VisualInterface(int width, int heigth){
        setWidth(width);
        setHeigth(heigth);
    }
    
    /**
     * Function used to draw the drawable object in the viusal interface.
     * 
     * @param object 
     */
    public abstract void draw(Drawable object);
    
    /**
     * Will clear the screen of the visual interface.
     */
    public abstract void clean();
    
    /**
     * Will update the screen of the viusal interface.
     */
    public abstract void update();
    
    /**
     * Will set the width of the visual interface screen.
     * 
     * @param width 
     */
    protected abstract void setWidth(int width);
    
    /**
     * Will set the heigth of the viusal interface screen.
     * 
     * @param heigth 
     */
    protected abstract void setHeigth(int heigth);
    
    
}
