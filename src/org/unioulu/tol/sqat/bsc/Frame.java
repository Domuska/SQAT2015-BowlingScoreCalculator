package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	private int bonusScore;
	private int totalScore;
	private boolean isStrike;
	private boolean isLastFrame;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		
		totalScore = firstThrow + secondThrow;
		isStrike = false;
		isLastFrame = false;
		
		if(firstThrow == 10)
			isStrike = true;
	}
	
	//the score of a single frame
	public int score(){
		
		if(totalScore < 0)
			return -1;
		else
			return firstThrow + secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		
		return isStrike;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		
		if(totalScore == 10)
			return true;
		else
			return false;

	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		
		return isLastFrame;
	}

	//bonus throws
	public int bonus(){
		
		return bonusScore;
	}
	
	public int getFirstThrowScore(){
		return firstThrow;
	}
	
	public int getSecondThrowScore(){
		return secondThrow;
	}

	public void addBonus(int bonus) {
		if(bonus > 0){
			
			if((bonusScore + bonus) < 20)
				bonusScore +=bonus;
			else
				bonusScore = 20;
		}
	}

	public void setAsLastFrame() {
		
		isLastFrame = true;
	}
}
