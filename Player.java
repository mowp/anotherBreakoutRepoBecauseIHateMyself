package io.github.mowpBreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    private int x, y, w, h, dir, vel;

    public Player(int x, int y, int w, int h, int dir, int vel) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dir = dir;
        this.vel = vel;
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public void draw(ShapeRenderer sR) {
        sR.setColor((Color.BLACK));
        sR.rect(x,y,w,h);
    }
}
