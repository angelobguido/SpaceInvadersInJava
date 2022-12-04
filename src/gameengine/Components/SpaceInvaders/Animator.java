/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.Components.SpaceInvaders;

import gameengine.Component;
import gameengine.ComponentId;
import gameengine.Components.SpriteRenderer;
import gameengine.GameObject;
import gameengine.Sprite;
import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class Animator extends Component {
    
    private int framesPerSprite = 10;
    private int frames = 0;
    private int currentSprite = 0;
    private ArrayList<Sprite> animation;
    private SpriteRenderer spriteRenderer;
    
    public Animator(GameObject gameObject){
        super(gameObject, ComponentId.Animator);
        animation = new ArrayList<>();
    }
    
    public Animator(GameObject gameObject, int framesPerSprite){
        super(gameObject, ComponentId.Animator);
        animation = new ArrayList<>();
        this.framesPerSprite = framesPerSprite;
    }
    
    public Animator(GameObject gameObject, ArrayList<Sprite> animation){
        super(gameObject, ComponentId.Animator);
        this.animation = animation;
    }
    
    public Animator(GameObject gameObject, ArrayList<Sprite> animation, int framesPerSprite){
        super(gameObject, ComponentId.Animator);
        this.animation = animation;
        this.framesPerSprite = framesPerSprite;
    }
    
    public ArrayList<Sprite> animation(){
        return animation;
    }
    
    @Override
    public Component createCopy(GameObject gameObject){
        return new Animator(gameObject, animation);
    }
    
    @Override
    public void update(){
        frames++;
        if(frames>=framesPerSprite){
            changeSprite();
            frames = 0;
        }
    }
    
    private void changeSprite(){
        if(currentSprite >= animation.size()){
            currentSprite = 0;
        }
        
        spriteRenderer.setSprite(animation.get(currentSprite));
        currentSprite++;
    }
    
    
    @Override
    public void start(){
        spriteRenderer = (SpriteRenderer)gameObject.getComponent(ComponentId.SpriteRenderer);
        
    }
    
    
    @Override
    public void destroy(){
        gameObject.removeComponent(this);
        gameObject = null;
        spriteRenderer = null;
    }
}
