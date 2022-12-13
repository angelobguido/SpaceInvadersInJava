/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import graphics.Drawable;
import gameengine.GameHandlers.Graphics;
import gameengine.GameObject;
import gameengine.Sprite;

/**
 * Represents the component that updates the game object representation on the 
 * visual interface.
 *
 * @author angelo
 */
public class SpriteRenderer extends Component{
    
    private Drawable drawElement;
    
    public SpriteRenderer(GameObject gameObject, Sprite sprite){
        super(gameObject, ComponentId.SpriteRenderer);
        this.drawElement = new Drawable(sprite, gameObject.getPositionReference());
    }
    
    /**
     * Will set a new sprite to this SpriteRenderer.
     *
     * @param sprite
     */
    public void setSprite(Sprite sprite){
        drawElement.sprite = sprite;
    }
      
    @Override
    public Component createCopy(GameObject gameObject){
        
        SpriteRenderer newSpriteRenderer = new SpriteRenderer(gameObject, drawElement.sprite);
        
        return newSpriteRenderer;
    }
    
    @Override
    public void update(){
        Graphics.putInRenderBuffer(drawElement);
    }
    
    @Override
    public void start(){
        
    }
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        Graphics.putInUndrawBuffer(drawElement);
        drawElement = null;
    }
}
