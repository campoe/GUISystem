package com.learncode.graphics.shape;

import com.learncode.graphics.shape.circular.Circle;
import com.learncode.graphics.shape.circular.FilledCircle;
import com.learncode.graphics.shape.circular.OutlinedCircle;
import com.learncode.graphics.shape.linear.Line;
import com.learncode.graphics.shape.rectangular.FilledRectangle;
import com.learncode.graphics.shape.rectangular.OutlinedRectangle;
import com.learncode.graphics.shape.rectangular.Rectangle;

import java.awt.*;

public class ShapeFactory {

    public static final int CIRCULAR = 1;
    public static final int RECTANGULAR = 2;
    public static final int FILLED = 3;
    public static final int OUTLINED = 4;

    private ShapeFactory() {

    }

    public static FilledRectangle createFilledRectangle(float x, float y, float width, float height, int rgb) {
        return new FilledRectangle(x, y, width, height, rgb);
    }

    public static OutlinedRectangle createOutlinedRectangle(float x, float y, float width, float height, int rgb) {
        return new OutlinedRectangle(x, y, width, height, rgb);
    }

    public static Rectangle createRectangle(float x, float y, float width, float height, int rgb, int style) {
        switch (style) {
            case FILLED:
                return createFilledRectangle(x, y, width, height, rgb);
            case OUTLINED:
                return createOutlinedRectangle(x, y, width, height, rgb);
            default:
                return null;
        }
    }

    public static Line createLine(float x, float y, float x2, float y2, int rgb) {
        return new Line(x, y, x2, y2, rgb);
    }

    public static FilledCircle createFilledCircle(float x, float y, float radius, int rgb) {
        return new FilledCircle(x, y, radius, rgb);
    }

    public static OutlinedCircle createOutlinedCircle(float x, float y, float radius, int rgb) {
        return new OutlinedCircle(x, y, radius, rgb);
    }

    public static Circle createCirlce(float x, float y, float radius, int rgb, int style) {
        switch (style) {
            case FILLED:
                return createFilledCircle(x, y, radius, rgb);
            case OUTLINED:
                return createOutlinedCircle(x, y, radius, rgb);
            default:
                return null;
        }
    }

    public static FilledRectangle createFilledRectangle(float x, float y, float width, float height, Color color) {
        return createFilledRectangle(x, y, width, height, color.getRGB());
    }

    public static OutlinedRectangle createOutlinedRectangle(float x, float y, float width, float height, Color color) {
        return createOutlinedRectangle(x, y, width, height, color.getRGB());
    }

    public static Rectangle createRectangle(float x, float y, float width, float height, Color color, int style) {
        switch (style) {
            case FILLED:
                return createFilledRectangle(x, y, width, height, color.getRGB());
            case OUTLINED:
                return createOutlinedRectangle(x, y, width, height, color.getRGB());
            default:
                return null;
        }
    }

    public static Line createLine(float x, float y, float x2, float y2, Color color) {
        return createLine(x, y, x2, y2, color.getRGB());
    }

    public static FilledCircle createFilledCircle(float x, float y, float radius, Color color) {
        return createFilledCircle(x, y, radius, color.getRGB());
    }

    public static OutlinedCircle createOutlinedCircle(float x, float y, float radius, Color color) {
        return createOutlinedCircle(x, y, radius, color.getRGB());
    }

    public static Circle createCirlce(float x, float y, float radius, Color color, int style) {
        switch (style) {
            case FILLED:
                return createFilledCircle(x, y, radius, color.getRGB());
            case OUTLINED:
                return createOutlinedCircle(x, y, radius, color.getRGB());
            default:
                return null;
        }
    }

}
