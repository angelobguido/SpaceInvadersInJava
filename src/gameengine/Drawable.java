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
public class Drawable {
    public Sprite image;
    public Vector2D position;
    
    public Drawable(Sprite image, Vector2D position){
        this.image = image;
        this.position = position;
    }
}
