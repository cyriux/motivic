package com.martraire.motivic;


/**
 * A pulse within a grid (typically a meter)
 */
public class Pulse {

	private final int rank;

	public Pulse(int rank) {
		this.rank = rank;
	}

	public int rank() {
		return rank;
	}

}
