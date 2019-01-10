package com.learncode.graphics.text;

import com.learncode.graphics.Graphics;
import com.learncode.graphics.drawable.Drawable;

import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public class Text extends Drawable {

    protected int rgb;

    public Text(float x, float y, int rgb) {
        super(x, y);
        this.rgb = rgb;
    }

    public Text(float x, float y, Color color) {
        this(x, y, color.getRGB());
    }

    public Text(float x, float y, int rgb, boolean hidden, boolean effective) {
        super(x, y, hidden, effective);
        this.rgb = rgb;
    }

    public Text(float x, float y, int rgb, boolean effective) {
        super(x, y, effective);
        this.rgb = rgb;
    }

    public Text(float x, float y, Color color, boolean hidden, boolean effective) {
        this(x, y, color.getRGB(), hidden, effective);
    }

    public Text(float x, float y, Color color, boolean effective) {
        this(x, y, color.getRGB(), effective);
    }

    @Override
    public void draw(Graphics g) {

    }

    public void scale(float widthFactor, float heightFactor) {

    }

}
