package com.jervac.entities.bullets;

import com.badlogic.gdx.math.Vector2;
import com.jervac.entities.Renderable;

public abstract class Projectile extends Renderable{

    public Projectile(Vector2 pos, Vector2 startPos, Vector2 size, float speed, Vector2 dir, int damage, boolean isPlayer) {
        super(pos, size, speed);
        this.startPos = startPos;
        this.dir = dir;
        this.damage = damage;
        this.isPlayer = isPlayer;
    }

    Vector2 dir;

    Vector2 startPos;

    int damage;

    boolean isPlayer;

}