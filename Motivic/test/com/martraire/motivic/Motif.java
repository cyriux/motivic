package com.martraire.motivic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String toString() {
		return name + " " + notes.stream().map(n -> n.toString()).collect(Collectors.joining(" "));
	}
}
