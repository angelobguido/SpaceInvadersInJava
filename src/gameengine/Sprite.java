/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 * Represents the visual representation of objects.
 * 
 * @author angelo
 */
public class Sprite {
    public char charRepresentation; //the char that will be printed in the terminal interface.
    public ArrayList<Vector2D> spriteStructure; //the first vector2D of this vector is the considered the center of this sprite.
    public GraphicalContent content;
    public Image image;
}
