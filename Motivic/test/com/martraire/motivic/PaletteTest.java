package com.martraire.motivic;


import static org.junit.Assert.assertEquals;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class PaletteTest {

	final Collector<CharSequence, ?, String> JOIN = Collectors.joining(" ");
	
	@Test
	public void test_CMajor() {
		Palette palette = Palette.C_MAJOR;
		assertEquals("C Major: C D E F G A B", palette.toString());
		assertEquals("3 1 2 1 2 1 1", palette.allPitches().map(p -> "" + p.rank()).collect(JOIN));
		assertEquals("0 2 4 5 7 9 11", palette.allPitches().map(p -> "" + p.degree()).collect(JOIN));
		assertEquals("60 62 64 65 67 69 71", palette.allPitches().map(p -> "" + p.midiNumber()).collect(JOIN));
	}

}
