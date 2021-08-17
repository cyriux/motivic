package com.martraire.motivic;

/**
 * A pulse within a grid (typically a meter)
 */
public class Pulse {

	private final String name;
	private final int position;
	private final int midiTick;
	private final int rank;

	public static final Pulse NONE = new Pulse("-", 0, 0, 0);

	public Pulse(String name, int position, int midiTick, int rank) {
		this.name = name;
		this.position = position;
		this.midiTick = midiTick;
		this.rank = rank;
	}

	public String name() {
		return name;
	}

	public int position() {
		return position;
	}

	public int midiTick() {
		return midiTick;
	}

	public int rank() {
		return rank;
	}

	public boolean isNone() {
		return this == NONE;
	}

	@Override
	public int hashCode() {
		return position + midiTick ^ name.hashCode() + rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		final Pulse other = (Pulse) obj;
		return position == other.position && midiTick == other.midiTick && name.equals(other.name)
				&& rank == other.rank;
	}

	public String toString() {
		return name + " " + position + " (" + midiTick + ") " + " rank: " + rank;
	}
}
