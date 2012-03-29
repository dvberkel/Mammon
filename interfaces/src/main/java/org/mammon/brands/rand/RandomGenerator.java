package org.mammon.brands.rand;

import java.math.BigInteger;

public interface RandomGenerator {

	/**
	 * @param maximum the upper bound
	 * @return an BigInteger between 0 (inclusive) to maximum (exclusive)
	 */
	BigInteger bigInteger(BigInteger maximum);

}
