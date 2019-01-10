package com.learncode.graphics.button;

import com.learncode.graphics.shape.circular.OutlinedCircle;

import java.awt.*;

public class OutlinedCircularButton extends CircularButton {

    public OutlinedCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb) {
        super(hoverRgb, clickRgb, new OutlinedCircle(x, y, radius, rgb));
    }

    public OutlinedCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor) {
        super(hoverColor, clickColor, new OutlinedCircle(x, y, radius, color));
    }

    public OutlinedCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb, boolean hidden, boolean effective) {
        super(hoverRgb, clickRgb, hidden, effective, new OutlinedCircle(x, y, radius, hidden, effective, rgb));
    }

    public OutlinedCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor, boolean hidden, boolean effective) {
        super(hoverColor, clickColor, hidden, effective, new OutlinedCircle(x, y, radius, hidden, effective, color));
    }

    public OutlinedCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb, boolean effective) {
        super(hoverRgb, clickRgb, effective, new OutlinedCircle(x, y, radius, effective, rgb));
    }

    public OutlinedCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor, boolean effective) {
        super(hoverColor, clickColor, effective, new OutlinedCircle(x, y, radius, effective, color));
    }

    public OutlinedCircularButton(float x, float y, float radius, boolean hidden, boolean effective) {
        super(hidden, effective, new OutlinedCircle(x, y, radius, hidden, effective, DEFAULT_RGB));
    }

    public OutlinedCircularButton(float x, float y, float radius, boolean effective) {
        super(effective, new OutlinedCircle(x, y, radius, effective, DEFAULT_RGB));
    }

    public OutlinedCircularButton(float x, float y, float radius) {
        super(new OutlinedCircle(x, y, radius, DEFAULT_RGB));
    }

}
