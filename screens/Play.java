package com.jervac.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.jervac.entities.Player;

public class Play implements Screen{

    Player player;

    public void init() {
        player = new Player(new Vector2(0, -220), new Vector2(150, 20), 300);
    }

    public void update() {
        player.update();
    }

    public void render(float delta) {
        update();
        player.render();
    }

    public void pause() {}

    public void resume() {}

    public void hide() {}

    public void show() {}

    public void resize(int width, int height) {}

    public void dispose() {
        player.dispose();
    }

}