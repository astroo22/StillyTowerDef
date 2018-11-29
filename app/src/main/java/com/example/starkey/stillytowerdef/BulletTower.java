package com.example.starkey.stillytowerdef;

import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

import java.util.ArrayList;

public class BulletTower extends Tower {

    private Canvas texture;
    private int orientation;

    public BulletTower()
    {
        name = "BulletTower";
        width = 40;
        height = 40;
        range = 200;
        cost = 500;
        firing_speed = 1.75f;
        upgradecost = 0;
    }

    public BulletTower(ArrayList<Zombie> enemies, int x, int y )//, AssetManager manager)
    {
        super(enemies);//, manager);

        orientation = 0;
        name = "BulletTower";
        width = 40;
        height = 40;
        range = 200;
        cost = 500;
        firing_speed = 1.75f;
        upgradecost = 0;

        damagemultiplier = 1;
        level = 1;
        time_since_last_shot = 0;
        center_x = x + width/2;
        center_y = y + height/2;
        collider = new Rect(x, y, width, height);
    }


    public void update()
    {

    }
    public boolean levelUp()
    {
        orientation++;
        if(orientation > 3)
            orientation = 0;
        return true;
    }
}
