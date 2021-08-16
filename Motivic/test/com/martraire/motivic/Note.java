package com.martraire.motivic;

/**
 * A melodic element, itself made of a pitch from a palette and a pulse from a
 * grid
 */
public class Note {

	private final Pitch pitch;
	private final Pulse pulse;

	public Note(Pitch pitch, Pulse pulse) {
		this.pitch = pitch;
		this.pulse = pulse;
	}

	public int rank() {
		return pitch.rank() + pulse.rank();
	}

	@Override
	public String toString() {
		return pitch.name + ":" + pulse.name();
	}
}
