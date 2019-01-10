package com.learncode.graphics.image;

import com.learncode.graphics.Graphics;
import com.learncode.graphics.drawable.Drawable;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Coen on 16-7-2017.
 */
public class Image extends Drawable {

    protected float width, height;
    protected BufferedImage bufferedImage;

    public Image(float x, float y, float width, float height, BufferedImage bufferedImage) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.bufferedImage = bufferedImage;
    }

    public Image(float x, float y, float width, float height, String imagePath) {
        this(x, y, width, height, read(imagePath));
    }

    public Image(float x, float y, BufferedImage bufferedImage) {
        this(x, y, bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage);
    }

    public Image(float x, float y, float width, float height, boolean hidden, boolean effective, BufferedImage bufferedImage) {
        super(x, y, hidden, effective);
        this.width = width;
        this.height = height;
        this.bufferedImage = bufferedImage;
    }

    public Image(float x, float y, float width, float height, boolean effective, BufferedImage bufferedImage) {
        super(x, y, effective);
        this.width = width;
        this.height = height;
        this.bufferedImage = bufferedImage;
    }

    public Image(float x, float y, float width, float height, boolean hidden, boolean effective, String imagePath) {
        this(x, y, width, height, hidden, effective, read(imagePath));
    }

    public Image(float x, float y, float width, float height, boolean effective, String imagePath) {
        this(x, y, width, height, effective, read(imagePath));
    }

    public Image(float x, float y, String imagePath) {
        this(x, y, read(imagePath));
    }

    public static BufferedImage read(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return image;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(x, y, width, height, bufferedImage);
    }

    public void scale(float widthFactor, float heightFactor) {
        BufferedImage before = bufferedImage;
        int w = (int) (before.getWidth() * widthFactor);
        int h = (int) (before.getHeight() * heightFactor);
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(widthFactor, heightFactor);
        AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        atop.filter(before, after);
        bufferedImage = after;
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
    }

    public void scale(float factor) {
        scale(factor, factor);
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

}
