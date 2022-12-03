/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import gameengine.GameHandlers.SceneManager;
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
    private GraphicsContext gameScreen;
    private Stack<Drawable> draws = new Stack<>();
    private Stack<Drawable> undraws = new Stack<>();
    
    
    public GraphicInterface(){
        super(0, 0);
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
        
        Platform.runLater(() -> {
            
            gameScreen = SceneManager.getGameScreen();
        
            clear();

            while(draws.isEmpty() == false){

                Drawable currentDraw = draws.pop();

                currentDraw.drawGameImage(gameScreen);
            }
        
        
        });
        

    }
    
    private void clear(){
        gameScreen.clearRect(0, 0, 900, 900);
    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.height = heigth;
    }
}
