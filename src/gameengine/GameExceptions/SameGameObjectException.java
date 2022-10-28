/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameExceptions;

/**
 * Represents the exception of assing the same object to itself.
 * 
 * @author angelo
 */
public class SameGameObjectException extends RuntimeException {
    public SameGameObjectException(){
        super("Trying to assign game object parent or child to itself");
    }
}
