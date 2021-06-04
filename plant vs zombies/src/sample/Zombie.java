package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie extends Actor {
    private long lastattack;
    private int row;
    private int limit;
    private final int damage;
    private int health;
     int attack_waiting_time;
     ImageView zombie_image = new ImageView();
    
    public Zombie( int y, int damage, int health, long lastattack, int row) {
        super(800, y, -1);
        try {
            zombie_image.setImage(new Image(new FileInputStream("src/sample/img/conehead_zombie_moving.gif")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.damage = damage;
        this.health = health;
        this.lastattack = 0;
        this.row=row;
        limit=150;
        attack_waiting_time=2;
    }

    @Override
    public void act() {
        if(x>limit){
            setX(speed);
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
    public void decreaseHealth(int val) {
        health -=val;
        if(health<=0){
            dead=true;
        }

    }

    public long getLastattack() {
        return lastattack;
    }
    public void setLastattack(long lastattack) {
        this.lastattack = lastattack;
    }

   

    public int getRow(){ return row; }
}