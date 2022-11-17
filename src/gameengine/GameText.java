/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import javafx.scene.Node;
import javafx.scene.text.Text;

/**
 *
 * @author angelo
 */
public class GameText extends GraphicalContent {
    
    private String text;
    
    public GameText(String text){
        this.text = text;
    }
    
    @Override
    public Node generateContent(){
        return new Text(text);
    }
}
