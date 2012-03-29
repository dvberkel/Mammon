package org.mammon.sandbox;

import java.math.BigInteger;

import org.mammon.brands.Group.Element;
import org.mammon.brands.PaymentHashFunction;

public class ExamplePaymentHashFunction extends OracleHashFunction implements
		PaymentHashFunction<ExampleGroup, String, Long> {

	public ExamplePaymentHashFunction(ExampleGroup g) {
		super(g, 4);
	}

	@Override
	public BigInteger hash(Element<ExampleGroup> blindedIdentity, Element<ExampleGroup> commitment,
			String shopIdentity, Long time) {
		return oracle(blindedIdentity, commitment, shopIdentity, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ExamplePaymentHashFunction)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return ExamplePaymentHashFunction.class.getName().hashCode();
	}

	@Override
	public String toString() {
		return ExamplePaymentHashFunction.class.getSimpleName();
	}

}
