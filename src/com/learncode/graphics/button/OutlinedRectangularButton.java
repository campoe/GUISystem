package com.learncode.graphics.button;

import com.learncode.graphics.Graphics;
import com.learncode.graphics.shape.rectangular.OutlinedRectangle;

import java.awt.*;

public class OutlinedRectangularButton extends RectangularButton {

    public OutlinedRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb) {
        super(hoverRgb, clickRgb, new OutlinedRectangle(x, y, width, height, rgb));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor) {
        super(hoverColor, clickColor, new OutlinedRectangle(x, y, width, height, color));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb, boolean hidden, boolean effective) {
        super(hoverRgb, clickRgb, hidden, effective, new OutlinedRectangle(x, y, width, height, hidden, effective, rgb));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor, boolean hidden, boolean effective) {
        super(hoverColor, clickColor, hidden, effective, new OutlinedRectangle(x, y, width, height, hidden, effective, color));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb, boolean effective) {
        super(hoverRgb, clickRgb, effective, new OutlinedRectangle(x, y, width, height, effective, rgb));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor, boolean effective) {
        super(hoverColor, clickColor, effective, new OutlinedRectangle(x, y, width, height, effective, color));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, boolean hidden, boolean effective) {
        super(hidden, effective, new OutlinedRectangle(x, y, width, height, hidden, effective, DEFAULT_RGB));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height, boolean effective) {
        super(effective, new OutlinedRectangle(x, y, width, height, effective, DEFAULT_RGB));
    }

    public OutlinedRectangularButton(float x, float y, float width, float height) {
        super(new OutlinedRectangle(x, y, width, height, DEFAULT_RGB));
    }

}
