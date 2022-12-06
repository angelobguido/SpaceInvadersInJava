/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameHandlers.SceneManager;
import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import gameengine.GameInitializer;
import gameengine.GameObject;
import spaceinvaders.GameObjectBuilder;
import spaceinvaders.SceneBuilder;
import static spaceinvaders.SceneBuilder.MenuSceneId.GameOver;

/**
 *
 * @author angelo
 */
public class AlienController extends Component {
    
    
    public AlienController(GameObject gameObject){
        super(gameObject, ComponentId.AlienController);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        AlienController newAlienController = new AlienController(gameObject);
        
        return newAlienController;
    }
    
    @Override
    public void update(){
        
        if(gameObject.position().y < 0){
            System.out.println("END");
            GameInitializer.stop();
            SceneManager.loadMenuScene(SceneBuilder.createMenu(GameOver));
        }
        
    }
    
    @Override
    public void start(){
        
    }
    
    
    @Override
    public void destroy(){
        
        GameObject effect = GameObjectBuilder.create(GameObjectBuilder.Prefab.Effect);
        effect.setPosition(gameObject.position());
        EntityHandler.addEntity(effect);
        
        GameAudioHandler.playAlienKill();

        gameObject.removeComponent(this);
        gameObject = null;
        
    }
    
}
