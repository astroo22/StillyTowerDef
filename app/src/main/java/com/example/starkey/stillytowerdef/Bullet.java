package com.example.starkey.stillytowerdef;
import android.graphics.Rect;
public abstract class Bullet
{


    protected Rect collider;
    protected GameObject target;
    protected boolean active;
    protected float speed, center_x, center_y;
    protected int damage;

    public float getX() {return collider.centerX();}

    public float getY() {return collider.centerY();}

    public boolean isActive() {return active;}

    public abstract void update();


}
