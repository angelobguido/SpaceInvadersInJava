/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author angelo
 */
public class GameImage{
    
    public Image image;
    public double width;
    public double height;
    
    public GameImage(Image image, double width, double height){
        this.image = image;
        this.width = width;
        this.height = height;
    }
   
}
