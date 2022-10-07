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
public class CharSprite extends Sprite{

    public final char charRepresentation;
    public final Vector<Vector2D> spriteStructure; //o vetor zero pode ser considerado o centro do sprite
    
    public CharSprite(char charRepresentation, Vector<Vector2D> spriteStructure){
        this.charRepresentation = charRepresentation;
        this.spriteStructure = spriteStructure;
    }
    
}
