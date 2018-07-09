package ru.job4j.treads.piangpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int count = 1;
        while (true) {
            this.rect.setX(this.rect.getX() + count);
            if (rect.getX() == 0) {
                count = 1;
            }
            if (rect.getX() == 300) {
                count = -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}