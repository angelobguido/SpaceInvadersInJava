/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class ProgressManager {
    private static int level = 1;
    
    public static void nextLevel(){
        level++;
    }
    
    public static void reset(){
        level = 1;
    }
    
    public static Vector2D getAlienInitialVelocity(){
        return new Vector2D(0.1f+(level-1)*0.02f, 0);
    }
    
    public static float getAlienVelocityMultiplier(){
        return 1.05f+(level-1)*0.01f;
    }
    
    public static double getAlienAttackRate(){
        return 0.02+(level-1)*0.08;
    }
    
    
}