package com.scg.sript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.scg.cutscene.Cutscene;
import com.scg.cutscene.CutsceneTaskAddComponent;
import com.scg.cutscene.CutsceneTaskLockCamera;
import com.scg.cutscene.CutsceneTaskMove;
import com.scg.cutscene.CutsceneTaskMoveCamera;
import com.scg.cutscene.CutsceneTaskPlaySound;
import com.scg.cutscene.CutsceneTaskRemoveComponent;
import com.scg.cutscene.CutsceneTaskSleep;
import com.scg.cutscene.CutsceneTaskText;
import com.scg.cutscene.CutsceneTaskTransitionImage;

public class ScriptReader {

	private Scanner scanner;
	
	/* To create a playable cutscene, use this to load a file path into a supplied cutscene
	 * then use CutsceneInterpreter to play the loaded cutscene
	 */

	
	public ScriptReader() {
		
	}
	
	public void loadCutscene(String filePath, Cutscene cutscene) {
		FileHandle fileHandle = Gdx.files.internal(filePath);
		scanner = new Scanner(fileHandle.read());
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] commands = line.split(" ");
			interpretCommand(commands, cutscene);
		}
		
	}
	
	public void interpretCommand(String[] commands, Cutscene cutscene) {
		String command = commands[0];
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(commands));
		list.remove(0);
		String[] arguments = new String[list.size()];
		arguments = list.toArray(arguments);
		
		
		switch(command) {
			case "MOVE":
				// MOVE ID GOALX GOALY
				CutsceneTaskMove taskMove = new CutsceneTaskMove(arguments[0]);
				taskMove.setup(Float.parseFloat(arguments[1]), Float.parseFloat(arguments[2]));
				taskMove.initialize();
				cutscene.addTask(taskMove);
				break;
			case "SLEEP":
				// SLEEP INT (Seconds)
				CutsceneTaskSleep taskSleep = new CutsceneTaskSleep(arguments[0]);
				taskSleep.setup(Integer.parseInt(arguments[0]));;
				taskSleep.initialize();
				cutscene.addTask(taskSleep);
				break;
			case "MOVE-CAMERA":
				// MOVE-CAMERA GOALX GOALY
				CutsceneTaskMoveCamera taskMoveCamera = new CutsceneTaskMoveCamera(arguments[0]);
				taskMoveCamera.setup(Float.parseFloat(arguments[0]), Float.parseFloat(arguments[1]));
				taskMoveCamera.initialize();
				cutscene.addTask(taskMoveCamera);
				break;
			case "LOCK-CAMERA":
				// LOCK-CAMERA entityID
				CutsceneTaskLockCamera lockCamera = new CutsceneTaskLockCamera(arguments[0]);
				lockCamera.setup();
				lockCamera.initialize();
				cutscene.addTask(lockCamera);
				break;
			case "TEXT":
				// TEXT helperID, delay, STRING - Keep in one line
				CutsceneTaskText taskText = new CutsceneTaskText(arguments[0]);
				taskText.initialize();
				StringBuilder builder = new StringBuilder();
				for(int i = 2; i < arguments.length; i++) {
					builder.append(" "+arguments[i]);
				}
				taskText.setup(arguments[0], Float.parseFloat(arguments[1]), builder.toString());
				cutscene.addTask(taskText);
				break;
			case "TRANSITION-IMAGE":
				// TRANSITION-IMAGE helperID filePath delay
				CutsceneTaskTransitionImage taskTransitionImage = new CutsceneTaskTransitionImage(arguments[0]);
				taskTransitionImage.initialize();
				taskTransitionImage.setup(arguments[0], arguments[1], Float.parseFloat(arguments[2]));
				cutscene.addTask(taskTransitionImage);
				break;
			case "PLAY-SOUND":
				// PLAY-SOUND filePath
				CutsceneTaskPlaySound taskPlaySound = new CutsceneTaskPlaySound(arguments[0]);
				taskPlaySound.initialize();
				taskPlaySound.setup(arguments[0]);
				cutscene.addTask(taskPlaySound);
				break;
			case "ADD-COMPONENT":
				// ADD-COMPONENT focusEntity component
				CutsceneTaskAddComponent taskAddComponent = new CutsceneTaskAddComponent(arguments[0]);
				taskAddComponent.initialize();
				taskAddComponent.setup(arguments[1]);
				cutscene.addTask(taskAddComponent);
				break;
			case "REMOVE-COMPONENT":
				// REMOVE-COMPONENT focusEntity component
				CutsceneTaskRemoveComponent taskRemoveComponent = new CutsceneTaskRemoveComponent(arguments[0]);
				taskRemoveComponent.initialize();
				taskRemoveComponent.setup(arguments[1]);
				cutscene.addTask(taskRemoveComponent);
				break;
		}
		
		
		
		
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
}
