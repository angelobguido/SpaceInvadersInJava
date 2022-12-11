/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spaceinvaders;

import gameengine.ComponentId;
import gameengine.Components.SpaceInvaders.GameObjectManager;
import gameengine.Components.Physics;
import gameengine.Components.SpaceInvaders.PlayerAttack;
import gameengine.GameHandlers.InputHandler;
import gameengine.GameObject;
import gameengine.GameScene;
import gameengine.MenuScene;
import gamemath.Vector2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import spaceinvaders.GameObjectBuilder.Prefab;
import spaceinvaders.ScreenAssets.GameOverScreen;
import spaceinvaders.ScreenAssets.MainGameHud;
import spaceinvaders.ScreenAssets.MainMenuScreen;
import spaceinvaders.ScreenAssets.VictoryScreen;

/**
 * Builder used to build the space invaders scenes.
 * @author angelo
 */

public class SceneBuilder {
    public enum GameSceneId{GameMain}
    public enum MenuSceneId{GameOver, Victory, MainMenu}
    
    /**
     * Static function that builds the desired scene.
     * @param id is the id of the scene you want to build.
     * @return the desired scene.
     */
    public static GameScene createGame(GameSceneId id){
        
        switch(id){
            case GameMain:
                
                return generateMainGame();
        
        }
        
        return generateMainGame();
        
    }
    
    public static MenuScene createMenu(MenuSceneId id){
        
        switch(id){
            case GameOver: 
                
                return generateGameOver();
                
                
            case Victory:
                
                return generateVictory();
                
            case MainMenu:
                
                return generateMainMenu();
                
            
        }
        
        return generateMainMenu();
    }
    
    private static MenuScene generateGameOver(){
        
        MenuScene scene = new MenuScene();
        
        GameOverScreen gos = new GameOverScreen(createGame(GameSceneId.GameMain));
        
        System.out.println("GAME OVER!");
        
        scene.setScene(gos.generateScene());
        
        scene.isGameOver = true;
        
        return scene;
    }
    
    private static MenuScene generateVictory(){
        
        MenuScene scene = new MenuScene();
        
        VictoryScreen vs = new VictoryScreen(createGame(GameSceneId.GameMain));
        
        System.out.println("Victory!");
        
        scene.setScene(vs.generateScene());
        
        return scene;
    }
    
    private static MenuScene generateMainMenu(){
        
        MenuScene scene = new MenuScene();
        
        MainMenuScreen mms = new MainMenuScreen(createGame(GameSceneId.GameMain));
        
        scene.setScene(mms.generateScene());
        
        scene.isMain = true;
        
        return scene;
    }
    
    private static GameScene generateMainGame(){
        
        GameScene scene = new GameScene();
        
        GameObject player = GameObjectBuilder.create(Prefab.Player);
        GameObject aliens = GameObjectBuilder.create(Prefab.AliensMatrix);

        aliens.setPosition(new Vector2D(0,30));

        player.setPosition(new Vector2D(0,2));

        GameObject obstacle1 = GameObjectBuilder.create(Prefab.BigObstacle);
        GameObject obstacle2 = GameObjectBuilder.create(Prefab.BigObstacle);
        GameObject obstacle3 = GameObjectBuilder.create(Prefab.BigObstacle);
        GameObject obstacle4 = GameObjectBuilder.create(Prefab.BigObstacle);

        obstacle1.setPosition(new Vector2D(7,6));
        obstacle2.setPosition(new Vector2D(23,6));
        obstacle3.setPosition(new Vector2D(38,6));
        obstacle4.setPosition(new Vector2D(54,6));

        GameObject gameOverManager = new GameObject();
        gameOverManager.addComponent(new GameObjectManager(gameOverManager));

        scene.addEntity(aliens);
        scene.addEntity(player);
        scene.addEntity(obstacle1);
        scene.addEntity(obstacle2);
        scene.addEntity(obstacle3);
        scene.addEntity(obstacle4);
        scene.addEntity(gameOverManager);

        Canvas canvas = new Canvas(900, 900);

        StackPane root = new StackPane();

        ImageView bg = new ImageView(new Image(SceneBuilder.class.getResource("images/background.png").toExternalForm()));
        bg.setFitHeight(900);
        bg.setFitHeight(900);
        bg.setPreserveRatio(true);
        
        MainGameHud hud = new MainGameHud();
        
        StackPane gameScreen = new StackPane();
        
        gameScreen.getChildren().add(canvas);
        gameScreen.setAlignment(Pos.BOTTOM_LEFT);
        
        
        root.getChildren().addAll(bg, gameScreen, hud.generateHUD());

        scene.setScene(new Scene(root));

        scene.setCanvasPane(canvas.getGraphicsContext2D());
        
        scene.getScene().setOnKeyPressed((event)->{
            InputHandler.sendButton(event.getCode());
        });
        
        scene.getScene().setOnKeyReleased((event)->{
            InputHandler.sendRelease(event.getCode());
        });
   
        return scene;
    }
    
}