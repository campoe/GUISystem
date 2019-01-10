package com.learncode.graphics.shape.circular;

import com.learncode.graphics.Graphics;

import java.awt.*;

public class OutlinedCircle extends Circle {

    public OutlinedCircle(float x, float y, float radius, int rgb) {
        super(x, y, radius, rgb);
    }

    public OutlinedCircle(float x, float y, float radius, Color color) {
        super(x, y, radius, color);
    }

    public OutlinedCircle(float x, float y, float radius, boolean hidden, boolean effective, int rgb) {
        super(x, y, radius, hidden, effective, rgb);
    }

    public OutlinedCircle(float x, float y, float radius, boolean effective, int rgb) {
        super(x, y, radius, effective, rgb);
    }

    public OutlinedCircle(float x, float y, float radius, boolean hidden, boolean effective, Color color) {
        super(x, y, radius, hidden, effective, color);
    }

    public OutlinedCircle(float x, float y, float radius, boolean effective, Color color) {
        super(x, y, radius, effective, color);
    }

    @Override
    public void draw(Graphics g) {
        g.drawCircle(x, y, radius, rgb);
    }

}
