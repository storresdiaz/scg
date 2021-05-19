package com.scg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;


public class Core extends Game {

	private ScreenGame screenGame;
	
	@Override
	public void create () {
		
		screenGame = new ScreenGame(this);
		super.setScreen(screenGame);
	
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		
		
		// Exit on escape press
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
	}
	
	@Override
	public void dispose () {
	
	}
}
