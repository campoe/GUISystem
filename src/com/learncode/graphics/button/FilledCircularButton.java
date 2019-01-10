package com.learncode.graphics.button;

import com.learncode.graphics.shape.circular.FilledCircle;

import java.awt.*;

public class FilledCircularButton extends CircularButton {

    public FilledCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb) {
        super(hoverRgb, clickRgb, new FilledCircle(x, y, radius, rgb));
    }

    public FilledCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor) {
        super(hoverColor, clickColor, new FilledCircle(x, y, radius, color));
    }

    public FilledCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb, boolean hidden, boolean effective) {
        super(hoverRgb, clickRgb, hidden, effective, new FilledCircle(x, y, radius, hidden, effective, rgb));
    }

    public FilledCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor, boolean hidden, boolean effective) {
        super(hoverColor, clickColor, hidden, effective, new FilledCircle(x, y, radius, hidden, effective, color));
    }

    public FilledCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb, boolean effective) {
        super(hoverRgb, clickRgb, effective, new FilledCircle(x, y, radius, effective, rgb));
    }

    public FilledCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor, boolean effective) {
        super(hoverColor, clickColor, effective, new FilledCircle(x, y, radius, effective, color));
    }

    public FilledCircularButton(float x, float y, float radius, boolean hidden, boolean effective) {
        super(hidden, effective, new FilledCircle(x, y, radius, hidden, effective, DEFAULT_RGB));
    }

    public FilledCircularButton(float x, float y, float radius, boolean effective) {
        super(effective, new FilledCircle(x, y, radius, effective, DEFAULT_RGB));
    }

    public FilledCircularButton(float x, float y, float radius) {
        super(new FilledCircle(x, y, radius, DEFAULT_RGB));
    }

}
