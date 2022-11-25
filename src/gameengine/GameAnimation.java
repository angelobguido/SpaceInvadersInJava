/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author angelo
 */
public class GameAnimation extends GraphicalContent {
    
    private final ArrayList<Image> images = new ArrayList<>();
    private double width;
    private double height;
    
    public GameAnimation(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public void addImage(Image image){
        images.add(image);
    }
    
    @Override
    public Node generateContent(){
        ImageView view = new ImageView();
        view.setFitHeight(height);
        view.setFitWidth(width);
        view.setPreserveRatio(true);
        
        Timeline timeline = new Timeline();

        timeline.setCycleCount(Timeline.INDEFINITE);
        Duration frameGap = Duration.millis(256);
        Duration frameTime = Duration.ZERO ;
        for(int i = 0; i < images.size(); i++){
            frameTime = frameTime.add(frameGap);
            final Image current = images.get(i);
            timeline.getKeyFrames().add(new KeyFrame(frameTime, e -> view.setImage(current)));
        }
        
        timeline.play();

        
        return view;
    }
}
