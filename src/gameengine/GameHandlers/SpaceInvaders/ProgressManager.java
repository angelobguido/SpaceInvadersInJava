/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import gamemath.Vector2D;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author angelo
 */
public class ProgressManager {
    private static int level = 1;
    private static SimpleStringProperty levelText = new SimpleStringProperty("LEVEL: 1");
    
    public static void nextLevel(){
        level++;
        levelText.set("LEVEL: "+level);
        GameAudioHandler.playLevelComplete();
    }
    
    public static void reset(){
        level = 1;
        levelText.set("LEVEL: "+level);
    }
    
    public static SimpleStringProperty levelText(){
        return levelText;
    }
    
    public static Vector2D getAlienInitialVelocity(){
        return new Vector2D(0.05f+(level-1)*0.01f, 0);
    }
    
    public static float getAlienVelocityMultiplier(){
        return 1.05f+(level-1)*0.003f;
    }
    
    public static double getAlienAttackRate(){
        return 0.01+(level-1)*0.009;
    }
    
    
}
