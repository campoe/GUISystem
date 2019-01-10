package com.learncode.graphics.drawable;

import com.learncode.main.Main;
import com.learncode.graphics.Graphics;

import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public abstract class Drawable {

    protected boolean hidden;
    protected float x, y;
    protected boolean effective;

    public Drawable(float x, float y, boolean hidden, boolean effective) {
        this.x = x;
        this.y = y;
        if (effective) {
            this.x += Main.WIDTH - Main.EFFECTIVE_WIDTH;
            this.y += Main.HEIGHT - Main.EFFECTIVE_HEIGHT;
        }
        this.hidden = hidden;
        this.effective = effective;
    }

    public Drawable(float x, float y, boolean effective) {
        this(x, y, false, effective);
    }

    public Drawable(float x, float y) {
        this(x, y, false, true);
    }

    public abstract void draw(Graphics g);

    public Point getLocation() {
        return new Point((int) x, (int) y);
    }

    public boolean isEffective() {
        return effective;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void hide() {
        hidden = true;
    }

    public void show() {
        hidden = true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
