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
 *
 * @author angelo
 */
public class GameAudioHandler {
    private static AudioClip alienBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/enemy_bullet.wav").toExternalForm());
    private static AudioClip playerBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/player_bullet.wav").toExternalForm());
    private static AudioClip specialBullet = new AudioClip(GameObjectBuilder.class.getResource("sounds/special_bullet.wav").toExternalForm());
    private static AudioClip alienKill = new AudioClip(GameObjectBuilder.class.getResource("sounds/kill.wav").toExternalForm());
    private static MediaPlayer UFOaudio = new MediaPlayer(new Media(GameObjectBuilder.class.getResource("sounds/ufo.wav").toExternalForm()));
    
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
    
    public static void playUFOaudio(){
        UFOaudio.play();
    }
    
    public static void stopPlayingUFOaudio(){
        UFOaudio.stop();
    }

}
