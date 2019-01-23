package rfry.jtoolkit.prime;

public class PrimeSieve implements Runnable {
	
	public static final int MAX_SIZE = Integer.MAX_VALUE - 2;
	public static final boolean PRIME = false, NOT_PRIME = true;
	
	protected final boolean[] data;
	protected int count = 0;
	
	public PrimeSieve(int size) {
		data = new boolean[size];
		data[0] = data[1] = NOT_PRIME;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < size(); i++) {
			if (isPrime(i)) {
				count++;
				for (int j = i * 2; j >= 0 && j < size(); j += i) {
					data[j] = NOT_PRIME;
				}
			}
		}
		
	}
	
	public boolean isPrime(int p) {
		return data[p] == PRIME;
	}
	
	public int size() {
		return data.length;
	}
	
	public int[] listPrimes() {
		int[] list = new int[count];
		for (int i = 0, j = 0; i < size(); i++)
			if (isPrime(i)) list[j++] = i;
		return list;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString() + " -> [");
		for (int i = 0; i < size(); i++) {
			if (isPrime(i)) builder.append(i + ((i < size() - 1) ? ", " : ""));
		}
		return builder.append("]").toString();
	}

}
