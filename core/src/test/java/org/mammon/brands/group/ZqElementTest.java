package org.mammon.brands.group;

import static org.junit.Assert.assertEquals;
import static org.mammon.brands.group.Zq.Z;

import org.junit.Before;
import org.junit.Test;
import org.mammon.brands.Group;
import org.mammon.brands.Group.Element;

public class ZqElementTest {
	private Element<Zq> identity;
	private Element<Zq> generator;

	@Before
	public void createElements() {
		Group<Zq> group = Z(5);
		identity = group.getIdentity();
		generator = group.getGenerator();
	}

	@Test
	public void zeroShouldBeIdentityForAddition() {
		assertEquals(identity, identity.multiply(identity));
		assertEquals(generator, generator.multiply(identity));
	}

	@Test
	public void oneShouldBeTheGeneratorForAddition() {
		assertEquals(generator, identity.multiply(generator));
	}

	@Test
	public void inverseShouldAddToZero() {
		assertEquals(identity, generator.multiply(generator.getInverse()));
	}
}
