package com.jervac.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.jervac.core.DOD;
import com.jervac.entities.bullets.Pellet;
import com.jervac.entities.bullets.Projectile;

import java.util.ArrayList;

public class Player extends Renderable{

    public Player(Vector2 pos, Vector2 size, float speed) {
        super(pos, size, speed);
    }


    ArrayList<Projectile> bullets = new ArrayList<Projectile>();

    public void init() {}


    public void render() {
        DOD.sr.setColor(Color.ORANGE);
        DOD.sr.begin(ShapeRenderer.ShapeType.Filled);
        DOD.sr.rect(pos.x - size.x/2, pos.y, size.x, size.y);
        DOD.sr.end();

        for(Projectile p: bullets)
            p.render();
    }


    public void update() {
        input();
        DOD.cam.position.set(DOD.cam.position.x + (pos.x - DOD.cam.position.x) * 0.09f, 0, 0);

        for(Projectile p: bullets)
            p.update();

    }

    private void input() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            pos.x -= speed * Gdx.graphics.getDeltaTime();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            pos.x += speed * Gdx.graphics.getDeltaTime();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            bullets.add(new Pellet(new Vector2(pos.x, pos.y), new Vector2(pos.x, pos.y), new Vector2(10, 10), 400, new Vector2(pos.x, pos.y + 20), 1, true));
        }
    }


    //Position of player where it is rendered
    @Override
    public Vector2 getPos() {
        return new Vector2(pos.x - size.x/2, pos.y);
    }

    public void resize() {

    }


    public void dispose() {
        for(Projectile p: bullets)
            p.dispose();
    }

}