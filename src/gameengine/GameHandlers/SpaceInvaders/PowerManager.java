/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

/**
 * Represents the manager that tells the player if a PowerUp was got.
 *
 * @author angelo
 */
public class PowerManager {
    private static boolean hasPower = false;
    
    public static void addPower(){
        hasPower = true;
    }
    
    public static boolean getPower(){
        if(hasPower==true){
            hasPower = false;
            return true;
        }
        
        return false;
    }
}
