package io.github.mowpBreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x, y, rad, speed, dir;

    public Ball(int x, int y, int rad, int speed, int dir) {
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.speed = speed;
        this.dir = dir;
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

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void draw(ShapeRenderer sR) {
        sR.setColor(Color.RED);
        sR.circle(x,y,rad);
    }
}
