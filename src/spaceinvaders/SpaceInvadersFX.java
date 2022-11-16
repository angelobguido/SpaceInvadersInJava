/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package spaceinvaders;

import gameengine.GameInitializer;
import graphics.GraphicInterface;
import graphics.TerminalInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author angelo
 */
public class SpaceInvadersFX extends Application {
    
    private VBox menuBox;
    private int currentItem = 0;
    private Stage stage;
    
    private static class Cross extends Parent{
        public Cross(){
            
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
    
    private static class MenuItem extends HBox {
        private Text text;
        private Cross cross1 = new Cross(), cross2 = new Cross();
        private Runnable script;
        
        public MenuItem(String name){
            super(10);
            setAlignment(Pos.CENTER);
            
            text = new Text(name);
            //text.setFont();
            //text.setEffect(new GaussianBlur(2));
            
            getChildren().addAll(cross1, text, cross2);
            setActive(false);
            
        }
        
        public void setActive(boolean b){
            text.setFill(b ? Color.WHITE : Color.GREY);
            cross1.setVisible(b);
            cross2.setVisible(b);
        }
        
        public void setOnActive(Runnable r){
            script = r;
        }
        
        public void activate(){
            if(script != null){
                script.run();
            }
        }
    }
    
    private Parent createContent(){
        StackPane root = new StackPane();
        root.setPrefSize(900, 600);
        
        Rectangle bg = new Rectangle(900, 600);
        
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnActive(() -> System.exit(0));
        
        MenuItem itemStart = new MenuItem("Start");
        itemStart.setOnActive(() -> {
            try{
                GameInitializer.init(stage);
            }catch(Exception e){
                System.exit(1);
                //Do nothing
            }
        });
        
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
    
    private Parent createGame(){
        Pane root = new Pane();
        Rectangle bg = new Rectangle(900, 600);
        root.getChildren().add(bg);
        return root;
    }
    
    private MenuItem getMenuItem(int index){
        return (MenuItem)menuBox.getChildren().get(index);
    }
    
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
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
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
