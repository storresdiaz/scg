package com.scg.cutscene;

import java.util.ArrayList;

public class Cutscene {

	private ArrayList<CutsceneTask> tasks;
	
	public Cutscene() {
		tasks = new ArrayList<>();
		
	}

	public ArrayList<CutsceneTask> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<CutsceneTask> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask(CutsceneTask cutsceneTask) {
		tasks.add(cutsceneTask);
	}
	
	
	
}
