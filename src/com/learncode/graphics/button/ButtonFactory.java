package com.learncode.graphics.button;

import com.learncode.frame.toolbar.*;

import java.awt.*;

public class ButtonFactory {

    public static final int CIRCULAR = 1;
    public static final int RECTANGULAR = 2;
    public static final int FILLED = 3;
    public static final int OUTLINED = 4;

    private ButtonFactory() {

    }

    public static FilledCircularButton createFilledCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb) {
        return new FilledCircularButton(x, y, radius, rgb, hoverRgb, clickRgb);
    }

    public static OutlinedCircularButton createOutlinedCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb) {
        return new OutlinedCircularButton(x, y, radius, rgb, hoverRgb, clickRgb);
    }

    public static CircularButton createCircularButton(float x, float y, float radius, int rgb, int hoverRgb, int clickRgb, int style) {
        switch (style) {
            case FILLED:
                return createFilledCircularButton(x, y, radius, rgb, hoverRgb, clickRgb);
            case OUTLINED:
                return createOutlinedCircularButton(x, y, radius, rgb, hoverRgb, clickRgb);
            default:
                return null;
        }
    }

    public static FilledRectangularButton createFilledRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb) {
        return new FilledRectangularButton(x, y, width, height, rgb, hoverRgb, clickRgb);
    }

    public static OutlinedRectangularButton createOutlinedRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb) {
        return new OutlinedRectangularButton(x, y, width, height, rgb, hoverRgb, clickRgb);
    }

    public static RectangularButton createRectangularButton(float x, float y, float width, float height, int rgb, int hoverRgb, int clickRgb, int style) {
        switch (style) {
            case FILLED:
                return createFilledRectangularButton(x, y, width, height, rgb, hoverRgb, clickRgb);
            case OUTLINED:
                return createOutlinedRectangularButton(x, y, width, height, rgb, hoverRgb, clickRgb);
            default:
                return null;
        }
    }

    public static FilledCircularButton createFilledCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor) {
        return createFilledCircularButton(x, y, radius, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
    }

    public static OutlinedCircularButton createOutlinedCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor) {
        return createOutlinedCircularButton(x, y, radius, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
    }

    public static CircularButton createCircularButton(float x, float y, float radius, Color color, Color hoverColor, Color clickColor, int style) {
        switch (style) {
            case FILLED:
                return createFilledCircularButton(x, y, radius, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
            case OUTLINED:
                return createOutlinedCircularButton(x, y, radius, color.getRGB(), clickColor.getRGB(), clickColor.getRGB());
            default:
                return null;
        }
    }

    public static FilledRectangularButton createFilledRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor) {
        return createFilledRectangularButton(x, y, width, height, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
    }

    public static OutlinedRectangularButton createOutlinedRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor) {
        return createOutlinedRectangularButton(x, y, width, height, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
    }

    public static RectangularButton createRectangularButton(float x, float y, float width, float height, Color color, Color hoverColor, Color clickColor, int style) {
        switch (style) {
            case FILLED:
                return createFilledRectangularButton(x, y, width, height, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
            case OUTLINED:
                return createOutlinedRectangularButton(x, y, width, height, color.getRGB(), hoverColor.getRGB(), clickColor.getRGB());
            default:
                return null;
        }
    }

}
