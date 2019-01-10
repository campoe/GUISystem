package com.learncode.graphics.shape.rectangular;

import com.learncode.graphics.Graphics;

import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public class OutlinedRectangle extends Rectangle {

    public OutlinedRectangle(float x, float y, float width, float height, int rgb) {
        super(x, y, width, height, rgb);
    }

    public OutlinedRectangle(float x, float y, float width, float height, Color color) {
        super(x, y, width, height, color);
    }

    public OutlinedRectangle(float x, float y, float width, float height, boolean hidden, boolean effective, int rgb) {
        super(x, y, width, height, hidden, effective, rgb);
    }

    public OutlinedRectangle(float x, float y, float width, float height, boolean effective, int rgb) {
        super(x, y, width, height, effective, rgb);
    }

    public OutlinedRectangle(float x, float y, float width, float height, boolean hidden, boolean effective, Color color) {
        super(x, y, width, height, hidden, effective, color);
    }

    public OutlinedRectangle(float x, float y, float width, float height, boolean effective, Color color) {
        super(x, y, width, height, effective, color);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRectangle(x, y, width, height, rgb);
    }

}
