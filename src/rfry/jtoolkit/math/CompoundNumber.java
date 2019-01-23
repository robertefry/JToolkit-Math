
package robertfry.toolkit.math;

import java.util.Iterator;

public abstract class CompoundNumber<T extends Number> extends Number implements Iterable<T>, Comparable<CompoundNumber<T>> {
	private static final long serialVersionUID = -8276232370900607072L;
	
	public abstract int size();
	
	public abstract double unify();
	
	public abstract T get(int index);
	public abstract void set(T value, int index);
	
	public abstract CompoundNumber<T> inverse();
	
	public abstract CompoundNumber<T> mul(double o);
	public abstract CompoundNumber<T> div(double o);
	public abstract CompoundNumber<T> mul(T o);
	public abstract CompoundNumber<T> div(T o);
	public abstract CompoundNumber<T> add(CompoundNumber<T> o);
	public abstract CompoundNumber<T> sub(CompoundNumber<T> o);
	public abstract CompoundNumber<T> mul(CompoundNumber<T> o);
	public abstract CompoundNumber<T> div(CompoundNumber<T> o);
	
	@Override
	public int compareTo(CompoundNumber<T> o) {
		return Double.compare(unify(), o.unify());
	}

	@Override
	public int intValue() {
		return (int) unify();
	}

	@Override
	public long longValue() {
		return (long) unify();
	}

	@Override
	public float floatValue() {
		return (float) unify();
	}

	@Override
	public double doubleValue() {
		return (double) unify();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<T> {
		
		public int cursor = 0;

		@Override
		public boolean hasNext() {
			return cursor < size();
		}

		@Override
		public T next() {
			return get(cursor++);
		}
		
	}
	
}
