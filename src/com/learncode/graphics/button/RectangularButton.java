package com.learncode.graphics.button;

import com.learncode.graphics.shape.Shape;
import com.learncode.graphics.shape.rectangular.Rectangle;

import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public abstract class RectangularButton extends Button {

    public RectangularButton(int hoverRgb, int clickRgb, boolean hidden, boolean effective, Rectangle shape) {
        super(hoverRgb, clickRgb, hidden, effective, shape);
    }

    public RectangularButton(int hoverRgb, int clickRgb, boolean effective, Rectangle shape) {
        super(hoverRgb, clickRgb, effective, shape);
    }

    public RectangularButton(int hoverRgb, int clickRgb, Rectangle shape) {
        super(hoverRgb, clickRgb, shape);
    }

    public RectangularButton(Color hoverColor, Color clickColor, boolean hidden, boolean effective, Rectangle shape) {
        super(hoverColor, clickColor, hidden, effective, shape);
    }

    public RectangularButton(Color hoverColor, Color clickColor, boolean effective, Rectangle shape) {
        super(hoverColor, clickColor, effective, shape);
    }

    public RectangularButton(Color hoverColor, Color clickColor, Rectangle shape) {
        super(hoverColor, clickColor, shape);
    }

    public RectangularButton(boolean hidden, boolean effective, Rectangle shape) {
        super(hidden, effective, shape);
    }

    public RectangularButton(boolean effective, Rectangle shape) {
        super(effective, shape);
    }

    public RectangularButton(Rectangle shape) {
        super(shape);
    }

}
