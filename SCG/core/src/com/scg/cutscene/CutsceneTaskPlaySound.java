package com.scg.cutscene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class CutsceneTaskPlaySound extends CutsceneTask {

	private Music music;
	
	public CutsceneTaskPlaySound(String focusID) {
		super(focusID);
	}
	
	@Override
	public void play() {
		music.play();
		
		HelperHolder.addHelper(new Helper("default") {
			@Override
			public void render() {
				if(!music.isPlaying()) {
					music.dispose();
				}
			}
		});
	}
	
	public void setup(String filePath) {
		this.music = Gdx.audio.newMusic(Gdx.files.internal(filePath));
	}

}
