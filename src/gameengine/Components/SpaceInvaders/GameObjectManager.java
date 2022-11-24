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
import static java.lang.Math.random;
import java.util.ArrayList;
import spaceinvaders.GameObjectBuilder;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.MenuSceneId.GameOver;

/**
 * Represents the game over when the player dies.
 *
 * @author angelo
 */
public class GameObjectManager extends Component implements Subscriber{
    
    private int timer = 0;
    private final int time = 50;
    
    public GameObjectManager(GameObject gameObject){
        super(gameObject, ComponentId.GameObjectManager);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        GameObjectManager govm = new GameObjectManager(gameObject);
        return govm;
    }
    
    @Override
    public void update(){
        
        timer++;
        if(timer<time) return;
        
        timer = 0;
        
        if(random() < 0.25){
            EntityHandler.addEntity(GameObjectBuilder.create(GameObjectBuilder.Prefab.UFO));
        }
        
    }
    
    @Override
    public void start(){
        ArrayList<GameObject> player = EntityHandler.findWithTag("Player");
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
