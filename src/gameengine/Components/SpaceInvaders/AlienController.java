/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.Physics;
import gameengine.GameHandlers.SceneManager;
import gameengine.GameInitializer;
import gameengine.GameObject;
import gamemath.Vector2D;
import static java.lang.Math.random;
import java.util.ArrayList;
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
        gameObject.removeComponent(this);
        gameObject = null;
        
    }
    
}
