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

	public Pitch pitch() {
		return pitch;
	}

	public Pulse pulse() {
		return pulse;
	}

	public int rank() {
		return pitch.rank() + pulse.rank();
	}

	public Interval intervalFrom(Note previous) {
		return new Interval(pitch.degree() - previous.pitch.degree());
	}

	public Duration durationFrom(Note previous) {
		return new Duration(pulse.position() - previous.pulse.position());
	}

	@Override
	public String toString() {
		return pitch.name() + ":" + pulse.name();
	}

}
