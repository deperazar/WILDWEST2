/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;
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

public class Visual extends JFrame {

    public Visual(){
       
        add(new Newpanel());
        
    }
    
    public static void main(String[] args) {
        Visual cuadro= new Visual();
        cuadro.setTitle("WILD WEST");
        cuadro.setSize(2000,1000);
        cuadro.setLocationRelativeTo(null);
        cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadro.setVisible(true);
    }
       
    
}

class Newpanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    
    private Timer time;
    private int o;
    private int y;
    private int i;
    private int secuencia;
    
    
    
    
    public Newpanel(){
        this.i=0;
        this.addMouseListener(this);
        this.time=new Timer(25,this);  
        this.time.start();
        this.o=5;
        this.y=5;
    }
    
    
    protected void drawScenenario(Graphics g){
        
    }
      private void doDrawing(Graphics g) {
        
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
    }

    @Override
    


    

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
   
        
                
        Image fondo= loadImage("FONDO.gif");
        
        Image person= loadImage("man1.gif");
        Image revolvercamera= loadImage("Recamararevolver.gif");
        Image bullet1= loadImage("Bullet_1.gif");
        Image bullet2= loadImage("Bullet_1.gif");
        Image bullet3= loadImage("Bullet_1.gif");
        Image bullet4= loadImage("Bullet_1.gif");
        Image bullet5= loadImage("Bullet_1.gif");
        Image bullet6= loadImage("Bullet_1.gif");
        Image bullet7= loadImage("Bullet_1.gif");
        
        //g2d.drawImage(person, 200, 150, 150, 600, this);
       
        
        g.drawImage(fondo, 0, -500, null);
        g.drawImage(person, 200, 150, 150, 600, this);
        g.drawImage(revolvercamera, 140, 750, 200, 200, this);
        g.drawImage(bullet1, 212, 762, 55, 55, this);
        g.drawImage(bullet2, 160, 792, 55, 55, this);
        g.drawImage(bullet3, 160, 853, 55, 55, this);
        g.drawImage(bullet4, 212, 884, 55, 55, this);
        g.drawImage(bullet5, 265, 853, 55, 55, this);
        g.drawImage(bullet6, 265, 792, 55, 55, this);
        g.drawImage(bullet7, 500+o, 500+y, 55, 55, this);
        
        doDrawing(g);

    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        
        double k= Math.toRadians(i);
        
        
        o=(int) (300*Math.cos(k));
        y=(int) (300*Math.sin(k));
        
        
        i+=1;
        repaint();
        
        System.out.println(k);
      
        
        
    }

    public Image loadImage(String imageName){
            ImageIcon ii= new ImageIcon(imageName);
            Image image =ii.getImage();
            return image;
        }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(o+0,240, 201, 161);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point a= e.getPoint();
        
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

