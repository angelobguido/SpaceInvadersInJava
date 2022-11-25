/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import spaceinvaders.GameObjectBuilder;

/**
 *
 * @author angelo
 */

public class HealthManager {
    private static SimpleObjectProperty heartImage1Property = new SimpleObjectProperty();
    private static SimpleObjectProperty heartImage2Property = new SimpleObjectProperty();
    private static SimpleObjectProperty heartImage3Property = new SimpleObjectProperty();
    private static int currentLife = 3;
    
    public static SimpleObjectProperty heartImage1(){
        return heartImage1Property;
    }
    
    public static SimpleObjectProperty heartImage2(){
        return heartImage2Property;
    }
    
    public static SimpleObjectProperty heartImage3(){
        return heartImage3Property;
    }
    
    public static void takeHit(){
        
        if(currentLife <= 0) return;
        
        currentLife--;
        
        switch (currentLife){
            case 0:
                heartImage1Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                heartImage2Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                heartImage3Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                break;
                
            case 1:
                heartImage1Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                heartImage2Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                heartImage3Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                break;
                
            case 2:
                heartImage1Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                heartImage2Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                heartImage3Property.set(new Image(GameObjectBuilder.class.getResource("images/empty_heart.png").toExternalForm()));
                break;
                
            case 3:
                heartImage1Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                heartImage2Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                heartImage3Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
                break;
                
        }
       
    }
    
    public static void reset(){
        
        currentLife = 3;
        
        heartImage1Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
        heartImage2Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
        heartImage3Property.set(new Image(GameObjectBuilder.class.getResource("images/heart.png").toExternalForm()));
    }
    
    
}
