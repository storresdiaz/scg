package com.scg.cutscene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.scg.camera.CameraHolder;

public class CutsceneTaskTransitionImage extends CutsceneTask {

	private float delay = 1, transparency = 0, transparencySpeed = .40f;
	private float underlayTransparency = 0;
	private boolean isDone = false;
	private Texture transitionImage;
	private String helperID;
	
	public CutsceneTaskTransitionImage(String focusID) {
		super(focusID);
	}
	
	@Override
	public void play() {
		
		final SpriteBatch spriteBatch = CameraHolder.spriteBatchOverlay;
		
		HelperHolder.addHelper(new Helper(helperID) {
			@Override
			public void render() {
				
				if(!isDone && transparency < 1) {
					transparency += transparencySpeed * CameraHolder.delta;
					underlayTransparency -= transparencySpeed * CameraHolder.delta;
				}
				
				if(isDone && transparency > 0) {
					transparency -= transparencySpeed * CameraHolder.delta;
				
				}
				
				if(isDone && underlayTransparency < 1) {
					underlayTransparency += transparencySpeed* CameraHolder.delta;
				}
				
				if(!isDone && underlayTransparency > 0) {
					underlayTransparency -= transparencySpeed* CameraHolder.delta;
				}
				
				if(isDone && transparency < 0) {
					transitionImage.dispose();
					isAlive = false;
				}
				
				if(transparency > 1) {
					transparency = 1;
				}
				else if(transparency < 0) {
					transparency = 0;
				}
				
				if(underlayTransparency > 1) {
					underlayTransparency = 1;
				}
				else if(underlayTransparency < 0) {
					underlayTransparency = 0;
				}
				
				CameraHolder.spriteBatchBackground.setColor(1, 1, 1, underlayTransparency);
				CameraHolder.spriteBatch.setColor(1, 1, 1, underlayTransparency);
				spriteBatch.setColor(1, 1, 1, transparency);
				spriteBatch.begin();
				if(transparency > 0) {
				spriteBatch.draw(transitionImage, 0-transitionImage.getWidth()/2, 0-transitionImage.getHeight()/2);		
				}
				spriteBatch.end();
				
			}
			@Override
			public void update() {
				
			}
			@Override 
			public void setup() {
				Timer.schedule(new Task() {

					@Override
					public void run() {
						isDone = true;

					}
					
				}, delay);
			}
		});
	
	}
	
	public void setup(String helperID, String filePath, float delay) {
		this.delay = delay;
		this.helperID = helperID;
		transitionImage = new Texture(Gdx.files.internal(filePath));
	}

}
