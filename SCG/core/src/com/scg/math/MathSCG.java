package com.scg.math;

public class MathSCG {
	
	public static final float getDistanceBetween(float posX, float goalX, float posY, float goalY) {
		float dist = (float) Math.hypot(posX-goalX, posY-goalY);;
		return dist;
	}
	
	public static final float getDistanceBetweenInPercent(float distance, float limiter) {
		
		
		if(distance > 100) {
			distance = 100;
		}
		
		distance = distance % 100;
		
		if(distance <= 0) {
			distance += 100;
		}
		
		if(distance / 100 < limiter) {
			return limiter;
		}
		else {
			distance = distance/100;
		}
		
		return distance;
	}

}
