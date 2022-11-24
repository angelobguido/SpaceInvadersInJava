/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author angelo
 */
public class ScoreManager {
    private static SimpleStringProperty highScoreText = new SimpleStringProperty("High Score: 0");
    private static SimpleStringProperty currentScoreText = new SimpleStringProperty("Score: 0");
    private static int highScore = 0;
    private static int currentScore = 0;
    
    public static void init(){
        getHighScore();
    }
    
    public static SimpleStringProperty highScore(){
        return highScoreText;
    }
    
    public static SimpleStringProperty currentScore(){
        return currentScoreText;
    }
    
    public static void increment(int points){
        if(points < 0) return;
        
        currentScore += points;
        
        currentScoreText.set("Score: "+Integer.toString(currentScore));
        
        if(currentScore > highScore){
            highScoreText.set("HighScore: "+Integer.toString(currentScore));
            highScore = currentScore;
        }
    }
    
    public static void reset(){
        
        currentScore = 0;
        
        currentScoreText.set("Score: "+Integer.toString(currentScore));
    }
    
    private static void getHighScore(){
        highScoreText.set("High Score: 100");
        highScore = 100;
    }
    
    public static void saveHighScore(){
        //ToDo
    }
    
}
