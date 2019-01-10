package com.learncode.graphics;

import com.learncode.main.Main;
import com.learncode.graphics.drawable.Drawable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public class Canvas extends java.awt.Canvas {

    private Graphics graphics;
    private Renderer renderer;

    public Canvas(JFrame frame) {
        renderer = new Renderer();
        graphics = new Graphics(frame);
        Dimension dimension = new Dimension((int) (Main.WIDTH), (int) (Main.HEIGHT));
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
    }

    public void paint() {
        getRenderer().render(graphics);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void add(Drawable drawable) {
        renderer.add(drawable);
    }

}
