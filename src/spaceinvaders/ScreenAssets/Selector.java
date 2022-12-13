/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders.ScreenAssets;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Represents the image that appears when an MenuItem is active.
 *
 * @author angelo
 */
public class Selector extends Parent{
    public Selector(){

        Shape shape1 = new Rectangle(10, 2);
        shape1.setFill(Color.WHITE);
        shape1.setTranslateY(5);
        Shape shape2 = new Rectangle(2, 10);
        shape2.setFill(Color.WHITE);
        shape2.setTranslateX(5);

        getChildren().addAll(shape1, shape2);


        //setEffect(new GaussianBlur(2));

    }

}

