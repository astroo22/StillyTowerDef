package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class wall implements GameObject {

    public Rect wall;
    private int color;
    public boolean alive;
    public int top;
    public int left;
    public int right;
    public int bottom;
    public int ID;
    public int health;


    public wall(int color, int left, int top, int right, int bottom,int id)
    {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.wall = new Rect(left,top,right,bottom);
        this.color = color;
        this.ID = id;
        this.alive = true;
        this.health = 300;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(wall,paint);

    }
    public int getTop()
    {
        return top;
    }
    public void hit(int hitValue)
    {
        this.health = this.health - hitValue;
    }
    @Override
    public void update()
    {

    }
    public void update(Point point)
    {

    }

}



