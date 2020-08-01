package com.jervac.entities.bullets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.jervac.core.DOD;

public class Pellet extends Projectile{

    public Pellet(Vector2 pos, Vector2 startPos, Vector2 size, float speed, Vector2 dir, int damage, boolean isPlayer) {
        super(pos, startPos, size, speed, dir, damage, isPlayer);
    }

    public void init() {

    }

    public void render() {
        DOD.sr.setColor(Color.DARK_GRAY);
        DOD.sr.begin(ShapeRenderer.ShapeType.Filled);
        DOD.sr.rect(pos.x, pos.y, size.x, size.y);
        DOD.sr.end();
    }

    public void update() {
        dir.x -= startPos.x;
        dir.y -= startPos.y;
        dir.nor();

        pos.x += speed * dir.x * Gdx.graphics.getDeltaTime();
        pos.y += speed * dir.y * Gdx.graphics.getDeltaTime();

    }

    public void resize() {

    }

    public void dispose() {
        
    }
}