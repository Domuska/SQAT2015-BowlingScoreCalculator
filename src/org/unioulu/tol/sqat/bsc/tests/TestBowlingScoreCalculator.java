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

	
	
}
