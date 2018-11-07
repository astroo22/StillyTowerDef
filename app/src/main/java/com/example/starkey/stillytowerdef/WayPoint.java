package com.example.starkey.stillytowerdef;

import android.graphics.Canvas;

public class WayPoint implements  GameObject {
    public int x;
    public int y;
    wall w;
    public WayPoint(int x, int y, wall w)
    {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    public WayPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getWayPointX()
    {
        return x;
    }
    public int getWayPointY()
    {
        return y;
    }

    @Override
    public void draw(Canvas canvas) {

    }
    public wall getWall()
    {
        return w;
    }

    @Override
    public void update()
    {

    }
}
