package com.learncode.graphics.shape.circular;

import com.learncode.graphics.shape.Shape;

import java.awt.*;

public abstract class Circle extends Shape {

    protected float radius;

    public Circle(float x, float y, float radius, int rgb) {
        super(x, y, rgb);
        this.radius = radius;
    }

    public Circle(float x, float y, float radius, Color color) {
        this(x, y, radius, color.getRGB());
    }

    public Circle(float x, float y, float radius, boolean hidden, boolean effective, int rgb) {
        super(x, y, hidden, effective, rgb);
        this.radius = radius;
    }

    public Circle(float x, float y, float radius, boolean effective, int rgb) {
        super(x, y, effective, rgb);
        this.radius = radius;
    }

    public Circle(float x, float y, float radius, boolean hidden, boolean effective, Color color) {
        this(x, y, radius, hidden, effective, color.getRGB());
    }

    public Circle(float x, float y, float radius, boolean effective, Color color) {
        this(x, y, radius, effective, color.getRGB());
    }

    @Override
    public void scale(float widthFactor, float heightFactor) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) getRadius() * 2, (int) getRadius() * 2);
    }

    public float getRadius() {
        return radius;
    }

}
