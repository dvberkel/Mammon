package org.mammon.sandbox;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.mammon.brands.rand.RandomGenerator;

public class SecureRandomGenerator implements RandomGenerator {

	public SecureRandomGenerator(SecureRandom random) {
	}

	@Override
	public BigInteger bigInteger(BigInteger maximum) {
		return null;
	}

}
