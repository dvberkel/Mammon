package org.mammon.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class G implements Group<G> {

	private final BigInteger q;
	private final BigInteger p;
	private Group.Element<G> primitiveRoot;
	private List<BigInteger> factorsOfP;

	public G(int q, int p) {
		this(BigInteger.valueOf(q), BigInteger.valueOf(p));
	}

	public G(BigInteger q, BigInteger p) {
		qShouldDividePminus1(q, p);
		this.q = q;
		this.p = p;
	}

	private void qShouldDividePminus1(BigInteger q, BigInteger p) {
		BigInteger[] divmod = p.subtract(BigInteger.ONE).divideAndRemainder(q);
		if (!divmod[1].equals(BigInteger.ZERO)) {
			throw new IllegalArgumentException("q should divide p-1");
		}
	}

	@Override
	public Group.Element<G> getIdentity() {
		return element(BigInteger.ONE);
	}

	private Group.Element<G> element(BigInteger element) {
		return new Element(element);
	}

	@Override
	public Group.Element<G> getGenerator() {
		Group.Element<G> primitiveRoot = getPrimitiveRoot();
		return primitiveRoot; // TODO exponentiate with p / q
	}

	private Group.Element<G> getPrimitiveRoot() {
		if (primitiveRoot == null) {
			primitiveRoot = generatePrimitiveRoot();
		}
		return primitiveRoot;
	}

	private Group.Element<G> generatePrimitiveRoot() {
		BigInteger candidate = BigInteger.valueOf(2);
		while (!isPrimitiveRoot(candidate)) {
			candidate = candidate.add(BigInteger.ONE);
		}
		return element(candidate);
	}

	private boolean isPrimitiveRoot(BigInteger candidate) {
		List<BigInteger> factors = factorsOfP();
		for (BigInteger factor : factors) {
			if (p.mod(factor).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		return true;
	}

	private List<BigInteger> factorsOfP() {
		if (factorsOfP == null) {
			factorsOfP = new ArrayList<BigInteger>();

		}
		return factorsOfP;
	}

	@Override
	public Group.Element<G> getRandomElement() {
		// TODO Auto-generated method stub
		return null;
	}

	class Element implements Group.Element<G> {

		public Element(BigInteger element) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public G getGroup() {
			return G.this;
		}

		@Override
		public Group.Element<G> getInverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Group.Element<G> multiply(Group.Element<G> other) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <F extends FiniteField<F>> Group.Element<G> exponentiate(FiniteField.Element<F> exponent) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}