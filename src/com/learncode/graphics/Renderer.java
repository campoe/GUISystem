package com.learncode.graphics;

import com.learncode.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 16-7-2017.
 */
public class Renderer {

    List<Drawable> drawables;

    public Renderer() {
        this.drawables = new ArrayList<>();
    }

    public void add(Drawable drawable) {
        drawables.add(drawable);
    }

    public void addAll(Collection<Drawable> drawables) {
        this.drawables.addAll(drawables);
    }

    public void remove(Drawable drawable) {
        drawables.remove(drawable);
    }

    public void remove(int index) {
        drawables.remove(index);
    }

    public void removeAll(Collection<Drawable> drawables) {
        this.drawables.removeAll(drawables);
    }

    public void clear() {
        this.drawables.clear();
    }

    public void render(Graphics g) {
        g.clear();
        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(g);
        }
    }

}
