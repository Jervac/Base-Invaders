package com.jervac.entities;

import com.badlogic.gdx.math.Vector2;

public abstract class Renderable {

    public Renderable(Vector2 pos, Vector2 size, float speed) {
        this.pos = pos;
        this.size = size;
        this.speed = speed;
    }

    public float speed;

    public Vector2 pos = null;

    public Vector2 size = null;

    public abstract void init();

    public abstract void render();

    public abstract void update();

    public abstract void resize();

    public abstract void dispose();

    public Vector2 getPos() {return pos;}

    public void setPos(Vector2 pos) {this.pos = pos;}
}