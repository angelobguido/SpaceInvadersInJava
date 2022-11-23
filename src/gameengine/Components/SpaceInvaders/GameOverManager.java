/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SceneManager;
import gameengine.GameInitializer;
import gameengine.GameObject;
import gameengine.Observer.Subscriber;
import java.util.ArrayList;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.MenuSceneId.GameOver;

/**
 * Represents the game over when the player dies.
 *
 * @author angelo
 */
public class GameOverManager extends Component implements Subscriber{
    
    public GameOverManager(GameObject gameObject){
        super(gameObject, ComponentId.GameOverManager);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        GameOverManager govm = new GameOverManager(gameObject);
        return govm;
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        ArrayList<GameObject> player = EntityHandler.findWithTag("Player");
        System.out.println(player.size());
        for(int i = 0; i < player.size(); i++){
            Hit playerHit = (Hit)player.get(i).getComponent(ComponentId.Hit);
            playerHit.deathEvent.subscribe(this);
        }
    }
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        
    }
    
    @Override
    public void onNotified(){
        GameInitializer.stop();
        SceneManager.loadMenuScene(SceneBuilder.createMenu(GameOver));
    }
    
}
