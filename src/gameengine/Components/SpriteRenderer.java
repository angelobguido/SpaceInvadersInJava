/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Drawable;
import gameengine.GameHandlers.Graphics;
import gameengine.GameObject;
import gameengine.Sprite;
import gamemath.Vector2D;

/**
 *
 * @author angelo
 */
public class SpriteRenderer extends Component{
    
    private Sprite sprite;
    
    public SpriteRenderer(GameObject gameObject, Sprite sprite){
        super(gameObject, ComponentId.SpriteRenderer);
        this.sprite = sprite;
    }
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
    
    public Sprite sprite(){
        return new Sprite(sprite);
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        
        SpriteRenderer newSpriteRenderer = new SpriteRenderer(gameObject, sprite);
        
        return newSpriteRenderer;
    }
    
    @Override
    public void update(){
        Graphics.putInRenderBuffer(new Drawable(sprite, gameObject.getPositionReference()));
    }
    
    @Override
    public void start(){
        
    }
    
    @Override
    public void destroy(){
        sprite = null;
        gameObject.removeComponent(this);
        gameObject = null;
    }
}
