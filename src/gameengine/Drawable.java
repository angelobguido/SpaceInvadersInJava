/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import javafx.scene.canvas.GraphicsContext;
/**
 * This represents all the drawable objects.
 * @author angelo
 */
public class Drawable {
    public Sprite sprite;
    private Vector2D position;
    
    public Drawable(Sprite sprite, Vector2D position){
        this.sprite = sprite;
        this.position = position;
        
    }
    
    public Vector2D position(){
        return new Vector2D(position);
    }
    
     public void drawGameImage(GraphicsContext gameScreen){
        gameScreen.drawImage(sprite.image, position.x*10+125 - sprite.image.getWidth()/2, -position.y*10 + 800 - sprite.image.getHeight()/2);
    }
    
}
