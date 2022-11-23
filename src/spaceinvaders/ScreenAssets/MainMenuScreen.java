/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders.ScreenAssets;

import gameengine.GameHandlers.SceneManager;
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

/**
 *
 * @author angelo
 */
public class MainMenuScreen {
    private VBox menuBox;
    private int currentItem = 0;
    private GameScene mainGame;
    private Stage stage;
    
    public MainMenuScreen(GameScene mainGame){
        this.mainGame = mainGame;
    }
    
    private Parent createContent(){
        StackPane root = new StackPane();
        root.setPrefSize(900, 600);
        
        Rectangle bg = new Rectangle(900, 600);
        
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnActive(() -> System.exit(0));
        
        MenuItem itemStart = new MenuItem("Start");
        itemStart.setOnActive(() -> GameInitializer.init(mainGame));
        
        menuBox = new VBox(10, itemStart, itemExit);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setScaleX(2);
        menuBox.setScaleY(2);
        
        getMenuItem(0).setActive(true);
        
        Text title = new Text("SPACE INVADERS");
        title.setFill(Color.WHITE);
        title.setTranslateY(-200);
        title.setScaleX(4);
        title.setScaleY(4);
        
        root.getChildren().addAll(bg, title, menuBox);
        
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
