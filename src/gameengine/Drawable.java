/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
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
    private Circle graphics;
    
    public Drawable(Sprite sprite, Vector2D position){
        this.sprite = sprite;
        this.position = position;
        
        graphics = new Circle(10);
        graphics.setFill(Color.WHITE);
    }
    
    public Vector2D position(){
        return new Vector2D(position);
    }
    
    public Node graphics(){
        return graphics;
    }
}
