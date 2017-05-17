/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

import java.applet.AudioClip;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Visual extends JFrame {

    public Visual() {

        add(new Newpanel());

    }

    public static void main(String[] args) {
        Visual cuadro = new Visual();
        cuadro.setTitle("WILD WEST");
        cuadro.setSize(2000, 1000);
        cuadro.setLocationRelativeTo(null);
        cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadro.setVisible(true);

    }

}

class Newpanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    private Timer time;
    private int o;
    private int y;
    private int i;
    private int m;//activar el boton start
    private int r;//resalto en el roast
    private int n;//Cambio de pantalla
    private int u;//Activación sonido
    private int q;//Sonido opcion
    private Clip soundintro;//musica del intro
    private Clip options;
    private Clip shoot;//sonido de disparo

    public Newpanel() {
        this.i = 0;
        this.addMouseListener(this);
        this.time = new Timer(25, this);
        this.time.start();
        this.o = 5;
        this.m = 0;
        this.y = 5;
        this.r = 0;
        this.u = 1;
        this.q = 0;
        this.n = 0;

        try {
            this.soundintro = AudioSystem.getClip();
            this.soundintro.open(AudioSystem.getAudioInputStream(new File("mmms.wav")));
            this.soundintro.start();
        } catch (Exception l) {
            System.out.println(" " + l);
        }
        try {
            this.options = AudioSystem.getClip();
            this.options.open(AudioSystem.getAudioInputStream(new File("options.wav")));
        } catch (Exception l) {
            System.out.println(" " + l);
        }
        try {
            this.shoot = AudioSystem.getClip();
            this.shoot.open(AudioSystem.getAudioInputStream(new File("shoot.wav")));
        } catch (Exception l) {
            System.out.println(" " + l);
        }

    }

    protected void drawScenenario(Graphics g) {

    }

    /* private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        
        Image arm1= loadImage("arm1.gif");
        g2d.drawImage(arm1, 180, 295, 100,247 ,this);
        g2d.setPaint(new Color(150, 150, 150));
        //g2d.fillRect(186, 305, 80, 50);
        g2d.translate(250, 315);
        g2d.rotate(2, 0, 0);
        g2d.drawImage(arm1, 0+12, 0-12, 100,247 ,this);
      
        g2d.fillRect(0, 0, 80, 50);
        g2d.dispose();
    }*/
    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image menu = loadImage("Mainmenu.gif");
        Image botonsonido = loadImage("Sonido_1.gif");
        Image roast = loadImage("Roast.gif");
        Image highlight = loadImage("highlights.gif");
        Image buttons = loadImage("Botones.gif");
        
        
        Image background = loadImage("FONDO.gif");
        Image c1= loadImage("man1.gif");
        Image c2= loadImage("sprite2.png");
        Image c3= loadImage("sprite3.png");
        Image c4= loadImage("man1.gif");
        Image c5= loadImage("man1.gif");
        Image c6= loadImage("man1.gif");
        
        Image revolvercamera = loadImage("Recamararevolver.gif");
        Image bullet1 = loadImage("Bullet_1.gif");
        Image bullet2 = loadImage("Bullet_1.gif");
        Image bullet3 = loadImage("Bullet_1.gif");
        Image bullet4 = loadImage("Bullet_1.gif");
        Image bullet5 = loadImage("Bullet_1.gif");
        Image bullet6 = loadImage("Bullet_1.gif");
        Image bullet7 = loadImage("Bullet_1.gif");

        //g2d.drawImage(person, 200, 150, 150, 600, this);
        if (n == 0) {
            g.drawImage(menu, -180, 0, null);
            if (u == 1 || u == 2) {
                g.drawImage(botonsonido, 950, 770, 1130, 870, 0, 0, 1302, 740, null);
            } else if (u == 0) {
                g.drawImage(botonsonido, 950, 770, 1130, 870, 0, 740, 1302, 1497, null);
            }
            g.drawRect(725, 510, 445, 105);
            g.drawRect(725, 645, 445, 105);
        } else if (n == 1) {
            g.drawImage(roast, 0, 0, 2000, 1000, this);
            g.drawRect(130, 345, 290, 410);
            g.drawRect(420, 345, 290, 410);
            g.drawRect(710, 345, 290, 410);
            
            g.drawImage(buttons, 50, 800, 350, 900, 0, 731, 1229, 1092, this);
            if(m==1){
                g.drawImage(buttons, 1500, 800, 1800, 900, 8, 1110, 1229, 1463, this);
            }
            
            
            if(r==1){
                g.drawImage(highlight, 85, 300, 370, 500, this);
            }
            else if(r==2){
                g.drawImage(highlight, 380, 300, 370, 500, this);
            }
            else if(r==3){
                g.drawImage(highlight, 660, 300, 370, 500, this);
            }
            
            //n=2;

        }
        
        if(n==3){
            g.drawImage(background, 0, -500, this);
            if(r==1){
                g.drawImage(c1, 100, 200, 120, 500, this);
                g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
            }
            else if(r==2){
                g.drawImage(c2, 100, 250, 160, 450, this);
                g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
            }
            else if(r==3){
                g.drawImage(c3, 200, 300, 120, 500, this);
            }
            
            
            
            
            //g.drawImage(c1, 100, 200, 120, 500, this);
            //g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
        }

        /*g.drawImage(person, 200, 150, 150, 600, this);
        g.drawImage(revolvercamera, 140, 750, 200, 200, this);
        g.drawImage(bullet1, 212, 762, 55, 55, this);
        g.drawImage(bullet2, 160, 792, 55, 55, this);
        g.drawImage(bullet3, 160, 853, 55, 55, this);
        g.drawImage(bullet4, 212, 884, 55, 55, this);
        g.drawImage(bullet5, 265, 853, 55, 55, this);
        g.drawImage(bullet6, 265, 792, 55, 55, this);
        g.drawImage(bullet7, 500+o, 500+y, 55, 55, this);*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*double k = Math.toRadians(i);

        o = (int) (300 * Math.cos(k));
        y = (int) (300 * Math.sin(k));

        i += 1;*/

        if (u == 0) {
            this.soundintro.stop();
        } else if (u == 2) {
            this.soundintro.start();
        }
        /*if(q==1){
            this.options.start();
        }*/

        repaint();

        // System.out.println(k);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(n==0){
            Rectangle start = new Rectangle(725, 510, 445, 105);
            Rectangle highscores = new Rectangle(725, 645, 445, 105);
            Rectangle soundswitch = new Rectangle(950, 770, 180, 100);
            if (soundswitch.contains(mp)) {
            if (u == 0) {
                u = 2;
            } else {
                u = 0;
            }
            }
            if (start.contains(mp)) {
                this.shoot.loop(1);

                //this.shoot.start();
                n = 1;
            } else if (highscores.contains(mp)) {
                //this.shoot.loop(1);
                this.shoot.start();
            }
            
        }

        else if(n==1){
            Rectangle back = new Rectangle(50, 800, 300, 100);
            Rectangle play = new Rectangle(1500, 800, 300, 100);
            Rectangle p1 = new Rectangle(130, 345, 290, 410);
            Rectangle p2 = new Rectangle(420, 345, 290, 410);
            Rectangle p3 = new Rectangle(710, 345, 290, 410);
            
            if(p1.contains(mp)){
                System.out.println("hi");
                m=1;
                r=1;
            }
            else if(p2.contains(mp)){
                System.out.println("hi");
                m=1;
                r=2;
            }
            else if(p3.contains(mp)){
                System.out.println("hi");
                m=1;
                r=3;
            }
            else if(back.contains(mp)){
                n=0;
                m=0;
                r=0;
            }
            if(m==1){
                if(play.contains(mp)){
                System.out.println("play");
                this.shoot.loop(1);
                n=3;
            }
            }
        }


        

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Rectangle start = new Rectangle(725, 510, 445, 105);
        Rectangle highscores = new Rectangle(725, 645, 445, 105);
        Point t = e.getPoint();
        if (start.contains(t) || highscores.contains(t)) {
            //options.loop(1);
            System.out.println("Just entered");
            //q=1;

        } else {
            q = 0;
            options.stop();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Rectangle start = new Rectangle(725, 510, 445, 105);
        Rectangle highscores = new Rectangle(725, 645, 445, 105);
        Point t = e.getPoint();
        if (start.contains(t) || highscores.contains(t)) {
            options.stop();
            System.out.println(q);
            q = 1;

        } else {
            q = 0;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
