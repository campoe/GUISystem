package com.learncode.graphics.shape.circular;

import com.learncode.graphics.Graphics;

import java.awt.*;

public class FilledCircle extends Circle {

    public FilledCircle(float x, float y, float radius, int rgb) {
        super(x, y, radius, rgb);
    }

    public FilledCircle(float x, float y, float radius, Color color) {
        super(x, y, radius, color);
    }

    public FilledCircle(float x, float y, float radius, boolean hidden, boolean effective, int rgb) {
        super(x, y, radius, hidden, effective, rgb);
    }

    public FilledCircle(float x, float y, float radius, boolean effective, int rgb) {
        super(x, y, radius, effective, rgb);
    }

    public FilledCircle(float x, float y, float radius, boolean hidden, boolean effective, Color color) {
        super(x, y, radius, hidden, effective, color);
    }

    public FilledCircle(float x, float y, float radius, boolean effective, Color color) {
        super(x, y, radius, effective, color);
    }

    @Override
    public void draw(Graphics g) {
        g.fillCircle(x, y, radius, rgb);
    }

}
