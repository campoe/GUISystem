package com.learncode.graphics.pixel;

import com.learncode.graphics.Graphics;
import com.learncode.graphics.drawable.Drawable;

import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public class Pixel extends Drawable {

    protected int rgb;

    public Pixel(int x, int y, int rgb) {
        super(x, y);
        this.rgb = rgb;
    }

    public Pixel(int x, int y, Color color) {
        this(x, y, color.getRGB());
    }

    public Pixel(int x, int y, int rgb, boolean hidden, boolean effective) {
        super(x, y, hidden, effective);
        this.rgb = rgb;
    }

    public Pixel(int x, int y, int rgb, boolean effective) {
        super(x, y, effective);
        this.rgb = rgb;
    }

    public Pixel(int x, int y, Color color, boolean hidden, boolean effective) {
        this(x, y, color.getRGB(), hidden, effective);
    }

    public Pixel(int x, int y, Color color, boolean effective) {
        this(x, y, color.getRGB(), effective);
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixel((int) x, (int) y, rgb);
    }

}
