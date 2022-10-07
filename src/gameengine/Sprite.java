/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import java.util.Vector;

/**
 *
 * @author angelo
 */
public class Sprite {
    private char charRepresentation;
    private Vector<Vector2D> spriteStructure; //o vetor zero pode ser considerado o centro do sprite
    
    public Sprite(char charRepresentation, Vector<Vector2D> spriteStructure){
        this.charRepresentation = charRepresentation;
        this.spriteStructure = spriteStructure;
    }
    
    public Sprite(Sprite copy){
        this.charRepresentation = copy.charRepresentation;
        this.spriteStructure = copy.spriteStructure();
    }
    
    public char charRepresentation(){
        return charRepresentation;
    }
    
    public Vector<Vector2D> spriteStructure(){
        return new Vector<Vector2D>(spriteStructure);
    }
}
