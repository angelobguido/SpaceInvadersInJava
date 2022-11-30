/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders.ScreenAssets;

import gameengine.GameHandlers.SceneManager;
import gameengine.GameHandlers.SpaceInvaders.ScoreManager;
import gameengine.GameInitializer;
import gameengine.GameScene;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import spaceinvaders.SceneBuilder;

/**
 *
 * @author angelo
 */
public class GameOverScreen {
    private VBox menuBox;
    private int currentItem = 0;
    private GameScene mainGame;
    
    public GameOverScreen(GameScene mainGame){
        this.mainGame = mainGame;
    }
    
    private Parent createContent(){
        StackPane root = new StackPane();
        root.setPrefSize(900, 600);
        
        Rectangle bg = new Rectangle(900, 600);
        
        MenuItem itemRetry = new MenuItem("Retry");
        itemRetry.setOnActive(() -> GameInitializer.init(mainGame));
        
        MenuItem itemMenu = new MenuItem("Menu");
        itemMenu.setOnActive(() -> SceneManager.loadMenuScene(SceneBuilder.createMenu(SceneBuilder.MenuSceneId.MainMenu)));
        
        MenuItem itemQuit = new MenuItem("Quit");
        itemQuit.setOnActive(() -> {System.out.println("Quit"); ScoreManager.saveHighScore(); System.exit(0);});
        
        menuBox = new VBox(10, itemRetry, itemMenu, itemQuit);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setScaleX(2);
        menuBox.setScaleY(2);
        
        getMenuItem(0).setActive(true);
        
        Text title = new Text("GAME OVER!");
        title.setFill(Color.WHITE);
        title.setTranslateY(-200);
        title.setScaleX(4);
        title.setScaleY(4);
        
        Text score = new Text();
        score.setFill(Color.WHITE);
        score.textProperty().bind(ScoreManager.currentScore());
        
        Text highScore = new Text();
        highScore.setFill(Color.WHITE);
        highScore.textProperty().bind(ScoreManager.highScore());
        
        VBox scoreBox = new VBox(2, score, highScore);
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setTranslateY(-150);
        
        root.getChildren().addAll(bg, title, scoreBox, menuBox);
        
        return root;
        
    }
    
    
    private MenuItem getMenuItem(int index){
        return (MenuItem)menuBox.getChildren().get(index);
    }
    
    public Scene generateScene() {
        
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.UP){
                if (currentItem > 0){
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }
            
            if(event.getCode() == KeyCode.DOWN){
                if(currentItem < menuBox.getChildren().size() -1){
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }
            
            if(event.getCode() == KeyCode.ENTER){
                getMenuItem(currentItem).activate();
                
            }
        });
        
        return scene;
    }

    
}
