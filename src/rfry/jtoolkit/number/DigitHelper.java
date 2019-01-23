
package rfry.jtoolkit.number;

public final class DigitHelper {
	
	/**
	 * Counts the number of digits in the long {@code l}
	 * @param l a long integer
	 * @return the number of digits in the long {@code l}
	 */
	public static final int countDigits(long l) {
		return (int) (Math.log10(l) + 1);
	}
	
}
