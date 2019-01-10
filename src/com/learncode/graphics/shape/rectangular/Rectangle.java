package com.learncode.graphics.shape.rectangular;

import com.learncode.graphics.shape.Shape;

import java.awt.*;

public abstract class Rectangle extends Shape {

    protected float width, height;

    public Rectangle(float x, float y, float width, float height, int rgb) {
        super(x, y, rgb);
        this.width = width;
        this.height = height;
    }

    public Rectangle(float x, float y, float width, float height, Color color) {
        this(x, y, width, height, color.getRGB());
    }

    public Rectangle(float x, float y, float width, float height, boolean hidden, boolean effective, int rgb) {
        super(x, y, hidden, effective, rgb);
        this.width = width;
        this.height = height;
    }

    public Rectangle(float x, float y, float width, float height, boolean effective, int rgb) {
        super(x, y, effective, rgb);
        this.width = width;
        this.height = height;
    }

    public Rectangle(float x, float y, float width, float height, boolean hidden, boolean effective, Color color) {
        this(x, y, width, height, hidden, effective, color.getRGB());
    }

    public Rectangle(float x, float y, float width, float height, boolean effective, Color color) {
        this(x, y, width, height, effective, color.getRGB());
    }

    @Override
    public void scale(float widthFactor, float heightFactor) {
        width *= widthFactor;
        height *= heightFactor;
    }

    @Override
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle((int) x, (int) y, (int) width, (int) height);
    }

}
