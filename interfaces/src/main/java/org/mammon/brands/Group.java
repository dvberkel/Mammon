package org.mammon.brands;

import java.math.BigInteger;

import org.mammon.brands.rand.RandomGenerator;

/**
 * This interface can be used for generic typing, to bind classes of an actual
 * implementation compile-time.
 *
 * The group must comply to the requirements set out in the Brands scheme for
 * the group $G_{q}$ and may in particular be a subgroup of $\mathbb{Z}_p^*$.
 * where $q | (p-1)$.
 */
public interface Group<G extends Group<G>> {

	/**
	 * @return the identity element of this group.
	 */
	Element<G> getIdentity();

	/**
	 * @return the generator element of this group.
	 */
	Element<G> getGenerator();

	/**
	 * @return the number of elements in this group
	 */
	BigInteger getOrder();

	/**
	 * @param random
	 *            randomization source.
	 * @return a random element from this group.
	 */
	Element<G> getRandomElement(RandomGenerator randomGenerator);

	/**
	 * This interface represents an element from a group.
	 */
	interface Element<G> {

		/**
		 * @return the group this element belongs to.
		 */
		G getGroup();

		/**
		 * @return the inverse of this element.
		 */
		Element<G> getInverse();

		/**
		 * @param other
		 *            an element from the same group to multiply together.
		 * @return the product of this element and the other element.
		 */
		Element<G> multiply(Element<G> other);

		/**
		 * @param exponent
		 *            an element of $\mathbb{Z}_q$ to serve as exponent.
		 * @return the exponentiation of this element by the exponent.
		 */
		Element<G> exponentiate(BigInteger exponent);

	}

}
