package com.learncode.graphics;

import com.learncode.main.Main;
import com.learncode.frame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

/**
 * Created by Coen on 16-7-2017.
 */
public class Graphics {

    private int[] pixels;

    public Graphics(JFrame frame) {
        this.pixels = ((DataBufferInt) ((Frame) frame).getBufferedImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void setPixel(int index, int value) {
        this.pixels[index] = value;
    }

    public int getPixel(int index) {
        return this.pixels[index];
    }

    public void drawPixel(int x, int y, int rgb) {
        if (x < 0 || x >= Main.WIDTH || y < 0 || y >= Main.HEIGHT) {
            return;
        }
        int alpha = (rgb >> 24) & 0xFF;
        if (alpha == 0) {
            return;
        }
        if (alpha == 255) {
            pixels[x + y * Main.WIDTH] = rgb;
        } else {
            int color = pixels[x + y * Main.WIDTH];
            int red = ((color >> 16) & 0xFF) - (int) ((((color >> 16) & 0xFF) - ((rgb >> 16) & 0xFF)) * (alpha / 255f));
            int green = ((color >> 8) & 0xFF) - (int) ((((color >> 8) & 0xFF) - ((rgb >> 8) & 0xFF)) * (alpha / 255f));
            int blue = ((color) & 0xFF) - (int) ((((color) & 0xFF) - ((rgb) & 0xFF)) * (alpha / 255f));
            pixels[x + y * Main.WIDTH] = (red << 16 | green << 8 | blue);
        }
    }

    public void drawPixel(int x, int y, Color color) {
        drawPixel(x, y, color.getRGB());
    }

    public void drawRectangle(float x, float y, float width, float height, int rgb) {
        for (int xi = 0; xi <= width; xi++) {
            drawPixel((int) (x + xi), (int) y, rgb);
            drawPixel((int) (x + xi), (int) (y + height), rgb);
        }
        for (int yi = 0; yi <= height; yi++) {
            drawPixel((int) x, (int) (y + yi), rgb);
            drawPixel((int) (x + width), (int) (y + yi), rgb);
        }
    }

    public void drawRectangle(float x, float y, float width, float height, Color color) {
        drawRectangle(x, y, width, height, color.getRGB());
    }

    public void fillRectangle(float x, float y, float width, float height, int rgb) {
        for (int xi = 0; xi <= width; xi++) {
            for (int yi = 0; yi <= height; yi++) {
                drawPixel((int) (x + xi), (int) (y + yi), rgb);
            }
        }
    }

    public void fillRectangle(float x, float y, float width, float height, Color color) {
        fillRectangle(x, y, width, height, color.getRGB());
    }

    public void drawImage(float x, float y, float width, float height, BufferedImage image) {
        for (int xi = 0; xi < width; xi++) {
            for (int yi = 0; yi < height; yi++) {
                drawPixel((int) (x + xi), (int) (y + yi), image.getRGB(xi, yi));
            }
        }
    }

    public void fillCircle(float x, float y, float radius, int rgb) {
        for (int xi = (int) (x - radius); xi < x + radius; xi++) {
            for (int yi = (int) (y - radius); yi < y + radius; yi++) {
                double distance = Math.sqrt((xi - x) * (xi - x) + (yi - y) * (yi - y));
                if (distance < radius) {
                    drawPixel((int) (x + xi), (int) (y + yi), rgb);
                }
            }
        }
    }

    public void fillCircle(float x, float y, float radius, Color color) {
        fillCircle(x, y, radius, color.getRGB());
    }

    public void drawCircle(float x, float y, float radius, int rgb) {
        for (int xi = (int) (x - radius); xi < x + radius; xi++) {
            for (int yi = (int) (y - radius); yi < y + radius; yi++) {
                double distance = Math.sqrt((xi - x) * (xi - x) + (yi - y) * (yi - y));
                if (Math.abs(distance) >= radius - 1 && Math.abs(distance) <= radius + 1) {
                    drawPixel((int) (x + xi), (int) (y + yi), rgb);
                }
            }
        }
    }

    public void drawCircle(float x, float y, float radius, Color color) {
        drawCircle(x, y, radius, color.getRGB());
    }

    public void drawLine(float xi, float yi, float xj, float yj, int rgb) {
        float x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        if ((xi <= xj && yi <= yj) || (xi <= xj && yi > yj)) {
            x1 = xi;
            x2 = xj;
            y1 = yi;
            y2 = yj;
        } else if ((xi > xj && yi > yj) || (xi > xj && yi <= yj)) {
            x1 = xj;
            x2 = xi;
            y1 = yj;
            y2 = yi;
        }
        float angle = (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if (angle < 0) {
            angle += 360;
        }
        double dir = Math.toRadians(angle);
        float cosDir = (float) Math.cos(dir);
        float sinDir = (float) Math.sin(dir);
        float nextX = x1, nextY = y1;
        while (true) {
            drawPixel((int) nextX, (int) nextY, rgb);
            if (nextX <= x2) {
                nextX += cosDir;
            }
            if (!(xi <= xj && yi > yj) && !(xi > xj && yi <= yj)) {
                if (nextY <= y2) {
                    nextY += sinDir;
                }
                if ((nextX > x2 || Math.abs(cosDir) < 0.001) && (nextY > y2 || Math.abs(sinDir) < 0.001)) {
                    return;
                }
            } else {
                if (nextY > y2) {
                    nextY += sinDir;
                }
                if ((nextX > x2 || Math.abs(cosDir) < 0.001) && (nextY <= y2 || Math.abs(sinDir) < 0.001)) {
                    return;
                }
            }

        }
    }

    public void drawLine(float x1, float y1, float x2, float y2, Color color) {
        drawLine(x1, y1, x2, y2, color.getRGB());
    }

}
