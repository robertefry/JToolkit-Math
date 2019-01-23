
package robertfry.toolkit.math;

public abstract class Matrix<T extends Number> extends Tensor<T> {
	private static final long serialVersionUID = 2840265538070180093L;
	
	public abstract Matrix<T> minor(int i, int j);
	
	public abstract Matrix<T> adjoint();

	@Override
	public int dimensions() {
		return 2;
	}
	
	@Override
	public double unify() {
		return det();
	}

	public double det() {
		if (size() == 1) return get(0).doubleValue();
		double det = 0;
		for (int i = 0; i < size(0); i++) {
			det += get(i, 0).doubleValue() * minor(i, 0).det() * Math.pow(-1, i);
		}
		return det;
	}
	
}
