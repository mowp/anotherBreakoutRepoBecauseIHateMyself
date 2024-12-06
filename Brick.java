package io.github.mowpBreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    private int x, y, w, h, isHit = 0;

    public Brick(int x, int y, int w, int h, int isHit) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isHit = isHit;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getIsHit() {
        return isHit;
    }

    public void setIsHit(int isHit) {
        this.isHit = isHit;
    }

    public void draw(ShapeRenderer sR) {
        sR.setColor(Color.BLACK);
        if (isHit == 0) {
            sR.rect(x,y,w,h);
        }
    }
}
