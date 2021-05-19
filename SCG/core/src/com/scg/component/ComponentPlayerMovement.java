package com.scg.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.scg.entity.Entity;

public class ComponentPlayerMovement extends Component {
	
	private ComponentProperties componentProperties;

	public ComponentPlayerMovement(Entity parentEntity) {
		super(parentEntity);
	}
	
	@Override
	public void initialize() {
		
		componentProperties = (ComponentProperties) parentEntity.findComponent(ComponentProperties.class);
		
	}
	
	@Override
	public void update(float delta){
		
		float velocity = componentProperties.getVelocity();
		float speed = componentProperties.getSpeed();
		float posX = componentProperties.getPosX();
		float posY = componentProperties.getPosY();
		float rotation = componentProperties.getRotation();
		float rotationSpeed = componentProperties.getRotationSpeed();
		float maxRotationSpeed = componentProperties.getMaxRotationSpeed();
		float maxSpeed = componentProperties.getMaxSpeed();
		
		if(Gdx.input.isKeyPressed(Keys.D)) {
			
			if(rotationSpeed < maxRotationSpeed) {
			rotationSpeed -= velocity * delta;
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.A)) {
			
			if(rotationSpeed > maxRotationSpeed * -1) {
			rotationSpeed += velocity * delta;
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)) {
			
			if(speed < maxSpeed) {
				speed  += velocity * delta;
			}
			
		}
		
		// Controls Left and right direction smoothly
		if(rotationSpeed <0) {
		rotationSpeed += velocity * delta / 2 ;
		rotation -= Math.abs(rotationSpeed);
		
			if(rotationSpeed > 0) {
				rotationSpeed = 0;
			}
		
		}
		if(rotationSpeed >0) {
			rotationSpeed -= velocity * delta / 2;
			rotation += rotationSpeed;
			
			if(rotationSpeed < 0) {
				rotationSpeed = 0;
			}
		}
	
		
		
		// Movement Forwards + Backwards
		posX += Math.cos(Math.toRadians(rotation)) * speed;
		posY += Math.sin(Math.toRadians(rotation)) * speed;
		
		if(speed > 0) {
			speed -= velocity / 2 * delta;
			if(speed < 0) {
				speed = 0;
			}
		}
		if(speed < 0) {
			speed += velocity / 2 * delta;
			if(speed > 0) {
				speed = 0;
			}
		}
		
		
		componentProperties.setRotationSpeed(rotationSpeed);
		componentProperties.setRotation(rotation);
		componentProperties.setPosX(posX);
		componentProperties.setPosY(posY);
		componentProperties.setSpeed(speed);
	}
	

	
}
