package com.scg.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.scg.camera.CameraHolder;
import com.scg.entity.Entity;

public class ComponentSprite extends Component {
	
	@SuppressWarnings("unused")
	private Texture texture, debug_pointer;
	private SpriteBatch spriteBatch;
	private ComponentProperties componentProperties;

	public ComponentSprite(Entity parentEntity) {
		super(parentEntity);
		debug_pointer = new Texture(Gdx.files.internal("assets/images/UI/debug_pointer.png"));
		this.spriteBatch = CameraHolder.spriteBatch;
	}
	
	@Override
	public void initialize() {
		componentProperties = (ComponentProperties) super.parentEntity.findComponent(ComponentProperties.class);
	}
	
	public void render() {
		
		float posX = componentProperties.getPosX();
		float posY = componentProperties.getPosY();
		@SuppressWarnings("unused")
		float goalX = componentProperties.getGoalX();
		@SuppressWarnings("unused")
		float goalY = componentProperties.getGoalY();
		float rotation = componentProperties.getRotation();
		int width = texture.getWidth();
		int height = texture.getHeight();
		
		spriteBatch.begin();
			spriteBatch.draw(texture, posX, posY, width/2, height/2, width, height, 1, 1, rotation, 0, 0, width, height, false, false);
			// spriteBatch.draw(debug_pointer, goalX, goalY);
		spriteBatch.end();
		
	}
	
	public void update(float delta) {
		
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(String filePath) {
		texture = new Texture(Gdx.files.internal(filePath));
	}

}
