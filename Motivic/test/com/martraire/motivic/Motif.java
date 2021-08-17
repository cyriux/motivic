package com.martraire.motivic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A short sequence of notes, made of a pitch on a pulse; if there's no pitch
 * it's a rhythm, if there's no pulse it's just a melodic contour.
 * 
 * A motif can also be viewed as a succession of intervals and durations.
 */
public class Motif {

	private String name;
	private final List<Note> notes;

	public Motif(String name, List<Note> notes) {
		this.name = name;
		this.notes = notes;
	}

	public static Motif from(String name, List<Pitch> contour, List<Pulse> rhythm) {
		final List<Note> notes = new ArrayList<>();
		final int size = Math.max(contour.size(), rhythm.size());
		for (int i = 0; i < size; i++) {
			notes.add(new Note(contour.get(i), rhythm.get(i)));
		}
		return new Motif(name, notes);
	}

	public Stream<Note> allNotes() {
		return notes.stream();
	}

	@Override
	public String toString() {
		return name + " " + notes.stream().map(n -> n.toString()).collect(Collectors.joining(" "));
	}

}
