/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import gameengine.Drawable;
import graphics.VisualInterface;
import gamemath.Vector2D;
import java.util.ArrayList;

/**
 * Represents the terminal interface.
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
    
    @Override
    public void draw(Drawable object){
        
        ArrayList<Vector2D> spriteStructure = object.sprite.spriteStructure;
        char charRepresentation = object.sprite.charRepresentation;
        Vector2D currentPosition;
        

        for(int i = 0; i<spriteStructure.size(); i++){

            currentPosition = Vector2D.addVectors(spriteStructure.get(i), object.position());
            
            if(isOutOfBounds(currentPosition)==false){
                canvas[heigth - 1 - Math.round(currentPosition.y())][Math.round(currentPosition.x())] = charRepresentation;
            }

        }

    }
    
    @Override
    public void undraw(Drawable object){
        
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
    
    @Override
    public void update(){
        
        clean();
        
        for(int i = -1; i<heigth+1; i++){
            for(int j = -1; j<width+1; j++){
                if(i==-1||j==-1||i==heigth||j==width){
                    System.out.print("#"+" ");
                }else{
                    System.out.print(canvas[i][j]+" ");
                }
                
            }
            System.out.println();
        }
    }
    
    @Override
    protected void setWidth(int width){
        this.width = width;
    }
    
    @Override
    protected void setHeigth(int heigth){
        this.heigth = heigth;
    }
    
}
