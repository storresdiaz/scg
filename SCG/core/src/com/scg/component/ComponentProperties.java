package com.scg.component;

import com.scg.entity.Entity;

public class ComponentProperties extends Component {
	
	private float posX = 0, posY = 0, velocity = 2, speed = 0, rotation = 0;
	private float goalX = 0, goalY = 0, centerX = 0, centerY = 0;
	private int width = 0, height = 0;
	private float maxSpeed = 80, maxRotationSpeed = 20;
	private float rotationSpeed = 0;

	private boolean isTalking;
	
	private ComponentSprite sprite;
	
	public ComponentProperties(Entity parentEntity) {
		super(parentEntity);
		
	}
	
	@Override
	public void update(float delta){
		
		if(sprite != null) {
		width = sprite.getTexture().getWidth();
		height = sprite.getTexture().getHeight();
		System.out.println("Width : "+ width+ " Height : "+height );
		System.out.println("---------------------------");
		}
		

		rotation = normalizeAngle(rotation);
		
		centerX = posX + width / 2;
		centerY = posY + height / 2;

		
	}
	
	@Override
	public void initialize() {
		 sprite = (ComponentSprite) super.parentEntity.findComponent(ComponentSprite.class);
	}
	
	public float normalizeAngle(float rotation) {
		rotation = rotation % 360;
		
	if (rotation < 0)
		{
		    rotation += 360;
	}
		
		return rotation;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public float getMaxRotationSpeed() {
		return maxRotationSpeed;
	}

	public void setMaxRotationSpeed(float maxRotationSpeed) {
		this.maxRotationSpeed = maxRotationSpeed;
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

	public boolean isTalking() {
		return isTalking;
	}

	public void setTalking(boolean isTalking) {
		this.isTalking = isTalking;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getCenterX() {
		return centerX;
	}

	public float getCenterY() {
		return centerY;
	}
	
	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}
	
	public void setCentery(float centerY) {
		this.centerY = centerY;
	}
	


	


}
