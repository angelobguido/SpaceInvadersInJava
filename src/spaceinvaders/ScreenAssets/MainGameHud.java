/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders.ScreenAssets;

import gameengine.GameHandlers.SceneManager;
import gameengine.GameHandlers.SpaceInvaders.HealthManager;
import gameengine.GameHandlers.SpaceInvaders.ScoreManager;
import gameengine.GameInitializer;
import gameengine.GameScene;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import spaceinvaders.SceneBuilder;

/**
 *
 * @author angelo
 */
public class MainGameHud {
    
    private Parent createContent(){
        StackPane root = new StackPane();
        
        Text score = new Text();
        score.textProperty().bind(ScoreManager.currentScore());
        score.setFill(Color.WHITE);
        
        Text highScore = new Text();
        highScore.textProperty().bind(ScoreManager.highScore());
        highScore.setFill(Color.WHITE);
        
        VBox scoreBox = new VBox(score, highScore);
        scoreBox.setScaleX(3);
        scoreBox.setScaleY(3);
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setTranslateY(-350);
        
        ImageView heart1 = new ImageView();
        ImageView heart2 = new ImageView();
        ImageView heart3 = new ImageView();
        
        heart1.setFitHeight(30);
        heart1.setFitWidth(30);
        heart2.setFitHeight(30);
        heart2.setFitWidth(30);
        heart3.setFitHeight(30);
        heart3.setFitWidth(30);
        
        
        heart1.imageProperty().bind(HealthManager.heartImage1());
        heart2.imageProperty().bind(HealthManager.heartImage2());
        heart3.imageProperty().bind(HealthManager.heartImage3());
        
        HBox healthBar = new HBox(10, heart1, heart2, heart3);
        
        root.getChildren().addAll(scoreBox, healthBar);
        
        return root;
        
    }
    
    public Parent generateHUD() {
        
        Parent hud = createContent();
        
        return hud;
    }

}
