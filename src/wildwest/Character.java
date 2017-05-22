/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildwest;

/**
 *
 * @author PERSONAL
 */
public class Character {
    private int life;
    private int ID;
    private int bullets;
    public Character(int life, int ID){
        this.life=life;
        this.ID=ID;
        this.bullets=6;
        
    }
    
    public void shoot(){
        bullets-=1;
    }
    public int getid(){
        return this.ID;
    }
    public int getlife(){
        return this.life;
    }
    public void hurt(int damage){
        this.life-=damage;
    }
    public int getbullets(){
        return this.bullets;
    }
}
