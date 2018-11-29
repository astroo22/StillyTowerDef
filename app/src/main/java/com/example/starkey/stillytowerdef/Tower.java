package com.example.starkey.stillytowerdef;


import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

import java.util.ArrayList;

import static com.example.starkey.stillytowerdef.MainThread.canvas;


public class Tower implements GameObject
{

    protected int width, height, cost;
    protected float range, firing_speed, center_x, center_y, time_since_last_shot;
    protected Rect collider;
    protected ArrayList<Zombie> enemies;
    protected ArrayList<Bullet> bullets;
    protected GameObject target;
    protected String name;
    protected int damagemultiplier;
    protected int level, max_level, upgradecost, current_tex;
    //protected AssetManager manager;
    protected Canvas[] texture;
    protected boolean right;
    private int color;
    public boolean alive;
    int health = 2000;
    SpawnManager sm;

    public Tower()
    {
        // get stats
    }

    public Tower(ArrayList<Zombie> enemies)//, AssetManager manager)
    {
        this.enemies = enemies;
        bullets = new ArrayList<Bullet>();
        target = null;
        //this.manager = manager;
        time_since_last_shot = 0;
        current_tex = 0;
        damagemultiplier = 1;
        level = 1;
        this.color = Color.RED;
        this.alive = true;
    }

    public int getLevel() {return level;}

    public int getUpgradeCost() {return upgradecost;}

    public float getX() {return collider.centerX();}

    public float getY() {return collider.centerY();}

    public float getRange() {return range;}

    public int getCost() {return cost;}

    public int getSellCost() {return (cost + upgradecost * (level - 1)) * 2 / 3;}

    public String getName() {return name;}

    public boolean face_left()
    {// returns true if target is to the left of Tower or target is null
        // otherwise, returns false
        if (target == null || collider.centerX() <= center_x)
            return true;
        else
            return false;
    }

    public boolean levelUp()
    {
        if (level < max_level)
        {
            level++;
            damagemultiplier++;
            current_tex++;
            firing_speed = firing_speed*0.75f;
            range = range*1.25f;
            return true;
        }
        return false;
    }

    public void update(){


    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(collider,paint);

    }
    public void towerMove() {
        if (alive)
        {
            if(health<=0)
            {
                this.alive = false;
                System.out.println("Attempting removal of wall");
                sm.towers.remove(this);
                draw(canvas);
            }

        }
    }

}