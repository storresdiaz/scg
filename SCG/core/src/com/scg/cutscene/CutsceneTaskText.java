package com.scg.cutscene;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.scg.camera.CameraHolder;

public class CutsceneTaskText extends CutsceneTask {

	private String text;
	private String helperID;
	private BitmapFont font;
	private float delay =1 ;
	
	private boolean isDone = false;
	
	public CutsceneTaskText(String focusID) {
		super(focusID);
		
	}
	
	@Override
	public void play() {
		
		font = new BitmapFont();
		font.getData().setScale(1.2f);
		
		
		HelperHolder.addHelper(new Helper(helperID) {
			
			@Override
			public void render() {
				
				if(!isDone) {
				CameraHolder.spriteBatchOverlay.begin();
				font.draw(CameraHolder.spriteBatchOverlay, text,  -250, -450);
				CameraHolder.spriteBatchOverlay.end();
				}
			}
			
			@Override
			public void setup() {
				Timer.schedule(new Task() {

					@Override
					public void run() {
						isDone = true;
						font.dispose();
						isAlive = false;
					}
					
				}, delay);
			}
			
		});
		
	}
	
	public void setup(String helperID, float delay,  String text ) {
		this.helperID = helperID;
		this.text = text;
		this.delay = delay;
	}
}
