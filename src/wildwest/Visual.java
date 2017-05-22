/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;


import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.*;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.io.File;
import java.util.Random; 

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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

    
    private Character player1;
    private Character player2;
    
    private int m;//activar el boton start
    private int r;//resalto en el roast y seleccion de personaje
    private int n;//Cambio de pantalla
    private int u;//Activación sonido
    private int q;//TIEMPO GIRAR BRAZO ENEMY
    private int z;//Variable aleatoria para seleccion de personaje
    private int x;//posición en x del disparo
    private int y;//posición en y del disparo
    private int count;//contador de recamara
    private double theta;//angulo de brazo jugador 1
    private double alpha;//angulo de brazo jugador 1
    
    private int o1;//velocidad disparo
    private int o2;
    private int o3;
    private int o4;
    private int o5;
    private int o6;
    private int k;//contador de disparo
    
    private int xd1;//COORDENADAS DISPARO COLISIÓN
    private int yd1;
    private int xd2;//COORDENADAS DISPARO COLISIÓN
    private int yd2;
    private int xd3;//COORDENADAS DISPARO COLISIÓN
    private int yd3;
    private int xd4;//COORDENADAS DISPARO COLISIÓN
    private int yd4;
    private int xd5;//COORDENADAS DISPARO COLISIÓN
    private int yd5;
    private int xd6;//COORDENADAS DISPARO COLISIÓN
    private int yd6;
 
    
    
    
    private Clip soundintro;//musica del intro
    private Clip options;
    private Clip shoot;//sonido de disparo
    
   

    public Newpanel() {
        
        this.addMouseListener(this);
        this.time = new Timer(25, this);
        this.time.start();
        this.x = 0;
        this.theta=0;
        this.m = 0;
        this.z = 0;
        this.y = 0;
        this.r = 0;
        this.u = 1;
        this.count = 0;
        this.q = 0;
        this.n = 0;
        
        this.o1 = 0;
        this.o2 = 0;
        this.o3 = 0;
        this.o4 = 0;
        this.o5 = 0;
        this.o6 = 0;
        this.k = 0;
        
        this.xd1=0;
        this.yd1=0;
        this.xd2=0;
        this.yd2=0;
        this.xd3=0;
        this.yd3=0;
        this.xd4=0;
        this.yd4=0;
        this.xd5=0;
        this.yd5=0;
        this.xd6=0;
        this.yd6=0;
        
       
      
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
        Image roast = loadImage("Roast.png");
        Image highlight = loadImage("highlights.gif");
        Image buttons = loadImage("Botones.gif");
        Image life = loadImage("life.png");
        
        
        Image background = loadImage("FONDO.gif");
        Image c1= loadImage("man1.gif");
        Image c2= loadImage("sprite2.png");
        Image c3= loadImage("sprite3.png");
        Image c4= loadImage("man1.gif");
        Image c5= loadImage("man1.gif");
        Image c6= loadImage("man1.gif");
        
        Image revolvercamera= loadImage("Recamararevolver.gif");
        Image revolvercamera2= loadImage("Recamararevolver.gif");
        Image bullet1 = loadImage("Bullet_1.gif");
        Image bullet2 = loadImage("Bullet_1.gif");
        Image bullet3 = loadImage("Bullet_1.gif");
        Image bullet4 = loadImage("Bullet_1.gif");
        Image bullet5 = loadImage("Bullet_1.gif");
        Image bullet6 = loadImage("Bullet_1.gif");
        Image bullet7 = loadImage("Bullet_1.gif");
        Image bullet8 = loadImage("Bullet_1.gif");
        Image bullet9 = loadImage("Bullet_1.gif");
        Image bullet10 = loadImage("Bullet_1.gif");
        Image bullet11 = loadImage("Bullet_1.gif");
        Image bullet12 = loadImage("Bullet_1.gif");
        
        Image message= loadImage("message.png");
        Image counter= loadImage("count.png");
        

      
        if (n == 0) {//Pantalla de inicio
            g.drawImage(menu, -180, 0, null);
            if (u == 1 || u == 2) {
                g.drawImage(botonsonido, 950, 770, 1130, 870, 0, 0, 1302, 740, null);
            } else if (u == 0) {
                g.drawImage(botonsonido, 950, 770, 1130, 870, 0, 740, 1302, 1497, null);
            }
            g.drawRect(725, 510, 445, 105);
            g.drawRect(725, 645, 445, 105);
            
        } else if (n == 1) {//Se entró a la pantalla de personajes
            g.drawImage(roast, 0, 0, 2000, 1000, this);
            g.drawRect(130, 345, 290, 410);
            g.drawRect(420, 345, 290, 410);
            g.drawRect(710, 345, 290, 410);
            
            g.drawImage(buttons, 50, 800, 350, 900, 0, 731, 1229, 1092, this);
            if(m==1){
                g.drawImage(buttons, 1500, 800, 1800, 900, 8, 1110, 1229, 1463, this);
            }
            switch (r) {//RESALTO EN LOS PERSONAJES
                case 1:
                    g.drawImage(highlight, 85, 300, 370, 500, this);
                    break;
            
                case 2:
                    g.drawImage(highlight, 380, 300, 370, 500, this);
                    break;
                case 3:
                    g.drawImage(highlight, 660, 300, 370, 500, this);
                    break;
                default:
                    break;
            }

        }
        
        if(n==3){//SE HA EMPEZADO UNA PARTIDA
            
            g.drawImage(background, 0, -500, this);
            switch (r) {
                case 1:
                    //ESCOGIÓ 1ER PERSONAJE
                    g.drawImage(c1, 100, 200, 120, 500, this);
                    
                    g.drawImage(life, 50, 50,450,50, this);
                    g.drawImage(revolvercamera, 80, 750, 200, 200, this);
                    
                    if(k<7){
                        g.drawImage(bullet1, 152, 762, 55, 55, this);
                        
                        if(k<6){
                            g.drawImage(bullet2, 100, 792, 55, 55, this);
                            if(k<5){
                                g.drawImage(bullet3, 100, 853, 55, 55, this);
                                if(k<4){
                                    g.drawImage(bullet4, 152, 884, 55, 55, this);
                                    if(k<3){
                                       g.drawImage(bullet5, 205, 853, 55, 55, this);
                                       if(k<2){
                                           g.drawImage(bullet6, 205, 792, 55, 55, this);
                                        }
                                    }
                                }
                            }
                        }     
                        }
                    
                        
                    switch(z){//SE ESCOGE AL ENEMIGO
                        case 0:
                            g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
                            g.drawImage(life, 1350, 50,1800 , 100,1963,0,0,214,this);
                            g.drawImage(revolvercamera, 1580, 750, 200, 200, this);
                            g.drawImage(bullet1, 1652, 762, 55, 55, this);
                            g.drawImage(bullet2, 1600, 792, 55, 55, this);
                            g.drawImage(bullet3, 1600, 853, 55, 55, this);
                            g.drawImage(bullet4, 1652, 884, 55, 55, this);
                            g.drawImage(bullet5, 1705, 853, 55, 55, this);
                            g.drawImage(bullet6, 1705, 792, 55, 55, this);
                            draw(g);
                            break;
                        case 1:
                            g.drawImage(c3, 1600, 200, 1720, 700, 478, 0, 0, 2198, this);
                            g.drawImage(life, 1350, 50,1800 , 100,1963,0,0,214,this);
                            g.drawImage(revolvercamera, 1580, 750, 200, 200, this);
                            g.drawImage(bullet1, 1652, 762, 55, 55, this);
                            g.drawImage(bullet2, 1600, 792, 55, 55, this);
                            g.drawImage(bullet3, 1600, 853, 55, 55, this);
                            g.drawImage(bullet4, 1652, 884, 55, 55, this);
                            g.drawImage(bullet5, 1705, 853, 55, 55, this);
                            g.drawImage(bullet6, 1705, 792, 55, 55, this);
                           
                            break;  
                        
                    }
                    g.drawRect(xd1, yd1, 5, 5);
                    g.drawRect(xd2, yd2, 5, 5);
                    g.drawRect(xd3, yd3, 5, 5);
                    g.drawRect(xd4, yd4, 5, 5);
                    g.drawRect(xd5, yd5, 5, 5);
                    g.drawRect(xd6, yd6, 5, 5);
                    break;
                    
                case 2:
                    //ESCOGIÓ 2do PERSONAJE
                    g.drawImage(c2, 100, 250, 160, 450, this);
                    g.drawImage(life, 50, 50,450,50, this);
                    g.drawImage(revolvercamera, 80, 750, 200, 200, this);
                    g.drawImage(bullet1, 152, 762, 55, 55, this);
                    g.drawImage(bullet2, 100, 792, 55, 55, this);
                    g.drawImage(bullet3, 100, 853, 55, 55, this);
                    g.drawImage(bullet4, 152, 884, 55, 55, this);
                    g.drawImage(bullet5, 205, 853, 55, 55, this);
                    g.drawImage(bullet6, 205, 792, 55, 55, this);
                    
                    g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
                    g.drawImage(life, 1350, 50,1800 , 100,1963,0,0,214,this);
                    g.drawImage(revolvercamera, 1580, 750, 200, 200, this);
                    g.drawImage(bullet1, 1652, 762, 55, 55, this);
                    g.drawImage(bullet2, 1600, 792, 55, 55, this);
                    g.drawImage(bullet3, 1600, 853, 55, 55, this);
                    g.drawImage(bullet4, 1652, 884, 55, 55, this);
                    g.drawImage(bullet5, 1705, 853, 55, 55, this);
                    g.drawImage(bullet6, 1705, 792, 55, 55, this);
                    break;
                case 3:
                    //ESCOGIÓ 3er PERSONAJE
                    g.drawImage(c3, 200, 200, 120, 500, this);
                    g.drawImage(life, 50, 50,450,50, this);
                    g.drawImage(revolvercamera, 80, 750, 200, 200, this);
                    g.drawImage(bullet1, 152, 762, 55, 55, this);
                    g.drawImage(bullet2, 100, 792, 55, 55, this);
                    g.drawImage(bullet3, 100, 853, 55, 55, this);
                    g.drawImage(bullet4, 152, 884, 55, 55, this);
                    g.drawImage(bullet5, 205, 853, 55, 55, this);
                    g.drawImage(bullet6, 205, 792, 55, 55, this);
                    
                    g.drawImage(c2, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
                    g.drawImage(life, 1350, 50,1800 , 100,1963,0,0,214,this);
                    g.drawImage(revolvercamera, 1580, 750, 200, 200, this);
                    g.drawImage(bullet1, 1652, 762, 55, 55, this);
                    g.drawImage(bullet2, 1600, 792, 55, 55, this);
                    g.drawImage(bullet3, 1600, 853, 55, 55, this);
                    g.drawImage(bullet4, 1652, 884, 55, 55, this);
                    g.drawImage(bullet5, 1705, 853, 55, 55, this);
                    g.drawImage(bullet6, 1705, 792, 55, 55, this);
                    break;
                    
            }
            
            
            if(count==0){
                g.drawImage(message, 550, 800, 800, 100, this);
            }
            
            switch(count){//APARECE SECUENCIA DE NÚMEROS
                case 1:
                    g.drawImage(counter, 870, 100, 1070, 350, 0, 0, 402, 665,  this);
                    break;
                case 2:
                    g.drawImage(counter, 870, 100, 1070, 350, 0, 665, 402, 1330,  this);
                    break;
                case 3:
                    g.drawImage(counter, 870, 100, 1070, 350, 0, 1330, 402, 1995,  this);
                    break;
            }
            
            if(count>3){
                
            }
            
            doDrawing(g);
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

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        switch (r){
            case 1:
                double a=x-139;
                double b=y-349;
                if(b<=0){
                    b=349-y;
                    theta= Math.PI/2+Math.atan(b/a);
                }else{
                    theta= Math.atan(a/b);
                }

                Image arm1= loadImage("arm1.png");
                g2d.rotate(-theta,139, 349);
                g2d.drawImage(arm1, 80, 325,80,220, this);
                if(k>1){
                    g2d.fillRect(139,600+110*o1,5,5);
                  
                    this.xd1=(int)(139+101*o1*Math.sin(theta));
                    this.yd1=(int)(349+101*o1*Math.cos(theta));
                    
                    if(k>2){
                        g2d.fillRect(139,600+110*o2,5,5);
                        this.xd2=(int)(139+101*o2*Math.sin(theta));
                        this.yd2=(int)(349+101*o2*Math.cos(theta));
                    }
                    if(k>3){
                        g2d.fillRect(139,600+110*o3,5,5);
                        this.xd3=(int)(139+101*o3*Math.sin(theta));
                        this.yd3=(int)(349+101*o3*Math.cos(theta));
                    }
                    if(k>4){
                        g2d.fillRect(139,600+110*o4,5,5);
                        this.xd4=(int)(139+101*o4*Math.sin(theta));
                        this.yd4=(int)(349+101*o4*Math.cos(theta));
                    }
                    if(k>5){
                        g2d.fillRect(139,600+110*o5,5,5);
                        this.xd5=(int)(139+101*o5*Math.sin(theta));
                        this.yd5=(int)(349+101*o5*Math.cos(theta));
                    }
                    if(k>6){
                        
                        g2d.fillRect(139,600+110*o6,5,5);
                        this.xd6=(int)(139+101*o6*Math.sin(theta));
                        this.yd6=(int)(349+101*o6*Math.cos(theta));
                       
                    }
                    //System.out.println("angulo: "+tetha);
                }
                
                
                
                break;
            case 2:
                a=x-173;
                b=y-372;
                if(b<=0){
                    b=372-y;
                    theta= Math.PI/2+Math.atan(b/a);
                }else{
                    theta= Math.atan(a/b);
                }

                Image arm2= loadImage("arm2.png");
                g2d.rotate(-theta,173, 372);
                g2d.drawImage(arm2, 115, 355,70,200, this);
                break;
            case 3:
                a=x-253;
                b=y-347;
                if(b<=0){
                    b=347-y;
                    theta= Math.PI/2+Math.atan(b/a);
                }else{
                    theta= Math.atan(a/b);
                }

                Image arm3= loadImage("arm3.png");
                g2d.rotate(-theta,253, 347);
                g2d.drawImage(arm3, 206, 328,70,200, this);
                break;    
                
        }
        
        
        
        
        
    }
    
    public void draw(Graphics g){
            Graphics2D g2d = (Graphics2D) g.create();

            Image arme= loadImage("arm2.png");
            
            //g.drawImage(arme, 1590, 360, 1750, 760, 789, 0, 0, 2234,this);
            
            double a=0;
            double b=0;
            
            Random w=new Random();
            a=1+(int)(w.nextDouble()*1000); 
            Random v=new Random();
            b=1+(int)(v.nextDouble()*1000);
            
            
            g2d.rotate(alpha,1689,375);
            if(b<564&& b<a&&q%20==0){
                this.alpha=Math.PI/2+Math.atan(b/a);
                
            }
            else if(b>564&&b<a&&q%20==0){
                this.alpha=Math.PI/4+Math.atan(b/a);
                
            }
            
            g2d.drawImage(arme, 1590, 360, 1750, 760, 789, 0, 0, 2234, this);
            g2d.fillRect(1690,564+o1*100,50,50);
            
            if(k>1){
               
                g2d.fillRect(1690,564+o2*100,50,50);
            }
            if(k>2){
                g2d.fillRect(1690,564+o3*100,50,50);
            }
            if(k>3){
                g2d.fillRect(1690,564+o4*100,50,50);
            }
            if(k>4){
                g2d.fillRect(1690,564+o5*100,50,50);
            }
            if(k>5){
                g2d.fillRect(1690,564+o6*100,50,50);
            }

        }
    
    
    
    public void addcharacter(int b1,int b2){
        this.player1=new Character(100,b1);
        this.player2=new Character(100,b2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        q+=1;
        if(k>1){//DISPARO DE BALAS
                o1+=1;
                if(k>2){
                    o2+=1;
                    if(k>3){
                        o3+=1;
                        if(k>4){
                            o4+=1;
                            if(k>5){
                                o5+=1;
                                if(k>6){
                                    o6+=1;
                                    //System.out.println(o6);
                                }
                            }
                        }
                    }

                }
            }

        if (u == 0) {
            this.soundintro.stop();
 
        } else if (u == 2) {
            this.soundintro.start();
        }
        

        repaint();

      }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(n==0){//PANTALLA INICIO
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
            if (start.contains(mp)) {//START
                this.shoot.loop(1);
                Random w=new Random();
                z=(int)(w.nextDouble()*2);
                System.out.println(this.z);
                n = 1;
            } else if (highscores.contains(mp)) {
               
                this.shoot.start();
            }
            
        }

        else if(n==1){//PANTALLA PERSONAJES
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
        else if(n==3){//PANTALLA DE PARTIDA
            this.x=e.getX();
            this.y=e.getY();
            
            Rectangle center=new Rectangle (154, 825, 50, 50);
            if(center.contains(mp)){
                count+=1;
            }
            if(count>3){
                
                k+=1;
                if(k>1&&k<8){
                    shoot.loop(1);
                }
                
                
            }
            
            
            System.out.println("x: "+x+" y: "+y);

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

       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
