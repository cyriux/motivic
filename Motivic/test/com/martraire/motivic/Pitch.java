package com.martraire.motivic;


/**
 * A pitch within a palette (a subset of a tuning system, typically a scale in a
 * given key)
 */
public class Pitch {
	final String name;
	private final int degree;
	private final int midiNumber;
	private final int rank;

	public Pitch(String name, int degree, int midiNumber, int rank) {
		this.name = name;
		this.degree = degree;
		this.midiNumber = midiNumber;
		this.rank = rank;
	}

	public String name() {
		return name;
	}

	public int degree() {
		return degree;
	}

	public int midiNumber() {
		return midiNumber;
	}

	public int rank() {
		return rank;
	}

	public String toString() {
		return name + degree + " (" + midiNumber + ") " + " rank: " + rank;
	}
}