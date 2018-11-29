package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class BasicBullet extends Bullet
{
    private final int WIDTH = 8, HEIGHT = 8;
    private Canvas[] texture;


    public BasicBullet(GameObject target, int center_x, int center_y, int damagemultiplier)
    {
        this.center_x = center_x;
        this.center_y = center_y;
        collider = new Rect(center_x, center_y, WIDTH, HEIGHT);
        this.target = target;
        active = true;

        damage = 50*damagemultiplier;
        speed = 10;

    }

    public void update()
    {

    }

}