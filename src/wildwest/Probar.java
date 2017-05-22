/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author PERSONAL
 */
public class Probar {
    public static void main(String [] args){
        
        Thread hilo1=new Sonido("mmms.wav");
        hilo1.start();
        
        
    }
}
