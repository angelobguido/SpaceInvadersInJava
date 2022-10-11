/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gameengine.Observer.Subscriber;

/**
 *
 * @author angelo
 */
public class Hit extends Component implements Subscriber{
    
    Collider col;
    
    public Hit(GameObject gameObject){
        super(gameObject, ComponentId.Hit);
    }
    
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void start(){
        col = (Collider)gameObject.getComponent(ComponentId.Collider);
        col.subscribe(this);
    }
    
    @Override
    public void onNotified(){
        System.out.println("colidiu");
    }
}
