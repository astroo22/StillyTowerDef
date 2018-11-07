package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;

public class Zombie implements GameObject
{
   private Rect zombie;
   private int currentPos;
   private WayPoint wp;
   private int damage;
   private int health;
   private int speed;
   private int color;
   private boolean alive;
   SpawnManager sm;
   private boolean allowed2Move;

    public Zombie(int color, int left, int top, int right, int bottom)
    {
        //rect = left top right bottom
        this.currentPos = (right -50);
        this.zombie = new Rect(left,top,right,bottom);
        this.damage = 15;
        this.health = 500;
        this.speed = 5;
        this.color = color;
        this.allowed2Move = true;
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
       // allow();
        if (allowed2Move == true)
        {
            walk();
        }
       /* else
        {
            wall temp = wp.getWall();
            temp.hit(damage);
        }*/
    }
    public void allow()
    {
        if(currentPos >= (wp.getWayPointY()-50))
        {
            allowed2Move = false;
        }
        else
        {
            allowed2Move = true;
            System.out.println(" I AM ALLOWED TO MOVE NOW ");
        }
    }
    public void setWayPointTarget(WayPoint wp)
    {
        this.wp = wp;
    }
    public void walk()
    {
        if(currentPos<wp.getWayPointX())
        {
            walkRight();
        }
        if(currentPos>wp.getWayPointX())
        {
            walkLeft();
        }
        else {

           zombie.top += speed;
           zombie.bottom += speed;
       }
    }
    public void stop()
    {

    }
    public void walkRight()
    {
        zombie.left += speed - (speed/2);
        zombie.right += speed- (speed/2);
        currentPos += speed -(speed/2);
        zombie.top += speed;
        zombie.bottom +=speed;
    }
    public void walkLeft()
    {
        zombie.left -= speed - (speed/2);
        zombie.right -= speed - (speed/2);
        currentPos -= speed -(speed/2);
        zombie.top += speed;
        zombie.bottom +=speed;
    }


    public void attack(wall thing)
    {
        thing.hit(damage);
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
