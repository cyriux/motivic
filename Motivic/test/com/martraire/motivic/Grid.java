package com.martraire.motivic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A set of pulses, as a temporal grid (typically a meter), to put musical
 * events into.
 */
public class Grid {

	public static final Grid QUANTIZED_4_4 = flatMeter("4/4 Quantized", 4, 8);

	private final String name;
	private final List<Pulse> pulses;

	public Grid(String name, List<Pulse> pulses) {
		this.name = name;
		this.pulses = pulses;
	}

	private static Grid flatMeter(String name, int beatsCount, int pulsesCount) {
		final List<Pulse> pulses = new ArrayList<>();
		int n = (int) (Math.log(pulsesCount) / Math.log(2));
		for (int i = 0; i < pulsesCount; i++) {
			int rank = pulseStrengh(n, i);
			String beatName = beatName(i, beatsCount, pulsesCount);
			int midiTick = midiTick(beatsCount, pulsesCount, i);
			pulses.add(new Pulse(beatName, midiTick, rank));
		}
		return new Grid(name, pulses);
	}

	private static String beatName(int i, int beatsCount, int pulsesCount) {
		int multiple = pulsesCount / beatsCount;
		return "" + (i / multiple);
	}

	private static int midiTick(int beatsCount, int pulsesCount, int i) {
		// midi clock is 24 ticks PQN (Per Quarter Note)
		return i * 24 * beatsCount / pulsesCount;
	}

	/**
	 * The rank is the strength of each pulse ("beat" in the literature),
	 * calculated from the dot diagram of the nested metrical levels of accented
	 * and unaccented beats.
	 * 
	 * @See Lerdahl and Jackendoff GTTM 1983
	 * 
	 * @param depth
	 *            the max strength, typically the LOG(2) of the number of pulses
	 * @param pulse
	 *            the N-th pulse
	 */
	private static int pulseStrengh(int depth, int pulse) {
		int rank = pulse == 0 ? 1 : 0;
		for (int j = 0; j < depth; j++) {
			int modulo = (int) Math.pow(2, j);
			rank += (pulse % modulo == 0) ? 1 : 0;
		}
		return rank - 1;
	}

	public Stream<Pulse> allPulse() {
		return pulses.stream();
	}

	@Override
	public String toString() {
		return name;
	}
}
