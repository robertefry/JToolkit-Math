
package rfry.jtoolkit.number;

/**
 * A collection of helper methods for manipulating numbers.
 * @author Robert E Fry
 * @date 3 Dec 2018
 * @time 06:27:19
 *
 */
public final class NumberHelper {
	
	public static final long factorial(long n) {
		long fact = 1;
		while (n > 0) {
			fact *= n--;
		}
		return fact;
	}
	
	public static final boolean isFactorial(long n) {
		if (n < 0 || !isInteger(n)) return false;
		if (n == 0 || n == 1) return true;
		for (int i = 1; isInteger(n /= i); i++ ) {
			if (n == i + 1) return true;
		}
		return false;
	}
	
	public static final double nthTriangular(double n) {
		return n * (n + 1) / 2;
	}
	
	public static final double invTriangular(double n) {
		return (Math.sqrt(1 + 8 * n) - 1) / 2;
	}
	
	public static final boolean isTriangular(double n) {
		return isInteger(invTriangular(n));
	}
	
	public static final double nthPentagonal(double n) {
		return n * (3 * n - 1) / 2;
	}
	
	public static final double invPentagonal(double n) {
		return (Math.sqrt(24 * n + 1) + 1) / 6;
	}
	
	public static final boolean isPentagonal(double n) {
		return isInteger(invPentagonal(n));
	}
	
	public static final double nthHexagonal(double n) {
		return n * (2 * n - 1);
	}
	
	public static final double invHexagonal(double n) {
		return (Math.sqrt(8 * n + 1) + 1) / 4;
	}
	
	public static final boolean isHexagonal(double n) {
		return isInteger(invHexagonal(n));
	}
	
	public static final boolean isInteger(double d) {
		return (long) d == d;
	}
	
}
