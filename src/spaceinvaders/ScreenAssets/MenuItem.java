/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders.ScreenAssets;

import gameengine.GameHandlers.SpaceInvaders.GameAudioHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author angelo
 */
public class MenuItem extends HBox {
        private Text text;
        private Selector cross1 = new Selector(), cross2 = new Selector();
        private Runnable script;
        
        public MenuItem(String name){
            super(10);
            setAlignment(Pos.CENTER);
            
            text = new Text(name);
            //text.setFont();
            //text.setEffect(new GaussianBlur(2));
            
            getChildren().addAll(cross1, text, cross2);
            setActive(false);
            
        }
        
        public void setActive(boolean b){
            text.setFill(b ? Color.WHITE : Color.GREY);
            cross1.setVisible(b);
            cross2.setVisible(b);
        }
        
        public void setOnActive(Runnable r){
            script = r;
        }
        
        public void activate(){
            GameAudioHandler.playSelect();
            if(script != null){
                script.run();
            }
        }
    }