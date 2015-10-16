package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void testScoreOneAndFiveSixOut() {
		
		Frame frame = new Frame(1,5);
		
		assertEquals(6, frame.score());
		
	}
	
	@Test
	public void testScoreSixAndFourTenOut(){
		
		Frame frame = new Frame(6,4);
		
		assertEquals(10, frame.score());
	}
	
	@Test
	public void testScoreMinusFiveAndOneErrorNumberOut(){
		
		Frame frame = new Frame(-5,1);
		
		assertEquals(-1, frame.score());
	}

	@Test
	public void testSpareIsNotSpare(){
		
		Frame frame = new Frame(5,2);
		
		assertEquals(false, frame.isSpare());
	}
	
	@Test
	public void testSpareIsSpare(){
		
		Frame frame = new Frame(4,6);
		
		assertEquals(true, frame.isSpare());
	}
	
	@Test
	public void testBonusAdditionPlusFive(){
		
		Frame frame = new Frame(4,6);
		
		frame.addBonus(5);
		
		assertEquals(5, frame.bonus());
		
	}
	
	@Test
	public void testBonusAdditionMinusFiveShouldFail(){
		
		Frame frame = new Frame(4,6);
		frame.addBonus(-5);
		
		assertEquals(0, frame.bonus());
	}
	
	@Test
	public void testBonusAdditionPlusTenPlusFifteenFiveShouldFail(){
		
		Frame frame = new Frame(4,6);
		frame.addBonus(15);
		frame.addBonus(10);
		
		assertEquals(20, frame.bonus());
		
	}
	
}
