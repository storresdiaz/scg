package com.scg.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.scg.component.ComponentProperties;

public class CameraHolder {
	
	public static OrthographicCamera cameraGame = new OrthographicCamera();
	public static OrthographicCamera cameraOverlay= new OrthographicCamera();
	public static OrthographicCamera cameraBackground = new OrthographicCamera();
	public static StretchViewport viewportGame = new StretchViewport(1920, 1080);
	public static StretchViewport viewportOverlay = new StretchViewport(1920, 1080);
	public static StretchViewport viewportBackground = new StretchViewport(1920, 1080);
	public static SpriteBatch spriteBatch = new SpriteBatch();
	public static SpriteBatch spriteBatchOverlay = new SpriteBatch();
	public static SpriteBatch spriteBatchBackground = new SpriteBatch();
	
	private static Vector3 lerpPosition = new Vector3();
	
	private static ComponentProperties lockEntityProperties;
	
	public static float delta;
	
	public static void update(float delta) {
		
		spriteBatch.setProjectionMatrix(cameraGame.combined);
		spriteBatchOverlay.setProjectionMatrix(cameraOverlay.combined);
		spriteBatchBackground.setProjectionMatrix(cameraBackground.combined);
		
		if(lockEntityProperties != null) {
			float posX = lockEntityProperties.getPosX();
			float posY = lockEntityProperties.getPosY();
			float width = lockEntityProperties.getWidth();
			float height = lockEntityProperties.getHeight();
			lerpPosition.set(posX+width/2, posY+height/2 , 0);
		}
		
		cameraGame.position.set(cameraGame.position.lerp(lerpPosition, 0.1f));
		
		cameraGame.update();
		cameraOverlay.update();
		cameraBackground.update();
		
		CameraHolder.delta = delta;
	}
	
	public static void setup() {
		cameraGame.setToOrtho(false, 1920, 1080);
		cameraGame.position.set(-10000, -10000, 0);
		cameraOverlay.setToOrtho(false, 1920, 1080);
		cameraOverlay.position.set(0, 0, 0);
		cameraBackground.setToOrtho(false, 1920, 1080);
		cameraBackground.position.set(0,0,0);
		viewportGame.setCamera(cameraGame);
		viewportGame.apply();
		viewportOverlay.setCamera(cameraOverlay);
		viewportOverlay.apply();
		viewportBackground.setCamera(cameraBackground);
		viewportBackground.apply();
	}
	
	public static void render() {
		
	}
	
	public static void updateViewport(int screenWidth, int screenHeight) {
		viewportGame.update(screenWidth, screenHeight);
		viewportOverlay.update(screenWidth, screenHeight);
		viewportBackground.update(screenWidth, screenHeight);
	}
	
	public static void setLerpPosition(Vector3 vector) {
		CameraHolder.lerpPosition = vector;
	}
	
	public static Vector3 getLerpPosition() {
		return lerpPosition;
	}

	public static ComponentProperties getLockEntityProperties() {
		return lockEntityProperties;
	}

	public static void setLockEntityProperties(ComponentProperties lockEntityProperties) {
		CameraHolder.lockEntityProperties = lockEntityProperties;
	}

	public static SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	public static void setSpriteBatch(SpriteBatch spriteBatch) {
		CameraHolder.spriteBatch = spriteBatch;
	}
	

}
