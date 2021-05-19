package com.scg.cutscene;

import com.badlogic.gdx.math.Vector3;
import com.scg.camera.CameraHolder;

public class CutsceneTaskMoveCamera extends CutsceneTask {

	private float goalX, goalY;

	public CutsceneTaskMoveCamera(String focusID) {
		super(focusID);
		
	}
	
	@Override
	public void play() {
		Vector3 vector = new Vector3(goalX, goalY, 0);
		CameraHolder.setLerpPosition(vector);
		super.isAlive = false;
	}
	
	public void setup(float goalX, float goalY) {
		this.setGoalX(goalX);
		this.setGoalY(goalY);
		
	}

	public float getGoalX() {
		return goalX;
	}

	public void setGoalX(float goalX) {
		this.goalX = goalX;
	}

	public float getGoalY() {
		return goalY;
	}

	public void setGoalY(float goalY) {
		this.goalY = goalY;
	}

}
