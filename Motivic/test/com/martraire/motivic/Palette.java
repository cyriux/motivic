package com.martraire.motivic;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A set of pitches, as a subset of a tuning system (typically a scale in a
 * given key), to select pitches from
 */
public class Palette {

	private final static int[] MAJOR_DEGREES = { 0, 2, 4, 5, 7, 9, 11 };

	private final static String[] NOTE_NAMES = { "C", "D", "E", "F", "G", "A", "B", };

	public static final Palette C_MAJOR = Palette.fromScale("C Major", MAJOR_DEGREES, 60);

	private String name;
	private final List<Pitch> pitches;

	public Palette(String name, List<Pitch> pitches) {
		this.name = name;
		this.pitches = pitches;
	}

	@Override
	public String toString() {
		return name + ": " + allPitches().map(p -> p.name).collect(Collectors.joining(" "));
	}

	public Stream<Pitch> allPitches() {
		return pitches.stream();
	}

	private static Palette fromScale(String name, int[] scaleDegrees, int keyMidiNote) {
		final List<Pitch> pitches = new ArrayList<>();
		for (int i = 0; i < scaleDegrees.length; i++) {
			final int degree = scaleDegrees[i];
			pitches.add(new Pitch(NOTE_NAMES[i], degree, keyMidiNote + degree, tonalHierarchy(i)));
		}
		return new Palette(name, pitches);
	}

	/**
	 * Calculates the rank in the tonal hierarchy, from strongest to weakest:
	 * tonic, tonic triad, diatonic, non-diatonic
	 *  
	 * @param degree
	 *            the degree of the pitch within its scale
	 * @return 3 for the tonic and 1 for diatonic pitches
	 */
	private final static int tonalHierarchy(int degree) {
		final int[] DEGREE_RANKS = { 0, 2, 1, 2, 1, 2, 2 };
		return 3 - DEGREE_RANKS[degree];
	}

}
