package com.learncode.frame;

import com.learncode.frame.toolbar.Toolbar;
import com.learncode.graphics.button.Button;
import com.learncode.graphics.button.FilledRectangularButton;
import com.learncode.graphics.drawable.Drawable;
import com.learncode.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Coen on 15-7-2017.
 */
public abstract class Frame extends JFrame {

    public static int runningFrames;
    protected static Point point;

    static {
        runningFrames = 0;
        point = new Point();
    }

    protected com.learncode.graphics.Canvas canvas;
    protected java.awt.Graphics graphics;
    protected BufferStrategy bufferStrategy;
    protected BufferedImage bufferedImage;
    protected Button closeBtn;
    protected Button minBtn;
    protected Toolbar toolbar;

    private ReentrantLock readyLock;
    private Condition readyCondition;
    private boolean ready;

    public Frame(String title) {
        super(title);
        runningFrames++;
        // TODO: while not ready: show splash screen
        readyLock = new ReentrantLock();
        readyCondition = readyLock.newCondition();
        ready = false;
        setUndecorated(true);
        FrameHandler frameHandler = new FrameHandler(this);
        bufferedImage = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
        canvas = new com.learncode.graphics.Canvas(this);
        this.add(canvas);
        canvas.addMouseListener(frameHandler);
        canvas.addMouseMotionListener(frameHandler);
        this.pack();
        canvas.createBufferStrategy(3);
        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
        closeBtn = new FilledRectangularButton(Main.WIDTH - 30, 5, 25, 25, false);
        minBtn = new FilledRectangularButton(Main.WIDTH - 60, 5, 25, 25, Color.LIGHT_GRAY.getRGB(), Button.DEFAULT_HOVER_RGB, Button.DEFAULT_CLICK_RGB, false);
        toolbar = new Toolbar(Color.GRAY, closeBtn, minBtn);
        canvas.add(toolbar);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        Thread drawThread = new Thread(() -> run());
        initialize();
        drawThread.start();
        display();
    }

    public void close() {
        this.dispose();
        runningFrames--;
        if (runningFrames <= 0) {
            System.exit(0);
        }
    }

    public void minimize() {
        setState(JFrame.ICONIFIED);
    }

    public void add(Drawable drawable) {
        canvas.add(drawable);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public abstract void initialize();

    private void display() {
        readyLock.lock();
        try {
            while (!ready) {
                readyCondition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readyLock.unlock();
            setVisible(true);
        }
    }

    private void run() {
        double time;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passed;
        double delta = 0;
        double rate = 0;
        int frames = 0;
        int fps = 0;
        while (true) {
            boolean render = false;
            time = System.nanoTime() / 1000000000.0;
            passed = time - lastTime;
            lastTime = time;
            delta += passed;
            rate += passed;
            double tickSpeed = 1.0 / 60.0;
            while (delta >= tickSpeed) {
                delta -= tickSpeed;
                render = true;
                if (rate >= 1.0) {
                    rate = 0;
                    fps = frames;
                    frames = 0;
                }
            }
            if (render) {
                readyLock.lock();
                //render
                paint();
                frames++;
                ready = true;
                readyCondition.signalAll();
                readyLock.unlock();
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void paint() {
        synchronized (canvas) {
            graphics.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
            canvas.paint();
            bufferStrategy.show();
        }
    }

    public void repaint() {
        paint();
    }

}
