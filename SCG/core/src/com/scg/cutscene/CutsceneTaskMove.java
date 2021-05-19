package com.scg.cutscene;

import com.scg.component.ComponentProperties;

public class CutsceneTaskMove extends CutsceneTask {

	private float goalX, goalY;
	private ComponentProperties componentProperties;
	
	public CutsceneTaskMove(String focusID) {
		super(focusID);
	}

	@Override
	public void play() {
		
		componentProperties = (ComponentProperties) super.focusEntity.findComponent(ComponentProperties.class);
		componentProperties.setGoalX(goalX);
		componentProperties.setGoalY(goalY);
		
		super.isAlive = false;
		
	}
	
	public void setup(float goalX, float goalY) {
		this.goalX = goalX;
		this.goalY = goalY;
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
