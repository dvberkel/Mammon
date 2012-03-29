package org.mammon.sandbox;

import java.math.BigInteger;

import org.mammon.brands.rand.RandomGenerator;

public class ExampleRandomGenerator implements RandomGenerator {

	@Override
	public BigInteger bigInteger(BigInteger maximum) {
		return BigInteger.valueOf(37); // I threw a D100 and got 37
	}

}
