/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.Math;

import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
/**
 *
 * @author PERSONAL
 */
public class Test extends JFrame{
    
    
    public Test(){
        add(new Panel());
       
    }
     public static void main(String[] args) {
        Test cuadro= new Test();
        cuadro.setTitle("TestPaintComponent");
        cuadro.setSize(2000, 1000);
        cuadro.setLocationRelativeTo(null);
        cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadro.setVisible(true);
    }
    
    class Panel extends JPanel implements ActionListener, MouseListener{
        private Timer time;//tiempo
        private int t;//tiempo
        private int o1;//velocidad disparo
        private int o2;
        private int o3;
        private int o4;
        private int o5;
        private int o6;
        private int g1;//tiro 2
        private int g2;
        private int g3;
        private int g4;
        private int g5;
        private int g6;
        private double h;//contador
        private double tetha;//angulo1
        private double alpha;//angulo2
        private int x;//posición en x
        private int y;//posición en y
        private int k;//numero de disparo
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
        private double m0;
        
     
        
        
        private Rectangle j1;//bala1
        private Rectangle b2;//cuerpo2
        private Rectangle r1;//cuerpo2
        
        
        public Panel(){
            
            this.addMouseListener(this);
            this.tetha=0;
            this.alpha=0;
            this.k=0;
            this.o1=0;
            this.o2=0;
            this.o3=0;
            this.o4=0;
            this.o5=0;
            this.o6=0;
            this.g1=0;
            this.g2=0;
            this.g3=0;
            this.g4=0;
            this.g5=0;
            this.g6=0;
            this.h=0;
            this.t=1;
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
            this.m0=0;
            
            this.j1=new Rectangle(10,10,10,10);
            this.b2=new Rectangle(1600, 250, 160, 450);
            this.r1=new Rectangle();
            this.time=new Timer(25,this);  
            this.time.start(); 
            
        }
    
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Image fondo= loadImage("FONDO.gif");
            Image p1= loadImage("man1.gif");
            Image arm= loadImage("arm1.png");
            
            g.drawImage(fondo, 0, -500, this);
            g.drawImage(p1, 100, 200, 120, 500, this);
            //g.drawImage(arm, 80, 325,80,220, this);
            
            //g.drawRect(1600, 250, 160, 450);
            
            g.drawRect(1600,250,160,450);
            g.drawRect(xd1, yd1, 5, 5);
            g.drawRect(xd2, yd2, 5, 5);
            g.drawRect(xd3, yd3, 5, 5);
            g.drawRect(xd4, yd4, 5, 5);
            g.drawRect(xd5, yd5, 5, 5);
            g.drawRect(xd6, yd6, 5, 5);
            
            doDrawing(g);
            draw(g);
        }
        
       

        private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g.create();
        double a=x-139;
        double b=y-349;
        if(b<=0){
            b=349-y;
            tetha= Math.PI/2+Math.atan(b/a);
        }else{
            tetha= Math.atan(a/b);
        }
        
        
        Image arm1= loadImage("arm1.png");
        
        g2d.drawLine(139, 349, 139, 545);
        g2d.rotate(-tetha,139, 349);
        g2d.drawImage(arm1, 80, 325,80,220, this);
        
