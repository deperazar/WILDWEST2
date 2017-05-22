/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author PERSONAL
 */
public class Enemys extends Thread{
    
    private double tetha;//angulo
    private int x;//posición en x
    private int y;//posición en y
    private int k;//numero de disparo
    private int o1;//velocidad disparo
    private int o2;
    private int o3;
    private int o4;
    private int o5;
    private int o6;
    
    public Enemys(){
        this.x=0;
        this.y=0;
        this.tetha=0;
        this.k=0;
        this.o1=0;
        this.o2=0;
        this.o3=0;
        this.o4=0;
        this.o5=0;
        this.o6=0;
    }
    
    private void draw(Graphics g, int n){
        if(n==0){
            Graphics2D g2d = (Graphics2D) g.create();
            double a=x-139;
            double b=y-349;
            if(b<=0){
                b=349-y;
                tetha= Math.PI/2+Math.atan(b/a);
            }else{
                tetha= Math.atan(a/b);
            }

            Image arm1= loadImage("arm2.png");
            g2d.drawLine(139, 349, 139, 545);
            g2d.rotate(-tetha,139, 349);
            g2d.drawImage(arm1, 80, 325,80,220, null);

        }
    }
    
    
    public void shoot(){
        
    }
    
    public Image loadImage(String imageName){
            ImageIcon ii= new ImageIcon(imageName);
            Image image =ii.getImage();
            return image;
        }
}
