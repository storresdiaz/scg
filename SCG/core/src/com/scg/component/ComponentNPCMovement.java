package com.scg.component;

import com.scg.entity.Entity;
import com.scg.math.MathSCG;

public class ComponentNPCMovement extends Component {
	
	private ComponentProperties componentProperties;
	

	public ComponentNPCMovement(Entity parentEntity) {
		super(parentEntity);
		
	}
	
	@Override
	public void initialize() {
		componentProperties = (ComponentProperties) super.parentEntity.findComponent(ComponentProperties.class);
	}
	
	public void render() {
		
	}
	
	@Override
	public void update(float delta) {
		
		float goalX = componentProperties.getGoalX();
		float goalY = componentProperties.getGoalY();
		float posX = componentProperties.getPosX();
		float posY = componentProperties.getPosY();
		float centerX = componentProperties.getCenterX();
		float centerY = componentProperties.getCenterY();
		float rotation = componentProperties.getRotation();
		float rotationSpeed = componentProperties.getRotationSpeed();
		float maxRotationSpeed = componentProperties.getMaxRotationSpeed();
		float maxSpeed = componentProperties.getMaxSpeed();
		float speed = componentProperties.getSpeed();
		float velocity = componentProperties.getVelocity();
		
		float angle = (float) Math.toDegrees(Math.atan2(goalY - centerY, goalX - centerX));

		
		// Rotate to goal
		
		 angle = componentProperties.normalizeAngle(angle);
		 float difference = angle-rotation;
		 if(difference < 0) {difference += 360;}
		 float distance = MathSCG.getDistanceBetween(centerX, goalX, centerY, goalY);
		
		 
		 if(angle != rotation) {
		maxRotationSpeed = maxRotationSpeed * MathSCG.getDistanceBetweenInPercent(difference, 0);
		rotationSpeed += (velocity * delta) ;
		
			if(rotationSpeed > maxRotationSpeed) {
				rotationSpeed = maxRotationSpeed;
			}
			
		if(difference < 2 && rotationSpeed < maxRotationSpeed * .10 || distance < 1)	{
		rotationSpeed = 0;
	}
			 if(difference > 180) {
			//left
			rotation -= rotationSpeed;
		}
			else{
			rotation += rotationSpeed;
		}
	}
	
	
	// Move to goal
		if(difference < 1 && distance > 0) {
			maxSpeed = maxSpeed * MathSCG.getDistanceBetweenInPercent(distance, 0);
			speed += (velocity * delta);
			if(speed > maxSpeed) {
				speed = maxSpeed;
			}
		}
		else {
			speed -= velocity * delta / 2;
			if(speed < 0) {
				speed = 0;
			}
		}
	
		if(distance < 2 && speed < maxRotationSpeed * .10) {
			posX = goalX - (componentProperties.getWidth()/2);
			posY = goalY - (componentProperties.getHeight()/2);
		}
	
		
		posX += Math.cos(Math.toRadians(rotation))*speed;
		posY += Math.sin(Math.toRadians(rotation))*speed;
					
			
		
		componentProperties.setRotation(rotation);
		componentProperties.setRotationSpeed(rotationSpeed);
		componentProperties.setPosX(posX);
		componentProperties.setPosY(posY);
		componentProperties.setSpeed(speed);
		
	}

}
