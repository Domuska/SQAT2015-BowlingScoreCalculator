package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	//TESTS FOR THE FRAME
	
	@Test
	public void testFrameScoreOneAndFiveSixOut() {
		
		Frame frame = new Frame(1,5);
		
		assertEquals(6, frame.score());
		
	}
	
	@Test
	public void testFrameScoreSixAndFourTenOut(){
		
		Frame frame = new Frame(6,4);
		
		assertEquals(10, frame.score());
	}
	
	@Test
	public void testFrameScoreMinusFiveAndOneErrorNumberOut(){
		
		Frame frame = new Frame(-5,1);
		
		assertEquals(-1, frame.score());
	}

	@Test
	public void testFrameSpareIsNotSpare(){
		
		Frame frame = new Frame(5,2);
		
		assertEquals(false, frame.isSpare());
	}
	
	@Test
	public void testFrameSpareIsSpare(){
		
		Frame frame = new Frame(4,6);
		
		assertEquals(true, frame.isSpare());
	}
	
	@Test
	public void testFrameBonusAdditionPlusFive(){
		
		Frame frame = new Frame(4,6);
		
		frame.addBonus(5);
		
		assertEquals(5, frame.bonus());
		
	}
	
	@Test
	public void testFrameBonusAdditionMinusFiveShouldFail(){
		
		Frame frame = new Frame(4,6);
		frame.addBonus(-5);
		
		assertEquals(0, frame.bonus());
	}
	
	@Test
	public void testFrameBonusAdditionPlusTenPlusFifteenFiveShouldFail(){
		
		Frame frame = new Frame(4,6);
		frame.addBonus(15);
		frame.addBonus(10);
		
		assertEquals(20, frame.bonus());
		
	}
	
	@Test
	public void testFrameStrikeShouldBeTrue(){
		
		Frame frame = new Frame(10,0);
		
		assertEquals(true, frame.isStrike());
	}
	
	@Test
	public void testFrameStrikeShouldBeFalse(){
		
		Frame frame = new Frame(6,4);
		
		assertEquals(false, frame.isStrike());
	}
	
	@Test
	public void testFrameIsLastFrameShouldBeTrue(){
		
		Frame frame = new Frame(6,4);
		
		frame.setAsLastFrame();
		
		assertEquals(true, frame.isLastFrame());
		
	}
	
	@Test
	public void testFrameIsLastFrameShouldBeFalse(){
		
		Frame frame = new Frame(6,4);
		
		assertEquals(false, frame.isLastFrame());
	}
	
	
	//TESTS FOR THE BOWLINGGAME
	
	@Test
	public void testBowlingGameAddOneFrameAndScoreFour(){
		
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1,3);
		
		game.addFrame(frame);
		
		assertEquals(4, game.score());
	}
	
	@Test
	public void testBowlingGameAddOneFrameAndScoreNine(){
		
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(4,5);
		
		game.addFrame(frame);
		
		assertEquals(9, game.score());
	}
	
	@Test
	public void testBowlingGameAddThreeFramesTotalScore25(){
		
		BowlingGame game = new BowlingGame();
		Frame frame1 = new Frame(4,5);
		Frame frame2 = new Frame(5,4);
		Frame frame3 = new Frame(7,0);
		
		game.addFrame(frame1);
		game.addFrame(frame2);
		game.addFrame(frame3);
		
		assertEquals(25, game.score());
		
	}
}
