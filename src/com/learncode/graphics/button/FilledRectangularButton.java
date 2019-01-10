package com.learncode.graphics.button;

import com.learncode.graphics.shape.rectangular.FilledRectangle;

import java.awt.*;

public class FilledRectangularButton extends RectangularButton {

    public FilledRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb) {
        super(hoverRgb, clickRgb, new FilledRectangle(x, y, width, height, rgb));
    }

    public FilledRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor) {
        super(hoverColor, clickColor, new FilledRectangle(x, y, width, height, color));
    }

    public FilledRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb, boolean hidden, boolean effective) {
        super(hoverRgb, clickRgb, hidden, effective, new FilledRectangle(x, y, width, height, hidden, effective, rgb));
    }

    public FilledRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor, boolean hidden, boolean effective) {
        super(hoverColor, clickColor, hidden, effective, new FilledRectangle(x, y, width, height, hidden, effective, color));
    }

    public FilledRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb, boolean effective) {
        super(hoverRgb, clickRgb, effective, new FilledRectangle(x, y, width, height, effective, rgb));
    }

    public FilledRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor, boolean effective) {
        super(hoverColor, clickColor, effective, new FilledRectangle(x, y, width, height, effective, color));
    }

    public FilledRectangularButton(float x, float y, float width, float height, boolean hidden, boolean effective) {
        super(hidden, effective, new FilledRectangle(x, y, width, height, hidden, effective, DEFAULT_RGB));
    }

    public FilledRectangularButton(float x, float y, float width, float height, boolean effective) {
        super(effective, new FilledRectangle(x, y, width, height, effective, DEFAULT_RGB));
    }

    public FilledRectangularButton(float x, float y, float width, float height) {
        super(new FilledRectangle(x, y, width, height, DEFAULT_RGB));
    }

}
