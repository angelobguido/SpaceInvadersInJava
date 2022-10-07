/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

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
    
    @Override
    public void update(){
        Graphics.draw(sprite, gameObject.position());
    }
}
