/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import javafx.scene.Scene;

/**
 *
 * @author angelo
 */
public class MenuScene {
    private Scene fxScene;
    public boolean isMain = false;
    public boolean isGameOver = false;
    
    public void setScene(Scene s){
        fxScene = s;
    }
    
    public Scene getScene(){
        return fxScene;
    }
}
