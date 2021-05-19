package com.scg.cutscene;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelperHolder {
	
	public static ArrayList<Helper> helpers = new ArrayList<>();
	private static SpriteBatch spriteBatch = new SpriteBatch();

	
	public static void render() {
		
		
		for(Helper helper: helpers) {
			helper.render();
		}
		
	}
	
	public static void update() {
		
		for(Helper helper: helpers) {
			helper.render();
		}
		
	}
	
	public static Helper findHelper(String helperID) {
		for(Helper helper: helpers) {
			if(helper.getHelperID().equals(helperID)) {
				return helper;
			}
		}
		
		return null;
	}
	
	public static void addHelper(Helper helper) {
		helpers.add(helper);
	}
	public static void removeHelper(String helperID) {
		for(int i = 0; i < helpers.size(); i++) {
			if(helpers.get(i).getHelperID().equals(helperID)) {
				helpers.remove(i);
			}
		}
	}

	public static SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	public void setSpriteBatch(SpriteBatch spriteBatch) {
		HelperHolder.spriteBatch = spriteBatch;
	}
	

}
