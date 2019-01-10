package com.learncode.graphics.button;

import com.learncode.graphics.shape.circular.Circle;

import java.awt.*;

public abstract class CircularButton extends Button {

    public CircularButton(int hoverRgb, int clickRgb, boolean hidden, boolean effective, Circle shape) {
        super(hoverRgb, clickRgb, hidden, effective, shape);
    }

    public CircularButton(int hoverRgb, int clickRgb, boolean effective, Circle shape) {
        super(hoverRgb, clickRgb, effective, shape);
    }

    public CircularButton(int hoverRgb, int clickRgb, Circle shape) {
        super(hoverRgb, clickRgb, shape);
    }

    public CircularButton(Color hoverColor, Color clickColor, boolean hidden, boolean effective, Circle shape) {
        super(hoverColor, clickColor, hidden, effective, shape);
    }

    public CircularButton(Color hoverColor, Color clickColor, boolean effective, Circle shape) {
        super(hoverColor, clickColor, effective, shape);
    }

    public CircularButton(Color hoverColor, Color clickColor, Circle shape) {
        super(hoverColor, clickColor, shape);
    }

    public CircularButton(boolean hidden, boolean effective, Circle shape) {
        super(hidden, effective, shape);
    }

    public CircularButton(boolean effective, Circle shape) {
        super(effective, shape);
    }

    public CircularButton(Circle shape) {
        super(shape);
    }

}
