package com.scg.cutscene;

import com.scg.entity.Entity;
import com.scg.entity.EntityHolder;

public class CutsceneTask {

	public String focusID;
	// public GlobalEntityHolder entityHolder;
	public Entity focusEntity;
	public boolean isAlive = true;
	
	public CutsceneTask(String focusID) {
		this.focusID = focusID;
		//this.entityHolder = entityHolder;
	}
	
	public void setup() {
		
	}
	
	public final void initialize(){
		focusEntity = EntityHolder.findEntity(focusID);
	}
	
	public void play() {
		
	}
	
	
}
