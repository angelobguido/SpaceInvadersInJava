/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.GameHandlers.EntityHandler;
import gameengine.GameObject;

/**
 *
 * @author angelo
 */
public class BulletLife extends Component {
    
    public BulletLife(GameObject gameObject){
        super(gameObject, ComponentId.BulletLife);    
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        BulletLife newBulletLife = new BulletLife(gameObject);
        return newBulletLife;
    }
    
    @Override
    public void update(){
        if(gameObject.position().y < -500 || gameObject.position().y > +500){
            EntityHandler.removeEntity(gameObject);
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
