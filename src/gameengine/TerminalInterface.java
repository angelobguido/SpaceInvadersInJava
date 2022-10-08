/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;
import java.util.Vector;
/**
 *
 * @author angelo
 */
public class TerminalInterface extends VisualInterface {
    
    private char[][] canvas;
    private int width;
    private int heigth;
    
    public TerminalInterface(int width, int heigth){
        super(width, heigth);
        canvas = new char[width][heigth];
        clean();
    }
    
    public void draw(Drawable object){
        
        Vector<Vector2D> spriteStructure = object.image.spriteStructure();
        char charRepresentation = object.image.charRepresentation();
        Vector2D currentPosition;
        

        for(int i = 0; i<spriteStructure.size(); i++){

            currentPosition = Vector2D.addVectors(spriteStructure.elementAt(i), object.position);
            
            if(isOutOfBounds(currentPosition)==false){
                canvas[heigth - 1 - Math.round(currentPosition.y())][Math.round(currentPosition.x())] = charRepresentation;
            }

        }

    }
    
    private boolean isOutOfBounds(Vector2D position){
        int row = heigth - 1 - Math.round(position.y());
        int column = Math.round(position.x());
        
        return row>=heigth || row<0 || column>=width || column<0;
    }
    
    public void clean(){
        for(int i = 0; i<heigth; i++){
            for(int j = 0; j<width; j++){
                canvas[i][j] = '.';
            }
        }
    }
    
    public void update(){
        
        for(int i = 0; i<heigth; i++){
            for(int j = 0; j<width; j++){
                System.out.print(canvas[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeigth(int heigth){
        this.heigth = heigth;
    }
    
}
