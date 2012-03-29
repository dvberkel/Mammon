package org.mammon.brands.group;

import java.math.BigInteger;

import org.mammon.brands.Group;
import org.mammon.brands.rand.RandomGenerator;

public class Zq implements Group<Zq> {

	public static Group<Zq> Z(long order) {
		return new Zq(BigInteger.valueOf(order));
	}

	public Zq(BigInteger order) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Element<Zq> getIdentity() {
		return element(0L);
	}

	private Element<Zq> element(long element) {
		return element(BigInteger.valueOf(element));
	}

	private ZqElement element(BigInteger element) {
		return new ZqElement(element);
	}

	@Override
	public Element<Zq> getGenerator() {
		return element(1L);
	}

	@Override
	public BigInteger getOrder() {
		return null;
	}

	@Override
	public Element<Zq> getRandomElement(RandomGenerator randomGenerator) {
		// TODO Auto-generated method stub
		return null;
	}

	class ZqElement implements Element<Zq> {
		private final BigInteger element;

		public ZqElement(BigInteger element) {
			this.element = element;
		}

		@Override
		public Zq getGroup() {
			return Zq.this;
		}

		@Override
		public Element<Zq> getInverse() {
			return element(this.element.negate());
		}

		@Override
		public Element<Zq> multiply(Element<Zq> other) {
			return element(this.element.add(((ZqElement) other).element));
		}

		@Override
		public Element<Zq> exponentiate(BigInteger exponent) {
			return null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ZqElement other = (ZqElement) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (element == null) {
				if (other.element != null)
					return false;
			} else if (!element.equals(other.element))
				return false;
			return true;
		}

		private Zq getOuterType() {
			return Zq.this;
		}

	}
}
