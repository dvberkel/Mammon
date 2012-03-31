package org.mammon.sandbox.objects.example;

import org.mammon.scheme.brands.generic.shop.AbstractShop;

public class ExampleShop
		extends
		AbstractShop<ExampleGroup, ExampleFiniteField, String, Long, ExampleSignatureHashFunction, ExamplePaymentHashFunction> {

	public ExampleShop(ExampleSetup setup, String identity) {
		super(setup, identity);
	}

}
