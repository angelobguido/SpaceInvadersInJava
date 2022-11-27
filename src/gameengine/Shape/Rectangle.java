/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Shape;

import gamemath.Vector2D;

/**
 * Represents a rectangle shape.
 * @author angelo
 */
public class Rectangle {
    private Vector2D center; //the center of the rectangle
    private float width; //the width
    private float height; //the height
    
    public Rectangle(float width, float height, Vector2D position){
        center = position;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(Rectangle r){
        center = new Vector2D(r.center);
        this.width = r.width;
        this.height = r.height;
    }
    
    public Rectangle(Vector2D position){
        center = position;
        this.width = 1;
        this.height = 1;
    }
    
    public float width(){
        return width;
    }
    
    public float height(){
        return height;
    }
    
    /**
     * This function will set the dimensions of the rectangle.
     * 
     * @param width
     * @param height 
     */
    public void setDimensions(float width, float height){
        this.width = width;
        this.height = height;
    }
    
    /**
     * This function will tell if this rectangle is in contact with the other one.
     * It uses the gab between the rectangles sides.
     * 
     * @param otherRectangle is the rectangle that you want to test the contac with this.
     * @return a boolean that says if this rectangle is in contact or not with the other one.
     */
    public boolean isInContact(Rectangle otherRectangle){
      
        float thisMaxX = center.x + width/2;
        float thisMinX = center.x - width/2;
        float thisMaxY = center.y + height/2;
        float thisMinY = center.y - height/2;
        
        float otherMaxX = otherRectangle.center.x + otherRectangle.width/2;
        float otherMinX = otherRectangle.center.x - otherRectangle.width/2;
        float otherMaxY = otherRectangle.center.y + otherRectangle.height/2;
        float otherMinY = otherRectangle.center.y - otherRectangle.height/2;
        
        if(
            thisMaxX>otherMinX &&
            thisMinX<otherMaxX &&
            thisMaxY>otherMinY &&
            thisMinY<otherMaxY
          )
        {
            return true;
        }
        
        return false;
    }
    
}
