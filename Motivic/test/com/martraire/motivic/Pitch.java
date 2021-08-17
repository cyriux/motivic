package com.martraire.motivic;

/**
 * A pitch within a palette (a subset of a tuning system, typically a scale in a
 * given key)
 */
public class Pitch {
	private final String name;
	private final int degree;
	private final int midiNumber;
	private final int rank;

	public static final Pitch NONE = new Pitch("-", 0, 0, 0);

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

	public boolean isNone() {
		return this == NONE;
	}

	@Override
	public int hashCode() {
		return degree + midiNumber ^ name.hashCode() + rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		final Pitch other = (Pitch) obj;
		return degree == other.degree && midiNumber == other.midiNumber && name.equals(other.name)
				&& rank == other.rank;
	}

	public String toString() {
		return name + degree + " (" + midiNumber + ") " + " rank: " + rank;
	}
}