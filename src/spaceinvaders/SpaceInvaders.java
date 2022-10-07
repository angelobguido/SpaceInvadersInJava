/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spaceinvaders;

import gameengine.CharSprite;
import gameengine.Graphics;
import gameengine.GraphicsId;
import gamemath.Vector2D;
import java.util.Vector;
/**
 *
 * @author angelo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graphics.setGraphics(GraphicsId.Terminal);
        
        Vector<Vector2D> basicStructure = new Vector<>();
        basicStructure.add(Vector2D.zero);
        
        CharSprite basic = new CharSprite('#', basicStructure);
        
        Graphics.draw(basic, Vector2D.up);
        
        Graphics.clean();
        
        
        for(int i = 0; i<35; i++){
            Graphics.draw(basic, Vector2D.multiplyByScalar(Vector2D.addVectors(Vector2D.up, Vector2D.right), i));
        }
        for(int i = 0; i<35; i++){
            Graphics.draw(basic, Vector2D.multiplyByScalar(Vector2D.addVectors(Vector2D.up, Vector2D.zero), i));
        }
        for(int i = 0; i<35; i++){
            Graphics.draw(basic, Vector2D.multiplyByScalar(Vector2D.addVectors(Vector2D.right, Vector2D.zero), i));
        }
        
        
        Vector<Vector2D> complexStructure = new Vector<>();
        complexStructure.add(Vector2D.zero);
        complexStructure.add(Vector2D.up);
        complexStructure.add(Vector2D.multiplyByScalar(Vector2D.up, 1));
        complexStructure.add(Vector2D.multiplyByScalar(Vector2D.up, 2));
        complexStructure.add(Vector2D.multiplyByScalar(Vector2D.right, 1));
        complexStructure.add(Vector2D.multiplyByScalar(Vector2D.right, 2));
        
        CharSprite complex = new CharSprite('$', complexStructure);
        
        Graphics.draw(complex, Vector2D.multiplyByScalar(Vector2D.addVectors(Vector2D.multiplyByScalar(Vector2D.right, 10), Vector2D.up), 5));
        Graphics.draw(complex, Vector2D.multiplyByScalar(Vector2D.addVectors(Vector2D.multiplyByScalar(Vector2D.right, 3), Vector2D.up), 5));
        
    }
    
}
