/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author angelo
 */
public class GameImage extends GraphicalContent{
    
    private Image image;
    private double width;
    private double height;
    
    public GameImage(){
        
    }
    
    public GameImage(Image image, double width, double height){
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public Node generateContent(){
        
        if(image == null){
            Circle c = new Circle(10);
            c.setFill(Color.WHITE);

            return c;
        }
        
        ImageView i = new ImageView(image);
        i.setFitHeight(height);
        i.setFitWidth(width);
        i.setPreserveRatio(true);
        
        return i;
        
    }
}
