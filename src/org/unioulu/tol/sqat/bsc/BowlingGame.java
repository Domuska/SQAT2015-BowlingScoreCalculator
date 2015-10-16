package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		
		if(frames.size() <= 9)
			frames.add(frame);
	}
	
	// a bonus frame after the 10th frame
	public void setBonus(int firstThrow, int secondThrow) {
		
		if((frames.get(frames.size()-1).getFirstThrowScore() == 10))
				bonus = new Frame(firstThrow,secondThrow);
		else
			bonus = new Frame(firstThrow, 0);
	}
	
	public int score(){
		
		int totalScore = 0;
		int frameScore;
		
		this.updateBonusScores();
		
		for(int i = 0; i < frames.size(); i++){
			
			frameScore = frames.get(i).score();
			frameScore += frames.get(i).bonus();
			
			
			
			totalScore += frameScore;
		}
		
		if(bonus != null)
			totalScore += bonus.score();
		
		return totalScore;
	}
	
	
	public boolean isNextFrameBonus(){
		//to be implemented ...?
		return false;
	}
	
	private void updateBonusScores(){
		
		for(int i = 0; i < frames.size(); i++){
			
			if(frames.get(i).score() == 10){
				
				Frame frame = frames.get(i);
				
				if(i != frames.size()-1){
				
					if(frame.getFirstThrowScore()== 10){
						frame.addBonus(frames.get(i+1).getFirstThrowScore() 
								+ frames.get(i+1).getSecondThrowScore());
					}
					else{
						frame.addBonus(frames.get(i+1).getFirstThrowScore());
					}
				}
			}
		}
	}
}
