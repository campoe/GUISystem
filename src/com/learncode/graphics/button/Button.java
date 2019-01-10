package com.learncode.graphics.button;

import com.learncode.graphics.Graphics;
import com.learncode.graphics.drawable.Drawable;
import com.learncode.graphics.shape.Shape;

import java.awt.*;

public abstract class Button extends Drawable {

    public static final int DEFAULT_RGB = Color.RED.getRGB();
    public static final int DEFAULT_HOVER_RGB = Color.CYAN.getRGB();
    public static final int DEFAULT_CLICK_RGB = Color.WHITE.getRGB();

    protected int hoverRgb;
    protected int clickRgb;
    protected Boolean clicked;
    protected Boolean hovered;
    protected Shape shape;

    public Button(int hoverRgb, int clickRgb, boolean hidden, boolean effective, Shape shape) {
        super(shape.getX(), shape.getY(), hidden, effective);
        this.hovered = false;
        this.hoverRgb = hoverRgb;
        this.clicked = false;
        this.clickRgb = clickRgb;
        this.shape = shape;
    }

    public Button(int hoverRgb, int clickRgb, boolean effective, Shape shape) {
        super(shape.getX(), shape.getY(), effective);
        this.hovered = false;
        this.hoverRgb = hoverRgb;
        this.clickRgb = clickRgb;
        this.clicked = false;
        this.shape = shape;
    }

    public Button(int hoverRgb, int clickRgb, Shape shape) {
        super(shape.getX(), shape.getY());
        this.hoverRgb = hoverRgb;
        this.clicked = false;
        this.hovered = false;
        this.clickRgb = clickRgb;
        this.shape = shape;
    }

    public Button(Color hoverColor, Color clickColor, boolean hidden, boolean effective, Shape shape) {
        this(hoverColor.getRGB(), clickColor.getRGB(), hidden, effective, shape);
    }

    public Button(Color hoverColor, Color clickColor, boolean effective, Shape shape) {
        this(hoverColor.getRGB(), clickColor.getRGB(), effective, shape);
    }

    public Button(Color hoverColor, Color clickColor, Shape shape) {
        this(hoverColor.getRGB(), clickColor.getRGB(), shape);
    }

    public Button(boolean hidden, boolean effective, Shape shape) {
        this(DEFAULT_HOVER_RGB, DEFAULT_CLICK_RGB, hidden, effective, shape);
    }

    public Button(boolean effective, Shape shape) {
        this(DEFAULT_HOVER_RGB, DEFAULT_CLICK_RGB, effective, shape);
    }

    public Button(Shape shape) {
        this(DEFAULT_HOVER_RGB, DEFAULT_CLICK_RGB, shape);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (hovered) {
            synchronized (clicked) {
                int oldRgb = shape.getRGB();
                int rgb = oldRgb;
                if (clicked) {
                    rgb = this.clickRgb;
                } else if (hovered) {
                    rgb = this.hoverRgb;
                }
                shape.setRGB(rgb);
                shape.draw(g);
                shape.setRGB(oldRgb);
            }
        }
    }

    public Boolean isHovered() {
        return hovered;
    }

    public Boolean isClicked() {
        return clicked;
    }

    public void click() {
        clicked = true;
    }

    public void release() {
        clicked = false;
    }

    public void hover() {
        hovered = true;
    }

    public void clearHover() {
        hovered = false;
    }

    public boolean inside(int x, int y) {
        return shape.getBounds().contains(x, y);
    }

    public boolean inside(Point p) {
        return inside(p.x, p.y);
    }

}
