/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamemath;

/**
 *
 * @author angelo
 */
public class Vector2D {
    private float x;
    private float y;
    
    public static final Vector2D zero = new Vector2D(0,0); 
    public static final Vector2D up = new Vector2D(0,1);
    public static final Vector2D down = new Vector2D(0,-1);
    public static final Vector2D right = new Vector2D(1,0);
    public static final Vector2D left = new Vector2D(-1,0);
    
    Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public float x(){
        return x;
    }
    public float y(){
        return y;
    }
    
    public static Vector2D addVectors(Vector2D a, Vector2D b){
        return new Vector2D(a.x+b.x, a.y+b.y);
    }
    
    public static Vector2D subtractVectors(Vector2D a, Vector2D b){
        return new Vector2D(a.x-b.x, a.y-b.y);
    }
    
    public static Vector2D multiplyByScalar(Vector2D vector, float scalar){
        return new Vector2D(vector.x*scalar, vector.y*scalar);
    }
}
