/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author angelo
 */
public class GameImage extends GraphicalContent{
    @Override
    public Node generateContent(){
        Circle c = new Circle(10);
        c.setFill(Color.WHITE);
        
        return c;
    }
}
