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
	
	@Test
	public void testBowlingGameAddThreeFramesOneWithSpareTotalScore32(){
		BowlingGame game = new BowlingGame();
		Frame frame1 = new Frame(4,2);
		Frame frame2 = new Frame(5,5);
		Frame frame3 = new Frame(8,0);
		
		game.addFrame(frame1);
		game.addFrame(frame2);
		game.addFrame(frame3);
		
		assertEquals(32, game.score());
	}
	
	//lis‰t‰‰n yli 11 framea
	@Test
	public void testBowlingGameAddElevenRoundsOnlyTenShouldBeAdded(){
		BowlingGame game = new BowlingGame();
		
		initializeGameNineGamesIn(game);
		
		Frame frame10 = new Frame(0,5);
		Frame frame11 = new Frame(2,2);
		
		game.addFrame(frame10);
		game.addFrame(frame11);
		
		
		assertEquals(70, game.score());
		
	}
	
	@Test
	public void testBowlingGameAddTenRoundsAndBonusSpareScoreAt80(){
		
		BowlingGame game = new BowlingGame();
		
		initializeGameNineGamesIn(game);
		
		Frame frame10 = new Frame(5,5);
		
		
		game.addFrame(frame10);
		game.setBonus(5, 0);
		
		assertEquals(80, game.score());
	}
	
	@Test
	public void testBowlingGameAddTenRoundsAndBonusSpareScoreAt90(){
		
		BowlingGame game = new BowlingGame();
		
		initializeGameNineGamesIn(game);
		
		Frame frame10 = new Frame(5,5);
		
		
		game.addFrame(frame10);
		game.setBonus(10, 0);
		
		assertEquals(90, game.score());
	}
	
	
	/*@Test
	public void testBowlingGameAddTenRoundsAndBonusSpareScoreAddTooManyBallsToBonus(){
		
		BowlingGame game = new BowlingGame();
		
		initializeGameNineGamesIn(game);
		
		Frame frame10 = new Frame(5,5);
		
		
		game.addFrame(frame10);
		game.setBonus(5, 5);
		
		assertEquals(80, game.score());
	}*/
	
	
	private void initializeGameNineGamesIn(BowlingGame game){
		
		Frame frame1 = new Frame(4,2);
		Frame frame2 = new Frame(5,5);
		Frame frame3 = new Frame(8,0);
		Frame frame4 = new Frame(0,0);
		Frame frame5 = new Frame(0,0);
		Frame frame6 = new Frame(2,2);
		Frame frame7 = new Frame(5,5);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(1,5);   //score 65
		
		game.addFrame(frame1);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);
	}
	
}
