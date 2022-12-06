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
   public enum Command{Shoot, Right, Left, Stop, Nothing};
   
   private static ConcurrentLinkedQueue<Command> moveCommands = new ConcurrentLinkedQueue<>();
   private static ConcurrentLinkedQueue<Command> actionCommands = new ConcurrentLinkedQueue<>();
   
   private static int frameCount = 0;
   private static final int maxFrame = 20;
   
   
   public static void sendButton(KeyCode code){
       switch(code){
           case SPACE: actionCommands.add(Command.Shoot); break;
           case A: moveCommands.add(Command.Left); break;
           case D: moveCommands.add(Command.Right); break;
           case LEFT: moveCommands.add(Command.Left); break;
           case RIGHT: moveCommands.add(Command.Right); break;
           
           //default: commands.add(Command.Nothing); break;
       }
   }
   
   public static void sendRelease(KeyCode code){
       switch(code){
           case A: moveCommands.add(Command.Stop); break;
           case D: moveCommands.add(Command.Stop); break;
           case LEFT: moveCommands.add(Command.Stop); break;
           case RIGHT: moveCommands.add(Command.Stop); break;
           
       }
   }
   
   public static Command getMoveCommand(){
       Command last = moveCommands.poll();
       if(last==null){
           last = Command.Nothing;
       }
       
       return last;
   }
   
   public static Command getActionCommand(){
       Command last = actionCommands.poll();
       if(last==null){
           last = Command.Nothing;
       }
       
       return last;
   }
   
   public static void update(){
       frameCount++;
       if(frameCount>maxFrame){
           frameCount=0;
           //commands.clear();
       }
   }
   
   public static void reset(){
       moveCommands.clear();
   }
   
}
