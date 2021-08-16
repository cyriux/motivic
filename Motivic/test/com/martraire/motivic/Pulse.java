package com.martraire.motivic;

/**
 * A pulse within a grid (typically a meter)
 */
public class Pulse {

	private final int rank;
	private String name;
	private int midiTick;

	public Pulse(String name, int midiTick, int rank) {
		this.name = name;
		this.midiTick = midiTick;
		this.rank = rank;
	}

	public String name() {
		return name;
	}

	public int midiTick() {
		return midiTick;
	}

	public int rank() {
		return rank;
	}

}
