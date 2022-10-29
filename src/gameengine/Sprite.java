/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import java.util.ArrayList;

/**
 * Represents the visual representation of objects.
 * 
 * @author angelo
 */
public class Sprite {
    private char charRepresentation; //the char that will be printed in the terminal interface.
    private ArrayList<Vector2D> spriteStructure; //the first vector2D of this vector is the considered the center of this sprite.
    
    public Sprite(char charRepresentation, ArrayList<Vector2D> spriteStructure){
        this.charRepresentation = charRepresentation;
        this.spriteStructure = spriteStructure;
    }
    
    public Sprite(Sprite copy){
        this.charRepresentation = copy.charRepresentation;
        this.spriteStructure = copy.spriteStructure();
    }
    
    /**
     * This function will get the charRepresentation member.
     * 
     * @return The char representation of the sprite. 
     */
    public char charRepresentation(){
        return charRepresentation;
    }
    
    /**
     * This function will get a copy of the spriteStructure member.
     * 
     * @return The sprite structure that represents the positions of the pixels in the terminal interface. 
     */
    public ArrayList<Vector2D> spriteStructure(){
        return new ArrayList<Vector2D>(spriteStructure);
    }
}
