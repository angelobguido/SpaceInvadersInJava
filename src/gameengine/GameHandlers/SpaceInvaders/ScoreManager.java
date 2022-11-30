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
import static java.lang.System.out;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author angelo
 */
public class ScoreManager {
    private static SimpleStringProperty highScoreText = new SimpleStringProperty("High Score: 0");
    private static SimpleStringProperty currentScoreText = new SimpleStringProperty("Score: 0");
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
        if(saveFile.exists()){
            System.out.println("aaa");
            try{
                DataInputStream input = new DataInputStream(new FileInputStream(saveFile));
                highScore = input.readInt();
                input.close();
            }catch(Exception e){
                //Do nothing
            }
            
        }
        
        highScoreText.set("High Score: "+Integer.toString(highScore));
        
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
