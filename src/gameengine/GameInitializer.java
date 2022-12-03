/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameHandlers.*;
import gameengine.GameHandlers.SpaceInvaders.*;
import graphics.VisualInterface;

/**
 *
 * @author angelo
 */
public class GameInitializer {
    
    private static boolean hasStopped = false;
    private static int timesPlayed = 1;
    
    public static int frame = 0;
    
    public static void init(GameScene game, VisualInterface visual){
        
        hasStopped = false;
        
        resetAll();
        
        Graphics.setGraphics(visual);
        SceneManager.loadGameScene(game);
        SceneManager.update();
        
        Thread t = new Thread( () ->{
            
            while(hasStopped == false){
                
                frame++;
                
                Graphics.update();
                CollisionHandler.update();
                EventHandler.update();
                EntityHandler.update();
                PhysicsHandler.update();
                SceneManager.update();
                InputHandler.update();
                
                try{
                    Thread.sleep(25);
                }catch(Exception e){
                    System.exit(1);
                }
 
            }
            
            
        });
        
        t.start();
        
    }
    
    public static void reInit(GameScene game){
        ProgressManager.nextLevel();
        SceneManager.loadGameScene(game);
    }
    
    private static void resetAll(){
        CollisionHandler.reset();
        EntityHandler.reset();
        EventHandler.reset();
        Graphics.reset();
        InputHandler.reset();
        HealthManager.reset();
        ScoreManager.reset();
        PhysicsHandler.reset();
        ProgressManager.reset();
        
        frame = 0;
    }
    
    public static void stop(){
        hasStopped = true;
    }
}
