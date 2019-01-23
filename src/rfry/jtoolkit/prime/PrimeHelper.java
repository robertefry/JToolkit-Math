package rfry.jtoolkit.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PrimeHelper {
	
	private static final List<Double> known_primes = new ArrayList<Double>();
	
	public static final boolean isPrime(double d) {
		if (d == 2) return true;
		if (d < 2 || d % 2 == 0) return false;
		if (known_primes.contains(d)) return true;
		for (int i = 3; i <= Math.sqrt(d); i += 2) if (isPrime(i))
			if (d % i == 0) return false;
		known_primes.add(d);
		Collections.sort(known_primes);
		return true;
	}
	
	public static final void refresh() {
		known_primes.clear();
	}

}
