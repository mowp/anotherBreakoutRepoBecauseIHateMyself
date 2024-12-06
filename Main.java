package io.github.mowpBreakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.lang.Math;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private ShapeRenderer sR;
    Player player;
    Ball ball;
    Brick[] bricks;
    int brickSpacing = 64+16;
    int dy;
    int dx;


    @Override
    public void create() {
        sR = new ShapeRenderer();
        bricks = new Brick[4];

        for(int i=0; i<bricks.length; i++) {
            bricks[i] = new Brick(8+i*brickSpacing, Gdx.graphics.getHeight()-16, 64, 16, 0);
        }

        player = new Player(10, 10, 64, 16, 0,0);
        ball = new Ball(player.getX()+ player.getW()/2, player.getY()+player.getH(), 5,0, 0);
        player.setVel(10);
        ball.setSpeed(5);
        ball.setDir(90);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        //player movement
        if (Gdx.input.isKeyPressed(Input.Keys.A) && player.getX() > 0) {
            player.setVel(-10);
            player.setX(player.getX() + player.getVel());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.getX() + player.getW() < Gdx.graphics.getWidth()) {
            player.setVel(10);
            player.setX(player.getX() + player.getVel());
        }

        //ball movement
        dy = ball.getY() + (int) (ball.getSpeed() * Math.sin(Math.toRadians(ball.getDir())));
        dx = ball.getX() + (int) (ball.getSpeed() * Math.cos(Math.toRadians(ball.getDir())));
        ball.setY(dy);
        ball.setX(dx);

        //wall collisions
        if (ball.getX() < 0) {
            ball.setDir(ball.getDir() + ball.getDir()/2);
        }

        if (ball.getY() + ball.getRad() > Gdx.graphics.getHeight()) {
            ball.setDir(ball.getDir()*-1);
        }

        if (ball.getX() > Gdx.graphics.getWidth()) {
            ball.setDir(ball.getDir() - ball.getDir()/2);
        }

        //check if hit paddle
        if (ball.getY()- ball.getRad()<player.getY()+ player.getH() && ball.getX()> player.getX() && ball.getX()+ ball.getRad()< player.getX()+ player.getW()){
            //ball.setY(player.getY()+player.getH());
            if (player.getVel() > 0) {
                ball.setDir(ball.getDir() + ball.getDir()/2);
            }
            if (player.getVel() < 0) {
                ball.setDir(ball.getDir() - ball.getDir()/2);
            }
        }

        // render
        sR.begin(ShapeRenderer.ShapeType.Filled);
        for(int i=0; i<bricks.length; i++) {
            bricks[i].draw(sR);
        }
        player.draw(sR);
        ball.draw(sR);
        sR.end();
    }

    @Override
    public void dispose() {
    }
}
