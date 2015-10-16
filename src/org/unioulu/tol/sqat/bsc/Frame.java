package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	private int bonusScore;
	private int totalScore;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		
		totalScore = firstThrow + secondThrow;
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
		//to be implemented
		return false;
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
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		
		return bonusScore;
	}

	public void addBonus(int bonus) {
		bonusScore +=bonus;
		
	}
}
