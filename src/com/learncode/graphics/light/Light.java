package com.learncode.graphics.light;

import com.learncode.main.Main;
import com.learncode.graphics.Graphics;
import com.learncode.graphics.drawable.Drawable;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Light extends Drawable {

    protected int rgb;
    protected int numRays;
    protected int maxDistance;

    public Light(float x, float y, int numRays, int maxDistance, int rgb) {
        super(x, y);
        this.rgb = rgb;
        this.numRays = numRays;
        this.maxDistance = maxDistance;
    }

    public Light(float x, float y, int numRays, int maxDistance, Color color) {
        this(x, y, numRays, maxDistance, color.getRGB());
    }

    public Light(float x, float y, int numRays, int maxDistance, int rgb, boolean hidden, boolean effective) {
        super(x, y, hidden, effective);
        this.rgb = rgb;
        this.numRays = numRays;
        this.maxDistance = maxDistance;
    }

    public Light(float x, float y, int numRays, int maxDistance, int rgb, boolean effective) {
        super(x, y, effective);
        this.rgb = rgb;
        this.numRays = numRays;
        this.maxDistance = maxDistance;
    }

    public Light(float x, float y, int numRays, int maxDistance, Color color, boolean hidden, boolean effective) {
        this(x, y, numRays, maxDistance, color.getRGB(), hidden, effective);
    }

    public Light(float x, float y, int numRays, int maxDistance, Color color, boolean effective) {
        this(x, y, numRays, maxDistance, color.getRGB(), effective);
    }

    private static float dist(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    private static float getRayCast(float x1, float y1, float x2, float y2, float linex1, float liney1, float linex2, float liney2) {
        float dx, dy, linedx, linedy;
        dx = x2 - x1;
        dy = y2 - y1;
        linedx = linex2 - linex1;
        linedy = liney2 - liney1;
        float s, t;
        s = (-dy * (x1 - linex1) + dx * (y1 - liney1)) / (-linedx * dy + dx * linedy);
        t = (linedx * (y1 - liney1) - linedy * (x1 - linex1)) / (-linedx * dy + dx * linedy);
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
            // Collision detected
            float x = x1 + (t * dx);
            float y = y1 + (t * dy);
            return dist(x1, y1, x, y);
        }
        return -1; // No collision
    }

    private Collection<Line2D.Float> calcRays(Collection<Line2D.Float> lines, int x, int y, int numRays, int maxDist) {
        LinkedList<Line2D.Float> rays = new LinkedList<Line2D.Float>();
        for (int i = 0; i < numRays; i++) {
            double dir = (Math.PI * 2) * ((double) i / numRays);
            float minDist = maxDist;
            for (Line2D.Float line : lines) {
                float dist = getRayCast(x, y, x + (float) Math.cos(dir) * maxDist, y + (float) Math.sin(dir) * maxDist, (int) line.x1, (int) line.y1, (int) line.x2, (int) line.y2);
                if (dist < minDist && dist > 0) {
                    minDist = dist;
                }
            }
            rays.add(new Line2D.Float(x, y, x + (float) Math.cos(dir) * (minDist - 1), y + (float) Math.sin(dir) * (minDist - 1)));
        }
        return rays;
    }

    @Override
    public void draw(Graphics g) {
        List<Line2D.Float> blockingLines = new ArrayList<>();
        blockingLines.add(new Line2D.Float(0, Main.TOOLBAR_HEIGHT, Main.WIDTH, Main.TOOLBAR_HEIGHT));
        LinkedList<Line2D.Float> rays = (LinkedList<Line2D.Float>) calcRays(blockingLines, (int) x, (int) y, numRays, maxDistance);
        for (Line2D.Float ray : rays) {
            g.drawLine(ray.x1, ray.y1, ray.x2, ray.y2, rgb);
        }
    }

}
