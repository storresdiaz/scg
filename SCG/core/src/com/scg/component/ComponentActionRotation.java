package com.scg.component;

import com.scg.entity.Entity;

public class ComponentActionRotation extends Component {
	
	private ComponentProperties componentProperties;
	
	private float rotationSpeed = 10, currentRotation = 1;

	public ComponentActionRotation(Entity parentEntity) {
		super(parentEntity);
	}
	
	@Override
	public void initialize() {
		
		componentProperties = (ComponentProperties) parentEntity.findComponent(ComponentProperties.class);
		
	}
	
	@Override
	public void update(float delta) {
		currentRotation = componentProperties.getRotation();
		currentRotation += rotationSpeed * delta;
		componentProperties.setRotation(currentRotation);
		
	}

}
