package com.scg.cutscene;

import com.scg.camera.CameraHolder;
import com.scg.component.ComponentProperties;

public class CutsceneTaskLockCamera extends CutsceneTask {


	
	public CutsceneTaskLockCamera(String focusID) {
		super(focusID);
	}
	
	@Override
	public void play() {
		try {
		CameraHolder.setLockEntityProperties((ComponentProperties) super.focusEntity.findComponent(ComponentProperties.class));
		}catch(Exception e) {
			
		}
		super.isAlive = false;
	}
	
	

}
