/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author PERSONAL
 */
public class Sonido extends Thread {
    private Clip sound;
    private Boolean seguir;
    
    public Sonido(String rutaarchivo){
        this.seguir=true;
         try {
              sound = AudioSystem.getClip();
              sound.open(AudioSystem.getAudioInputStream(new File(rutaarchivo)));
               
          } catch (UnsupportedAudioFileException ex) {
             
              System.out.println("ERROR");
          } catch (IOException ex) {
              
              System.out.println("ERROR");
          } catch (LineUnavailableException ex) {
              
              System.out.println("ERROR");
          }
    }
    
    @Override 
    public void run(){
        sound.start();
        do{
              try {
              Thread.sleep(500);
              } catch (InterruptedException ex) {
                  System.out.println("ERROR");
              }
               
          }while (seguir && sound.isActive());
           
          if(sound.isActive()){
              sound.stop();
          }
           
          // Se cierra el clip.
          sound.close();
        
    }
    public void parar(){
          seguir=false;
      }
   
    
}
