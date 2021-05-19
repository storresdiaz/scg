package com.scg.cutscene;

import java.util.ArrayList;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class CutsceneInterpreter {
	
	private int scenePosition, sceneEndPosition;
	private ArrayList<CutsceneTask> tasks;
	
	public CutsceneInterpreter() {
		tasks = new ArrayList<>();
	}
	
	public void Play(Cutscene cutscene){
	
		tasks = cutscene.getTasks();
		scenePosition = 0;
		sceneEndPosition = tasks.size();
		playNextScene(tasks);
		
	}
	
	public void Stop() {
		tasks.clear();
		scenePosition = 0;
		sceneEndPosition = 0;
	}
	
	public void playNextScene(ArrayList<CutsceneTask> tasks) {
		
	if(scenePosition < sceneEndPosition) {
		if(tasks.get(scenePosition).getClass().isAssignableFrom(CutsceneTaskSleep.class)) {
			
			CutsceneTaskSleep sleepTask = (CutsceneTaskSleep) tasks.get(scenePosition);
			sleepTask.play();
			
			Timer.schedule(new Task() {

				@Override
				public void run() {
					
					notifyTaskChange();
					
				}
				
			}, sleepTask.getDelay());
			
		}
		else {
			try {
			tasks.get(scenePosition).play();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			notifyTaskChange();
			}
		
		}
	else {
		Stop();
	}
		
	}
	
	public void notifyTaskChange() {
		scenePosition++;
		playNextScene(tasks);
	}

}
