/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import gameengine.Drawable;
import gameengine.GameHandlers.SceneManager;
import gamemath.Vector2D;
import java.util.Stack;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;


/**
 *
 * @author angelo
 */
public class GraphicInterface extends VisualInterface {
    private static final double offSet = 300;
    private int width;
    private int height;
    private StackPane root;
    private GraphicsContext canvasPane;
    private Stack<Drawable> draws = new Stack<>();
    private Stack<Drawable> undraws = new Stack<>();
    
    
    public GraphicInterface(GraphicsContext canvasPane){
        super(0, 0);
        this.canvasPane = canvasPane;
    }
    
    @Override
    public void draw(Drawable object){
        
        draws.push(object);

    }
    
    @Override
    public void undraw(Drawable object){
        
        undraws.push(object);
        
    }
    
    @Override
    public void update(){
        
        clear();
        
        while(draws.isEmpty() == false){

            Drawable currentDraw = draws.pop();

            Vector2D position = currentDraw.position();

            canvasPane.drawImage(currentDraw.sprite.image, position.x*10, -position.y*10+800);

        }

    }
    
    private void clear(){
        canvasPane.clearRect(0, 0, 1200, 1200);
    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.height = heigth;
    }
}
