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
public class TerminalInterface extends VisualInterface {
    
    private char[][] canvas;
    private int width;
    private int heigth;
    
    public TerminalInterface(int width, int heigth){
        super(width, heigth);
        canvas = new char[width][heigth];
        clean();
    }
    
    public void draw(Sprite sprite, Vector2D position){
        canvas[Math.round(position.y())][Math.round(position.x())] = '#';
        update();
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
