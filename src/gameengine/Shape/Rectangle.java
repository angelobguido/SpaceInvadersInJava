/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Shape;

import gamemath.Vector2D;

/**
 *
 * @author angelo
 */


public class Rectangle {
    private Vector2D center;
    private float width;
    private float height;
    
    public Rectangle(float width, float height, Vector2D position){
        center = new Vector2D(position);
        this.width = width;
        this.height = height;
    }
    
    public void setCenter(Vector2D position){
        center.x = position.x;
        center.y = position.y;
    }
    
    public void setDimensions(float width, float height){
        this.width = width;
        this.height = height;
    }
    
    public boolean isInContact(Rectangle otherRectangle){
        
        int resolution = 50;
        
        float thisMaxX = otherRectangle.center.x + otherRectangle.width/2;
        float thisMimX = otherRectangle.center.x - otherRectangle.width/2;
        float thisMaxY = otherRectangle.center.y + otherRectangle.height/2;
        float thisMinY = otherRectangle.center.y - otherRectangle.height/2;
        
        float otherMaxX = otherRectangle.center.x + otherRectangle.width/2;
        float otherMimX = otherRectangle.center.x - otherRectangle.width/2;
        float otherMaxY = otherRectangle.center.y + otherRectangle.height/2;
        float otherMinY = otherRectangle.center.y - otherRectangle.height/2;
        
        if(thisMaxX<50)
    }
    
}
