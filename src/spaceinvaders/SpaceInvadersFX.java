/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package spaceinvaders;

import gameengine.GameHandlers.SceneManager;
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
import spaceinvaders.ScreenAssets.MenuItem;
import spaceinvaders.ScreenAssets.Selector;

/**
 *
 * @author angelo
 */
public class SpaceInvadersFX extends Application {
    
    @Override
    public void start(Stage stage) {
        
        SceneManager.setStage(stage);
    
        stage.setScene(SceneBuilder.createMenu(SceneBuilder.MenuSceneId.MainMenu).getScene());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
