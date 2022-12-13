/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameengine.GameHandlers.SpaceInvaders;

import java.io.File;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import spaceinvaders.GameObjectBuilder;

/**
 * Represents the game audio. It is used to play
 * sounds and musics pre-loaded inside this object.
 *
 * @author angelo
 */
public class GameAudioHandler {
    private static AudioClip alienBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/enemy_bullet.wav").toExternalForm());
    private static AudioClip playerBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/player_bullet.wav").toExternalForm());
    private static AudioClip specialBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/special_bullet.wav").toExternalForm());
    private static AudioClip alienKill = new AudioClip(GameObjectBuilder.class.getResource("sounds/kill.wav").toExternalForm());
    private static AudioClip playerHit = new AudioClip(GameObjectBuilder.class.getResource("sounds/player_hit.wav").toExternalForm());
    private static AudioClip select = new AudioClip(GameObjectBuilder.class.getResource("sounds/select.wav").toExternalForm());
    private static AudioClip powerUp = new AudioClip(GameObjectBuilder.class.getResource("sounds/power_up.wav").toExternalForm());
    private static AudioClip levelComplete = new AudioClip(GameObjectBuilder.class.getResource("sounds/level_complete.wav").toExternalForm());

    private static MediaPlayer UFOaudio = new MediaPlayer(new Media(GameObjectBuilder.class.getResource("sounds/ufo.wav").toExternalForm()));
    private static MediaPlayer mainScreen = new MediaPlayer(new Media(GameObjectBuilder.class.getResource("sounds/main_screen_music.wav").toExternalForm()));
    private static MediaPlayer background = new MediaPlayer(new Media(GameObjectBuilder.class.getResource("sounds/background_music.wav").toExternalForm()));
    private static MediaPlayer gameOver = new MediaPlayer(new Media(GameObjectBuilder.class.getResource("sounds/game_over.wav").toExternalForm()));
    
    public static void playAlienBullet(){
        alienBullet.play();
    }
    
    public static void playPlayerBullet(){
        playerBullet.play();
    }
    
    public static void playSpecialBullet(){
        specialBullet.play();
    }
    
    public static void playAlienKill(){
        alienKill.play();
    }
    
    public static void playPlayerHit(){
        playerHit.play();
    }
    
    public static void playSelect(){
        select.play();
    }
    
    public static void playPowerUp(){
        powerUp.play();
    }
    
    public static void playLevelComplete(){
        levelComplete.play();
    }
    
    public static void playGameOver(){
        gameOver.play();
    }
    
    public static void stopPlayingGameOver(){
        gameOver.stop();
    }
    
    public static void playUFOaudio(){
        UFOaudio.play();
    }
    
    public static void stopPlayingUFOaudio(){
        UFOaudio.stop();
    }
    
    public static void playBackGround(){
        background.setCycleCount(MediaPlayer.INDEFINITE);
        background.setVolume(0.4);
        background.play();
    }
    
    public static void stopPlayingBackGround(){
        background.stop();
    }

    public static void playMainScreenMusic(){
        mainScreen.setCycleCount(MediaPlayer.INDEFINITE);
        mainScreen.play();
    }
    
    public static void stopPlayingMainScreenMusic(){
        mainScreen.stop();
    }

}
