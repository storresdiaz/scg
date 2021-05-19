package com.scg.cutscene;

import com.scg.component.ComponentActionRotation;
import com.scg.component.ComponentNPCMovement;
import com.scg.component.ComponentPlayerMovement;
import com.scg.component.ComponentProperties;
import com.scg.component.ComponentSprite;

public class CutsceneTaskRemoveComponent extends CutsceneTask {

	private String component;
	
	public CutsceneTaskRemoveComponent(String focusID) {
		super(focusID);
		
	}
	
	@Override
	public void play() {
		switch(component.toLowerCase()) {
		case "componentactionrotation":
			super.focusEntity.removeComponent(ComponentActionRotation.class);;
			break;
		case "componentnpcmovement":
			super.focusEntity.removeComponent(ComponentNPCMovement.class);
			break;
		case "componentplayermovement":
			super.focusEntity.removeComponent(ComponentPlayerMovement.class);
			break;
		case "componentproperties":
			super.focusEntity.removeComponent(ComponentProperties.class);
			break;
		case "componentsprite":
			super.focusEntity.removeComponent(ComponentSprite.class);
			break;
		}
		
		super.isAlive = false;
	}
	
	public void setup(String component) {
		this.component = component;
	}

}
