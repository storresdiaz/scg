package com.scg.entity;

import java.util.ArrayList;
import java.util.Iterator;

import com.scg.component.Component;

public class Entity {
	
	private ArrayList<Component> components;
	private String entityID;
	
	public Entity(String entityID) {
		this.entityID = entityID;
		components = new ArrayList<>();
		
		
	}
	
	public void initialize() {
		for(Component component: components) {
			component.initialize();
		}
	}
	
	public void render(){
		
		for(Component component: components) {
			if(component.isEnabled()) {
			component.render();
			}
		}
		
	}
	
	public void update(float delta) {
		
		for(Component component: components) {
			if(component.isEnabled()) {
			component.update(delta);
			}
		}
		
	}

	public ArrayList<Component> getComponents(){
		return components;
	}
	
	public Component findComponent(Class<? extends Component> type ) {
		
		for(Component component: components) {
			if(component.getClass().isAssignableFrom(type)){
				return component;
			}
		}
	
		System.out.println("No component of type found");
		return null;
		
	}
	
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	
	public String getEntityID() {
		return entityID;
	}
	
	public void addComponent(Component component) {
		this.components.add(component);
	}
	
	public void removeComponent(Class<? extends Component> type) {
		for(Iterator<Component> componentIter = components.iterator(); componentIter.hasNext();) {
			Component component = componentIter.next();
			if(component.getClass().isAssignableFrom(type)) {
				componentIter.remove();
			}
		}
	}
	
}
