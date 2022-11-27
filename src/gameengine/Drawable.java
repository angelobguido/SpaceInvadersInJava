/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This represents all the drawable objects.
 * @author angelo
 */
public class Drawable {
    public Sprite sprite;
    private Vector2D position;
    private Node graphics;
    private SimpleDoubleProperty xPosition = new SimpleDoubleProperty();
    private SimpleDoubleProperty yPosition = new SimpleDoubleProperty();
    private SimpleBooleanProperty disable = new SimpleBooleanProperty(true);
    private boolean isInScene = false;
    
    public Drawable(Sprite sprite, Vector2D position){
        this.sprite = sprite;
        this.position = position;
        
        if(sprite.content != null){
            graphics = sprite.content.generateContent();
        }
        
    }
    
    public Vector2D position(){
        return new Vector2D(position);
    }
    
    public SimpleDoubleProperty xPosition(){
        return xPosition;
    }
    
    public SimpleDoubleProperty yPosition(){
        return yPosition;
    }
    
    public SimpleBooleanProperty disable(){
        return disable;
    }
    
    public void enterScene(){
        isInScene = true;
    }
    
    public boolean isInScene(){
        return isInScene;
    }
    
    public Node graphics(){
        return graphics;
    }
}
