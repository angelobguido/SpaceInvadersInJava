/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public abstract class VisualInterface {
    
    public VisualInterface(int width, int heigth){
        setWidth(width);
        setHeigth(heigth);
    }
    
    public abstract void draw(Sprite sprite, Vector2D position);
    public abstract void clean();
    
    protected abstract void setWidth(int width);
    protected abstract void setHeigth(int heigth);
    
    
}
