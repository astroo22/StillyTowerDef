package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class wall implements GameObject {

    private Rect wall;
    // private int damage;
    //private int health;
    //private int speed;
    private int color;
    private boolean alive;// test color
//private Image zombieAnimation1;

    public wall(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.wall = new Rect(left,top,right,bottom);
        //this.damage = 15;
        //this.health = 250;
        //this.speed = 7;
        this.color = color;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(wall,paint);

    }
    /*public int getSpeed()
    {
        return speed;
    }*/

    /*public void gruntMove()
    {
        grunt.top += speed;
        grunt.bottom +=speed;
    }*/

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



