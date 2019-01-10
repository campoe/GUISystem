package com.learncode.graphics.shape;

import com.learncode.graphics.drawable.Drawable;

import java.awt.*;

public abstract class Shape extends Drawable {

    protected int rgb;

    public Shape(float x, float y, int rgb) {
        super(x, y);
        this.rgb = rgb;
    }

    public Shape(float x, float y, Color color) {
        this(x, y, color.getRGB());
    }

    public Shape(float x, float y, boolean hidden, boolean effective, int rgb) {
        super(x, y, hidden, effective);
        this.rgb = rgb;
    }

    public Shape(float x, float y, boolean effective, int rgb) {
        super(x, y, effective);
        this.rgb = rgb;
    }

    public Shape(float x, float y, boolean hidden, boolean effective, Color color) {
        this(x, y, hidden, effective, color.getRGB());
    }

    public Shape(float x, float y, boolean effective, Color color) {
        this(x, y, effective, color.getRGB());
    }

    public void scale(float factor) {
        scale(factor, factor);
    }

    public abstract void scale(float widthFactor, float heightFactor);

    public abstract Rectangle getBounds();

    public int getRGB() {
        return rgb;
    }

    public void setRGB(int rgb) {
        this.rgb = rgb;
    }

    public boolean inside(int x, int y) {
        return getBounds().contains(x, y);
    }

    public boolean inside(Point p) {
        return inside(p.x, p.y);
    }

}
