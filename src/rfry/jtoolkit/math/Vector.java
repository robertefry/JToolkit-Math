
package robertfry.toolkit.math;

public abstract class Vector<T extends Number> extends Tensor<T> {
	private static final long serialVersionUID = 7966410148605600534L;
	
	public abstract double length();
	
	public abstract void normalise();
	
	@Override
	public double unify() {
		return length();
	}
	
	@Override
	public int dimensions() {
		return 1;
	}
	
	@Override
	public CompoundNumber<T> inverse() {
		throw new UnsupportedOperationException("cannot invert a vector");
	}
	
}
