package com.learncode.frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FrameHandler implements MouseListener, MouseMotionListener {

    private Frame frame;

    public FrameHandler(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (frame.closeBtn.inside(mouseX, mouseY)) {
            frame.close();
        } else if (frame.minBtn.inside(mouseX, mouseY)) {
            frame.minimize();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        frame.point.x = e.getX();
        frame.point.y = e.getY();
        if (frame.closeBtn.inside(e.getPoint())) {
            frame.closeBtn.click();
        } else if (frame.minBtn.inside(e.getPoint())) {
            frame.minBtn.click();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        frame.closeBtn.release();
        frame.minBtn.release();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = frame.getLocation();
        if (frame.getToolbar().inside(frame.point.x, frame.point.y)) {
            frame.setLocation(p.x + e.getX() - frame.point.x,
                    p.y + e.getY() - frame.point.y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (frame.closeBtn.inside(mouseX, mouseY)) {
            frame.closeBtn.hover();
            frame.minBtn.clearHover();
        } else if (frame.minBtn.inside(mouseX, mouseY)) {
            frame.minBtn.hover();
            frame.closeBtn.clearHover();
        } else {
            frame.closeBtn.clearHover();
            frame.minBtn.clearHover();
        }
    }

}
