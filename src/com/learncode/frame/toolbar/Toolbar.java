package com.learncode.frame.toolbar;

import com.learncode.main.Main;
import com.learncode.graphics.button.Button;
import com.learncode.graphics.shape.rectangular.FilledRectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends FilledRectangle {

    protected List<Button> buttons;
    protected String title;

    public Toolbar(String title, int rgb, Button... buttons) {
        super(0, 0, Main.WIDTH, Main.TOOLBAR_HEIGHT, false, rgb);
        this.title = title;
        this.buttons = new ArrayList<>();
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }
    }

    public Toolbar(String title, Color color, Button... buttons) {
        this(title, color.getRGB(), buttons);
    }

    public Toolbar(int rgb, Button... buttons) {
        this("", rgb, buttons);
    }

    public Toolbar(Color color, Button... buttons) {
        this("", color.getRGB(), buttons);
    }

    @Override
    public void draw(com.learncode.graphics.Graphics g) {
        super.draw(g);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).draw(g);
        }
    }

    public void add(Button button) {
        this.buttons.add(button);
    }

}