        if(k>0){
            //g2d.fillRect(/*134*/+(int)(o*Math.cos(-tetha)),+(int)(o*Math.sin(tetha)), 50, 50);
            g2d.fillRect(139,600+110*o1,5,5);
            this.xd1=(int)(139+101*o1*Math.sin(tetha));
            this.yd1=(int)(349+101*o1*Math.cos(tetha));
            
            if(k>1){         
                g2d.fillRect(139,600+110*o2,5,5);//v=110*o2
                //System.out.println("x: "+(139+100*o2*Math.sin(tetha))+" y: "+(349+100*o2*Math.cos(tetha)));
                //System.out.println("THETA: "+tetha*180/Math.PI);
                this.xd2=(int)(139+101*o2*Math.sin(tetha));
                this.yd2=(int)(349+101*o2*Math.cos(tetha));
             
             
            }
            if(k>2){
                g2d.fillRect(139,600+110*o3,5,5);
                this.xd3=(int)(139+101*o3*Math.sin(tetha));
                this.yd3=(int)(349+101*o3*Math.cos(tetha));
            }
            if(k>3){
                g2d.fillRect(139,600+110*o4,5,5);
                this.xd4=(int)(139+101*o4*Math.sin(tetha));
                this.yd4=(int)(349+101*o4*Math.cos(tetha));
            }
            if(k>4){
                g2d.fillRect(139,600+110*o5,5,5);
                this.xd5=(int)(139+101*o5*Math.sin(tetha));
                this.yd5=(int)(349+101*o5*Math.cos(tetha));
            }
            if(k>5){
                g2d.fillRect(139,600+110*o6,5,5);
                this.xd6=(int)(139+101*o6*Math.sin(tetha));
                this.yd6=(int)(349+101*o6*Math.cos(tetha));
            }
        }
    }
         
        @Override
        public void actionPerformed(ActionEvent e) {
            t+=1;  
            if(k>0){
                o1+=1;
                if(k>1){
                    o2+=1;
                    if(k>2){
                        o3+=1;
                        if(k>3){
                            o4+=1;
                            if(k>4){
                                o5+=1;
                                if(k>5){
                                o6+=1;
                                }
                            }
                        }
                    }

                }
            }
            if(m0>0){
                g1+=1;
                if(m0>1){
                    g2+=1;
                    if(m0>2){
                        g3+=1;
                        if(m0>3){
                            g4+=1;
                            if(m0>4){
                                g5+=1;
                                if(m0>5){
                                    g6+=1;
                                }
                            }
                        }
                    }

                }
            }
                
            
            repaint();
            collision();
        }
        public void collision(){
            
            Rectangle a1=new Rectangle (xd1, yd1, 5, 5);
            Rectangle a2=new Rectangle (xd2, yd2, 5, 5);
            Rectangle a3=new Rectangle (xd3, yd3, 5, 5);
            Rectangle a4=new Rectangle (xd4, yd4, 5, 5);
            Rectangle a5=new Rectangle (xd5, yd5, 5, 5);
            Rectangle a6=new Rectangle (xd6, yd6, 5, 5);
            Rectangle b1=new Rectangle (1600,250,160,700);
           
            if(a1.intersects(b1)){  
                System.out.println("si");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.x=e.getX();
            this.y=e.getY();
            System.out.println("X: "+x+" Y: "+y);
            k+=1;

        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //this.x=e.getX();
            //this.y=e.getY();
            
            double a=0;
            //System.out.println("x: "+this.x+" y: "+this.y);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
        public Image loadImage(String imageName){
            ImageIcon ii= new ImageIcon(imageName);
            Image image =ii.getImage();
            return image;
        }
        
        
        public void draw(Graphics g){
            Graphics2D g2d = (Graphics2D) g.create();
            Image enemy= loadImage("woman1.gif");
            Image arme= loadImage("arm2.png");
            g.drawImage(enemy, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
            //g.drawImage(arme, 1590, 360, 1750, 760, 789, 0, 0, 2234,this);
            
            double a=0;
            int b=0;
            

            Random v=new Random();
        
           
            b=(int)(v.nextDouble()*6);
            
           
            double [] b0= {0.2767,0.2567,0.3209,0.1514,0.2002,0.1921};//tan tetha

            g2d.rotate(alpha,1689,375);
            if(t%30==0&&h<6){
                this.alpha=1.3603+Math.atan(b0[b]);
                m0+=0.5;
                h+=0.5;
            }
            
            //System.out.println(h);
            
            /*
            if(b<564&& b<a&&t%20==0){
                this.alpha=Math.PI/2+Math.atan(b0[1]);
                //g2d.rotate(alpha,1689,375);
            }
            else if(b>564&&b<a&&t%20==0){
                this.alpha=Math.PI/4+Math.atan(b0[1]);
                
            }*/
            
            g2d.drawImage(arme, 1590, 360, 1750, 760, 789, 0, 0, 2234, this);
            g2d.fillRect(1690,564+g1*100,50,50);
            g2d.drawRect(50, 50, 100, 500);
            j1= new Rectangle(1690,564+g1*100,50,50);
            
            if(m0>1){
               
                g2d.fillRect(1690,564+g2*100,50,50);
            }
            if(m0>2){
                g2d.fillRect(1690,564+g3*100,50,50);
            }
            if(m0>3){
                g2d.fillRect(1690,564+g4*100,50,50);
            }
            if(m0>4){
                g2d.fillRect(1690,564+g5*100,50,50);
            }
            if(m0>5){
                g2d.fillRect(1690,564+g6*100,50,50);
            }
            System.out.println("m0: "+m0);


            
        }
    }
    
    
  

}
