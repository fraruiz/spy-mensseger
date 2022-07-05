package ar.edu.ungs.communications.domain;

public final class InvalidProbability extends RuntimeException {
	public InvalidProbability(Double value) {
		super(String.format("the probability <%s> must be between 0 and 1", value));
	}
}
