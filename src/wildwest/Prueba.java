/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author PERSONAL
 */
public class Prueba extends Character implements Runnable{
    private int x;
    private int y;

    public Prueba(int life, int ID) {
        super(life, ID);
    }
    
   

    @Override
    public void run() {
      shoot();
    }
}

   
