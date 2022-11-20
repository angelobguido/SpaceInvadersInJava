/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers;

import java.util.concurrent.ConcurrentLinkedQueue;
import javafx.scene.input.KeyCode;

/**
 *
 * @author angelo
 */
public class InputHandler {
   public enum Command{Shoot, Right, Left, Nothing};
   
   private static ConcurrentLinkedQueue<Command> commands = new ConcurrentLinkedQueue<>();
   
   private static int frameCount = 0;
   private static final int maxFrame = 5;
   
   
   public static void sendButton(KeyCode code){
       switch(code){
           case SPACE: commands.add(Command.Shoot); break;
           case A: commands.add(Command.Left); break;
           case D: commands.add(Command.Right); break;
           case LEFT: commands.add(Command.Left); break;
           case RIGHT: commands.add(Command.Right); break;
           
           default: commands.add(Command.Nothing); break;
       }
   }
   
   public static Command getCommand(){
       Command last = commands.poll();
       if(last==null){
           last = Command.Nothing;
       }
       
       return last;
   }
   
   public static void update(){
       frameCount++;
       if(frameCount>maxFrame){
           frameCount=0;
           commands.clear();
       }
   }
   
}
