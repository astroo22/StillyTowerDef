package com.example.starkey.stillytowerdef;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class Brute implements GameObject
{

    private Rect brute;
    private int damage;
    private int health;
    private int speed;
    private int color;
    private boolean alive;// test color
    //private Image zombieAnimation1;


    public Brute(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.brute = new Rect(left,top,right,bottom);
        this.damage = 25;
        this.health = 500;
        this.speed = 3;
        this.color = color;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(brute,paint);

    }
    public int getSpeed()
    {
        return speed;
    }

    public void bruteMove()
    {
        brute.top += speed;
        brute.bottom +=speed;
    }

    @Override
    public void update()
    {

    }
    public void update(Point point)
    {
        //helper function for defining box and and moving it around with mouse.
        //left, top, right, bottom
        //zombie.set(point.x - zombie.width()/2, point.y - zombie.height()/2, point.x + zombie.width()/2, point.y + zombie.height()/2);

    }

}

