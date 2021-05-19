package com.scg.component;

import com.scg.entity.Entity;

public class Component {
	
	public Entity parentEntity;
	public boolean isEnabled = true;
	
	public Component(Entity parentEntity) {
		this.parentEntity = parentEntity;
	}
	
	// Used for acquiring component references from parent entity first and foremost
	public void initialize() {
		
	}

	
	public void render() {
		
	}
	
	public void update(float delta) {
		
	}
	
	public final void setParentEntity(Entity parentEntity) {
		this.parentEntity = parentEntity;
	}
	
	public final void removeParentEntity() {
		this.parentEntity = null;
	}
	
	public final void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}
	
	public final boolean isEnabled() {
		return isEnabled;
	}

	
}
