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
    private int width;
    private int height;
    private StackPane root;
    private Stack<Drawable> draws = new Stack<>();
    private Stack<Drawable> moves = new Stack<>();
    private Stack<Drawable> undraws = new Stack<>();
    
    
    public GraphicInterface(){
        super(0, 0);
    }
    
    @Override
    public void draw(Drawable object){
        
        if(object.isInScene()){
            moves.push(object);
            return;
        }
        
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
        
        Platform.runLater(()-> {

            while(draws.isEmpty() == false){

                Drawable currentDraw = draws.pop();

                Vector2D position = currentDraw.position();

                currentDraw.xPosition().set(position.x*10 - 200);
                currentDraw.yPosition().set(-position.y*10 + 200);

                currentDraw.graphics().translateXProperty().bind(currentDraw.xPosition());
                currentDraw.graphics().translateYProperty().bind(currentDraw.yPosition());
                currentDraw.graphics().visibleProperty().bind(currentDraw.disable());
                
                currentDraw.enterScene();

                root.getChildren().add(currentDraw.graphics());

            }

        });
        
        while(moves.isEmpty() == false){

            Drawable currentDraw = moves.pop();

            Vector2D position = currentDraw.position();

            currentDraw.xPosition().set(position.x*10 - 200);
            currentDraw.yPosition().set(-position.y*10 + 200);

        }
        
        while(undraws.isEmpty() == false){

            Drawable currentDraw = undraws.pop();
            currentDraw.disable().set(false);
            
        }

        

    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.height = heigth;
    }
}
