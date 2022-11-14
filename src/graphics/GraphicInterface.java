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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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
    private Stack<Drawable> drawStack = new Stack<>();
    
    
    public GraphicInterface(){
        super(0, 0);
    }
    
    public void draw(Drawable object){
        
        drawStack.push(object);

    }
    
    public void clean(){
        root.getChildren().clear();
        
    }
    
    public void update(){
        while(drawStack.isEmpty() == false){
            
            root = SceneManager.getCurrentRoot();
            
            Vector2D position = drawStack.pop().position;
            
            if(root != null){
                root.getChildren().add(new Circle(position.x, -position.y, 5));
            }
            
        }
    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.height = heigth;
    }
}
