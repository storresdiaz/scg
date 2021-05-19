package com.scg.cutscene;

public class CutsceneTaskSleep extends CutsceneTask {

	private float delay = 1; //seconds
	
	public CutsceneTaskSleep(String focusID) {
		super(focusID);
		
	}
	
	@Override
	public void play() {
		super.isAlive = false;
	}
	
	public void setup(int delay) {
		this.delay = delay;
	}

	public float getDelay() {
		return delay;
	}

	public void setDelay(float delay) {
		this.delay = delay;
	}

}
