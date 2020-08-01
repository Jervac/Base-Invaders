package com.jervac.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jervac.screens.Play;

public class DOD extends Game {

	Play play;

	public static OrthographicCamera cam;
	public static Viewport vp;
	public static SpriteBatch g;
	public static ShapeRenderer sr;

	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		vp = new StretchViewport(1000, 563);
		vp.apply();
		cam.position.set(1000 / 2, 563 / 2, 0);
		g = new SpriteBatch();
		sr = new ShapeRenderer();

		//Screens
		play = new Play();
		play.init();
		setScreen(play);
	}

	public void render() {
		update();
		this.getScreen().render(Gdx.graphics.getDeltaTime());
	}

	private void update() {
		cam.update();
		Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		g.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);

		Vector3 mouse_unprojected = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		cam.unproject(mouse_unprojected);
	}

	public void resize(int width, int height) {
		vp.update(width, height);
		this.getScreen().resize(width, height);
	}

	public void dispose() {
		this.getScreen().dispose();
	}
}