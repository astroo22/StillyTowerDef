package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class Zombie implements GameObject
{
   private Rect zombie;
   private int damage;
   private int health;
   private int speed;
   private int color;
   private boolean alive;// test color
   //private Image zombieAnimation1;


    public Zombie(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.zombie = new Rect(left,top,right,bottom);
        this.damage = 15;
        this.health = 500;
        this.speed = 5;
        this.color = color;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(zombie,paint);

    }
    public int getSpeed()
    {
        return speed;
    }

    public void zombieMove()
    {
        zombie.top += speed;
        zombie.bottom +=speed;
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
