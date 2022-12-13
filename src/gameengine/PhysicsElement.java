/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine;

import gamemath.Vector2D;

/**
 *  Represents the physics element used inside Physics Manager to change
 * position of the entities every frame.
 * 
 * @author angelo
 */
public class PhysicsElement {
    public GameObject entity;
    public Vector2D translation;
    
    public PhysicsElement(GameObject entity, Vector2D translation){
        this.entity = entity;
        this.translation = translation;
    }
}
