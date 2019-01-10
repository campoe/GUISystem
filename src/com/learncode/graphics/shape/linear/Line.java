package com.learncode.graphics.shape.linear;

import com.learncode.main.Main;
import com.learncode.graphics.Graphics;
import com.learncode.graphics.shape.Shape;

import java.awt.*;

public class Line extends Shape {

    protected float x2, y2;

    public Line(float x, float y, float x2, float y2, int rgb) {
        super(x, y, rgb);
        this.x2 = x2;
        this.y2 = y2;
        fitEffective();
    }

    public Line(float x, float y, float x2, float y2, Color color) {
        this(x, y, x2, y2, color.getRGB());
    }

    public Line(float x, float y, float x2, float y2, boolean hidden, boolean effective, int rgb) {
        super(x, y, hidden, effective, rgb);
        this.x2 = x2;
        this.y2 = y2;
        fitEffective();
    }

    public Line(float x, float y, float x2, float y2, boolean effective, int rgb) {
        super(x, y, effective, rgb);
        this.x2 = x2;
        this.y2 = y2;
        fitEffective();
    }

    public Line(float x, float y, float x2, float y2, boolean hidden, boolean effective, Color color) {
        this(x, y, x2, y2, hidden, effective, color.getRGB());
    }

    public Line(float x, float y, float x2, float y2, boolean effective, Color color) {
        this(x, y, x2, y2, effective, color.getRGB());
    }

    private void fitEffective() {
        if (this.effective) {
            this.x2 += Main.WIDTH - Main.EFFECTIVE_WIDTH;
            this.y2 += Main.HEIGHT - Main.EFFECTIVE_HEIGHT;
        }
    }

    @Override
    public void scale(float widthFactor, float heightFactor) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) (x2 - x), (int) (y2 - y));
    }

    public float getAngle() {
        float angle = (float) Math.toDegrees(Math.atan2(y2 - y, x2 - x));
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x, y, x2, y2, rgb);
    }

}
