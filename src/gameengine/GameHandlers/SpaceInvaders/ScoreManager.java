/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.beans.property.SimpleStringProperty;

/**
 * Represents the manager that shows the score on the 
 * screen, and save the high score in a file.
 *
 * @author angelo
 */
public class ScoreManager {
    private static SimpleStringProperty highScoreText = new SimpleStringProperty("HIGH SCORE: 0");
    private static SimpleStringProperty currentScoreText = new SimpleStringProperty("SCORE: 0");
    private static File saveFile = new File("score.bin");
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
        
        currentScoreText.set("SCORE: "+Integer.toString(currentScore));
        
        if(currentScore > highScore){
            highScoreText.set("HIGH SCORE: "+Integer.toString(currentScore));
            highScore = currentScore;
        }
    }
    
    public static void reset(){
        
        currentScore = 0;
        
        currentScoreText.set("SCORE: "+Integer.toString(currentScore));
    }
    
    private static void getHighScore(){
        if(saveFile.exists()){
            try{
                DataInputStream input = new DataInputStream(new FileInputStream(saveFile));
                highScore = input.readInt();
                input.close();
            }catch(Exception e){
                //Do nothing
            }
            
        }
        
        highScoreText.set("HIGH SCORE: "+Integer.toString(highScore));
        
    }
    
    public static void saveHighScore(){
        try{
            DataOutputStream output = new DataOutputStream(new FileOutputStream(saveFile));
            output.writeInt(highScore);
            output.close();
        }catch(Exception e){
            //Do nothing
        }
        
        
    }
    
}
