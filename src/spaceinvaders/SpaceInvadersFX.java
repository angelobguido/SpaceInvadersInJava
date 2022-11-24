/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package spaceinvaders;

import gameengine.GameHandlers.SceneManager;
import gameengine.GameHandlers.SpaceInvaders.ScoreManager;
import javafx.application.Application;

import javafx.stage.Stage;

/**
 *
 * @author angelo
 */
public class SpaceInvadersFX extends Application {
    
    @Override
    public void start(Stage stage) {
        
        SceneManager.setStage(stage);
        ScoreManager.init();
    
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
