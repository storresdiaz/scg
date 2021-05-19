package com.scg.cutscene;

import com.scg.component.ComponentActionRotation;
import com.scg.component.ComponentNPCMovement;
import com.scg.component.ComponentPlayerMovement;
import com.scg.component.ComponentProperties;
import com.scg.component.ComponentSprite;

public class CutsceneTaskAddComponent extends CutsceneTask {

	private String component;
	
	public CutsceneTaskAddComponent(String focusID) {
		super(focusID);
		
	}
	
	@Override
	public void play() {
		switch(component.toLowerCase()) {
		case "componentactionrotation":
			super.focusEntity.addComponent(new ComponentActionRotation(super.focusEntity));
			break;
		case "componentnpcmovement":
			super.focusEntity.addComponent(new ComponentNPCMovement(super.focusEntity));
			break;
		case "componentplayermovement":
			super.focusEntity.addComponent(new ComponentPlayerMovement(super.focusEntity));
			break;
		case "componentproperties":
			super.focusEntity.addComponent(new ComponentProperties(super.focusEntity));
			break;
		case "componentsprite":
			super.focusEntity.addComponent(new ComponentSprite(super.focusEntity));
			break;
		}
		
		super.isAlive = false;
	}
	
	public void setup(String component) {
		this.component = component;
	}

}
