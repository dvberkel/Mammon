package org.mammon.sandbox;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.mammon.brands.rand.RandomGenerator;

@SuppressWarnings("unchecked")
public class OracleHashFunction {

	protected final ExampleGroup g;
	private final RandomGenerator generator = new ExampleRandomGenerator();
	private final Map map = new HashMap();
	private final int d;

	public OracleHashFunction(ExampleGroup g, int depth) {
		this.g = g;
		d = depth - 1;
	}

	protected BigInteger oracle(Object... val) {
		Map curr = map;
		for (int i = 0; i < d; i++) {
			Map next = (Map) curr.get(Integer.valueOf(val[i].hashCode()));
			if (next == null) {
				next = new HashMap();
				curr.put(Integer.valueOf(val[i].hashCode()), next);
			}
			curr = next;
		}
		if (curr.containsKey(Integer.valueOf(val[d].hashCode()))) {
			return BigInteger.valueOf((Integer)curr.get(Integer.valueOf(val[d].hashCode())));
		} else {
			BigInteger element = generator.bigInteger(g.getOrder());
			curr.put(Integer.valueOf(val[d].hashCode()), element);
			return element;
		}
	}

}