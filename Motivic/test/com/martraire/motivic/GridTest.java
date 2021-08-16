package com.martraire.motivic;


import static org.junit.Assert.assertEquals;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class GridTest {

	final Collector<CharSequence, ?, String> JOIN = Collectors.joining(" ");

	@Test
	public void test_4_NoGroove() {
		Grid grid = Grid.QUANTIZED_4_4;
		assertEquals("4/4 Quantized", grid.toString());
		assertEquals("3 0 1 0 2 0 1 0", grid.allPulse().map(p -> "" + p.rank()).collect(JOIN));
	}

}
