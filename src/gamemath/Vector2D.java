/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamemath;

/**
 * Represents the math two-dimensional vector, that stores positions.
 * 
 * @author angelo
 */
public class Vector2D {
    public float x;
    public float y;
    
    public static final Vector2D zero = new Vector2D(0,0); 
    public static final Vector2D up = new Vector2D(0,1);
    public static final Vector2D down = new Vector2D(0,-1);
    public static final Vector2D right = new Vector2D(1,0);
    public static final Vector2D left = new Vector2D(-1,0);
    
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2D(Vector2D copy){
        this.x = copy.x;
        this.y = copy.y;
    }
    
    public float x(){
        return x;
    }
    public float y(){
        return y;
    }
    
    /**
     * Static function that will add two vectors.
     * a + b
     * 
     * @param a 
     * @param b
     * @return the vector2d that is the sum of the two vectors.
     */
    public static Vector2D addVectors(Vector2D a, Vector2D b){
        return new Vector2D(a.x+b.x, a.y+b.y);
    }
    
    /**
     * Static function that will subtract two vectors.
     * a - b
     * 
     * @param a
     * @param b
     * @return the vector that is the subtraction of the two vectors. 
     */
    public static Vector2D subtractVectors(Vector2D a, Vector2D b){
        return new Vector2D(a.x-b.x, a.y-b.y);
    }
    
    /**
     * Static function that will multiply a vector by a scalar.
     * 
     * @param vector
     * @param scalar
     * @return the vector tha is the scaled one.
     */
    public static Vector2D multiplyByScalar(Vector2D vector, float scalar){
        return new Vector2D(vector.x*scalar, vector.y*scalar);
    }
}
