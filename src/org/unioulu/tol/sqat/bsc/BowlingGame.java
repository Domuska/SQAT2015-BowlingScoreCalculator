package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
		
		
	}
	
	// a bonus frame after the 10th frame
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		
		int totalScore = 0;
		int frameScore;
		
		for(int i = 0; i < frames.size(); i++){
			
			frameScore = frames.get(i).score();
			
			if(frameScore == 10){
				
				frameScore += frames.get(i+1).bonus();
			}
			
			
			totalScore += frameScore;
		}
		
		return totalScore;
	}
	
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
	
	private void updateBonusScores(){
		
		for(int i = 0; i < frames.size(); i++){
			
			
			if(frames.get(i).score() == 10){
				Frame frame = frames.get(i);
				frame.addBonus(frames.get(i+1).getFirstThrowScore());
			}
		}
	}
}
