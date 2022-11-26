/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import gameengine.Drawable;
import gameengine.GameHandlers.SceneManager;
import gamemath.Vector2D;
import java.util.ArrayList;
import java.util.Stack;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author angelo
 */
public class GraphicInterface extends VisualInterface {
    private static final double offSet = 300;
    private int width;
    private int height;
    private StackPane root;
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
        
        root = SceneManager.getCurrentRoot();

        if(root == null){
            return;
        }
        
        Platform.runLater(()->{
            
            while(draws.isEmpty() == false){

                Drawable currentDraw = draws.pop();

                Vector2D position = currentDraw.position();

                currentDraw.graphics().setTranslateX(position.x*10 - offSet);
                currentDraw.graphics().setTranslateY(-position.y*10 + offSet);

                if(!root.getChildren().contains(currentDraw.graphics())){
                    root.getChildren().add(currentDraw.graphics());
                }

            }

            while(undraws.isEmpty() == false){

                Drawable currentDraw = undraws.pop();

                root.getChildren().remove(currentDraw.graphics());

            }

        });
        
    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.height = heigth;
    }
}
