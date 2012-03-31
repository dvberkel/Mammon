package org.mammon.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ZElementTest {

	private FiniteField<Z> field;
	private FiniteField.Element<Z> zero;
	private FiniteField.Element<Z> one;

	@Before
	public void createFiniteField() {
		field = new Z(11);
		zero = field.getZero();
		one = field.getOne();
	}

	public void zeroShouldDifferFromOne() {
		assertFalse(one.equals(zero));
	}

	@Test
	public void zeroShouldBeIdentityForAddition() {
		assertEquals(zero, zero.add(zero));
		assertEquals(one, one.add(zero));
	}

	@Test
	public void oneShouldBeIdentityForMulitplication() {
		assertEquals(zero, zero.multiply(one));
		assertEquals(one, one.multiply(one));
	}

	@Test
	public void oppositesShouldSumToZero() {
		for (FiniteField.Element<Z> element : new FiniteField.Element[] { zero, one }) {
			assertEquals(zero, element.add(element.getOpposite()));
		}
	}

	@Test
	public void inversesShouldMultiplyToOne() {
		for (FiniteField.Element<Z> element : new FiniteField.Element[] { one }) {
			assertEquals(one, element.multiply(element.getInverse()));
		}
	}

	@Test
	public void additionShouldHaveOrderQ() {
		FiniteField.Element<Z> result = zero;
		for (int i = 0; i < 11; i++) {
			result = result.add(one);
		}
		assertEquals(zero, result);
	}

	@Test
	public void mulitplicationShouldHaveOrderTotientQ() {
		FiniteField.Element<Z> result = one;
		FiniteField.Element<Z> generator = ((Z) field).element(2);
		for (int i = 0; i < 10; i++) {
			result = result.multiply(generator);
		}
		assertEquals(one, result);
	}
}
