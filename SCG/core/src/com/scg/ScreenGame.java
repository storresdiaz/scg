package com.scg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.scg.camera.CameraHolder;
import com.scg.component.ComponentActionRotation;
import com.scg.component.ComponentPlayerMovement;
import com.scg.component.ComponentProperties;
import com.scg.component.ComponentSprite;
import com.scg.cutscene.Cutscene;
import com.scg.cutscene.CutsceneInterpreter;
import com.scg.cutscene.HelperHolder;
import com.scg.entity.Entity;
import com.scg.entity.EntityHolder;
import com.scg.sript.ScriptReader;

public class ScreenGame implements Screen {
	
	 Core core;
	 private Entity entityArtifact, entityShip;

	 
	 // Texture
	 private Texture background;
	 
	public ScreenGame(Core core) {
		this.core = core;
	
		// below this line For Testing at the moment
		entityArtifact = new Entity("the-artifact");
		entityArtifact.addComponent(new ComponentProperties(entityArtifact));
		entityArtifact.addComponent(new ComponentActionRotation(entityArtifact));
		ComponentSprite componentArtifactSprite = new ComponentSprite(entityArtifact);
		componentArtifactSprite.setTexture("assets/images/artifact_1.png");
		entityArtifact.addComponent(componentArtifactSprite);
		entityArtifact.initialize();
		
		entityShip = new  Entity("ship");
		ComponentProperties shipProperties = new ComponentProperties(entityShip);
		shipProperties.setPosX(1200);
		shipProperties.setGoalX(1200);
		shipProperties.setGoalY(1200);
		shipProperties.setPosY(1200);
		entityShip.addComponent(shipProperties);
		ComponentSprite componentShipSprite = new ComponentSprite(entityShip);
		componentShipSprite.setTexture("assets/images/ship_smuggler.png");
		entityShip.addComponent(componentShipSprite);
		entityShip.addComponent(new ComponentPlayerMovement(entityShip));
		entityShip.initialize();
	
		CutsceneInterpreter interpreter = new CutsceneInterpreter();
		Cutscene testScene = new Cutscene();
		ScriptReader scriptReader = new ScriptReader();
		
		EntityHolder.addEntity(entityArtifact);
		EntityHolder.addEntity(entityShip);
		
		CameraHolder.setup();
		
		scriptReader.loadCutscene("assets/cutscenes/chapter1act1", testScene);
		interpreter.Play(testScene);
		
		background = new Texture(Gdx.files.internal("assets/images/background.png"));
		
	}
	
	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		CameraHolder.update(delta);

		
		
		
	
		EntityHolder.update(delta);
		HelperHolder.update();
		
		
		CameraHolder.spriteBatchBackground.begin();
			CameraHolder.spriteBatchBackground.draw(background, -960 , -540);
		CameraHolder.spriteBatchBackground.end();
		
		EntityHolder.render();
		HelperHolder.render();
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		CameraHolder.updateViewport(width, height);
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
