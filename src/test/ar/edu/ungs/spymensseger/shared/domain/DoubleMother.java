package ar.edu.ungs.spymensseger.shared.domain;

import java.util.Random;

public final class DoubleMother {
	public static Double random(Double min, Double max) {
		return min + (max - min) * new Random().nextDouble();
	}
}
