/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.GameHandlers.CollisionHandler;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.EventHandler;
import gameengine.GameHandlers.Graphics;
import gameengine.GameHandlers.InputHandler;
import gameengine.GameHandlers.PhysicsHandler;
import gameengine.GameHandlers.SceneManager;
import gameengine.GameHandlers.SpaceInvaders.HealthManager;
import gameengine.GameHandlers.SpaceInvaders.ProgressManager;
import gameengine.GameHandlers.SpaceInvaders.ScoreManager;
import graphics.GraphicInterface;

/**
 *
 * @author angelo
 */
public class GameInitializer {
    
    private static boolean hasStopped = false;
    private static int timesPlayed = 1;
    
    public static int frame = 0;
    
    public static void init(GameScene game){
        
        hasStopped = false;
        
        resetAll();
        
        Graphics.setGraphics(new GraphicInterface());
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
