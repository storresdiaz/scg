package com.scg.entity;

import java.util.ArrayList;

public class EntityHolder {
	
	private static ArrayList<Entity> entities = new ArrayList<>();
	
	public static void render() {
		for(Entity entity: entities) {
			entity.render();
		}
	}
	
	public static void update(float delta) {
		for(Entity entity: entities) {
			entity.update(delta);
		}
	}

	public static ArrayList<Entity> getEntities() {
		return entities;
	}

	public static void setEntities(ArrayList<Entity> entities) {
		EntityHolder.entities = entities;
	}
	
	public static void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public static Entity findEntity(String entityID) {
		
		for(Entity entity: entities) {
			if(entity.getEntityID().equals(entityID)) {
				return entity;
			}
		}
		
		return null;
	}

}
