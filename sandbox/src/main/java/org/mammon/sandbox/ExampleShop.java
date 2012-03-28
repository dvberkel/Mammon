package org.mammon.sandbox;

import org.mammon.scheme.brands.BrandsSchemeSetup;
import org.mammon.scheme.brands.Group;
import org.mammon.scheme.brands.PaymentHashFunction;
import org.mammon.scheme.brands.SignatureHashFunction;
import org.mammon.scheme.brands.shop.Shop;

public class ExampleShop<G extends Group<G>, S, T, H extends SignatureHashFunction<G>, H0 extends PaymentHashFunction<G, S, T>>
		implements Shop<G, S, T, H, H0> {

	private final BrandsSchemeSetup<G, S, T, H, H0> setup;

	private final S identity;

	public ExampleShop(BrandsSchemeSetup<G, S, T, H, H0> setup, S identity) {
		this.setup = setup;
		this.identity = identity;
	}

	@Override
	public S getIdentity() {
		return identity;
	}

	@Override
	public BrandsSchemeSetup<G, S, T, H, H0> getSetup() {
		return setup;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ExampleShop<?, ?, ?, ?, ?>)) {
			return false;
		}
		ExampleShop<?, ?, ?, ?, ?> other = (ExampleShop<?, ?, ?, ?, ?>) obj;
		return setup.equals(other.setup) && identity.equals(other.identity);
	}

	@Override
	public int hashCode() {
		int hashCode = HashCodeUtil.SEED;
		hashCode = HashCodeUtil.hash(hashCode, setup);
		hashCode = HashCodeUtil.hash(hashCode, identity);
		return hashCode;
	}

	@Override
	public String toString() {
		return "ExampleShop(" + setup.hashCode() + "," + identity.toString() + ")";
	}

}
