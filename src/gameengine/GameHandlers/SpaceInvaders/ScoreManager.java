/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

/**
 *
 * @author angelo
 */
public class ScoreManager {
    private static int highScore;
    private static int currentScore;
    
    public static void init(){
        currentScore = 0;
        highScore = 0;
    }
    
    public static void increment(int points){
        if(points < 0) return;
        
        currentScore+=points;
    }
    
    public static void reset(){
        currentScore = 0;
    }
    
}
