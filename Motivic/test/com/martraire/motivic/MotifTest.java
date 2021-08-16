package com.martraire.motivic;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class MotifTest {

	@Test
	public void test() {
		Palette palette = Palette.C_MAJOR;
		Grid grid = Grid.QUANTIZED_4_4;

		final List<Pitch> contour = palette.allPitches().limit(3).collect(Collectors.toList());
		final List<Pulse> rhythm = grid.allPulse().limit(3).collect(Collectors.toList());

		assertEquals("motif C:1 D:1. E:2", Motif.from("motif", contour, rhythm).toString());
	}

}
