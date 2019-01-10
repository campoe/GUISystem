package com.learncode.main;

import com.learncode.frame.Frame;
import com.learncode.graphics.image.Image;
import com.learncode.graphics.shape.ShapeFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Coen on 16-7-2017.
 */
public class Main {

    public static final Rectangle SCREEN_SIZE = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    public static final float SCREEN_RATIO = (float) (SCREEN_SIZE.getHeight() / SCREEN_SIZE.getWidth());
    public static final int TOOLBAR_HEIGHT = 35;
    public static final int WIDTH = (int) (SCREEN_SIZE.getWidth() * SCREEN_RATIO);
    public static final int HEIGHT = (int) (SCREEN_SIZE.getHeight() * SCREEN_RATIO + TOOLBAR_HEIGHT);
    public static final int EFFECTIVE_WIDTH = WIDTH;
    public static final int EFFECTIVE_HEIGHT = HEIGHT - TOOLBAR_HEIGHT;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame("Graphics System") {
                @Override
                public void initialize() {
                    Image background = new Image(0, 0, "res/dota2all.jpg");
                    background.scale(EFFECTIVE_WIDTH / background.getWidth(), EFFECTIVE_HEIGHT / background.getHeight());
                    add(background);
                    add(ShapeFactory.createFilledRectangle(0, 0, EFFECTIVE_WIDTH, EFFECTIVE_HEIGHT, 0x500000FF));
                }
            };
        });
    }

}
