
package robertfry.toolkit.math;

import robertfry.toolkit.helper.NestHelper;

public abstract class Tensor<T extends Number> extends CompoundNumber<T> {
	private static final long serialVersionUID = -2179007532294255142L;
	
	public abstract int dimensions();
	public abstract int size(int dimension);
	
	public abstract T get(int... indices);
	public abstract void set(T value, int... indices);
	
	public T get(int index) {
		return get(indices(index));
	}
	
	public void set(T value, int index) {
		set(value, indices(index));
	}
	
	@Override
	public int size() {
		int size = 1;
		for (int i = 0; i < dimensions(); i++) size *= size(i);
		return size;
	}
	
	public int[] indices(int index) {
		int[] indices = new int[dimensions()];
		for (int i = indices.length - 1; i >= 0; i--) {
			final int size = size(indices.length - 1 - i);
			final boolean sizeiszero = size == 0;
			indices[i] = sizeiszero ? index : index % size;
			index = sizeiszero ? 0 : (index - indices[i]) / size;
		}
		return indices;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final int[] limits = indices(size() - 1);
		NestHelper.nestedincludedfor(limits, position -> {
			
			for (int i = position.length - 1; i >= 0; i--) if (position[i] == 0) {
				sb.append("{");
			} else {
				break;
			}
			
			String postfix = (position[position.length - 1] < limits[limits.length - 1]) ? ", " : "";
			sb.append(get(position) + postfix);
			
			for (int i = position.length - 1; i >= 0; i--) if (position[i] >= limits[i]) {
				sb.append("}");
				if (i - 1 >= 0) if (position[i - 1] < limits[i - 1]) sb.append(", ");
			} else {
				break;
			}
			
		});
		return sb.toString();
	}
	
	@Override
	public CompoundNumber<T> add(CompoundNumber<T> o) {
		assertTensor(o);
		return add((Tensor<T>)o);
	}
	
	@Override
	public CompoundNumber<T> sub(CompoundNumber<T> o) {
		assertTensor(o);
		return sub((Tensor<T>)o);
	}
	
	@Override
	public CompoundNumber<T> mul(CompoundNumber<T> o) {
		assertTensor(o);
		return mul((Tensor<T>)o);
	}
	
	@Override
	public CompoundNumber<T> div(CompoundNumber<T> o) {
		assertTensor(o);
		return mul((Tensor<T>)o);
	}
	
	public abstract Tensor<T> add(Tensor<T> o);
	public abstract Tensor<T> sub(Tensor<T> o);
	public abstract Tensor<T> mul(Tensor<T> o);
	public abstract Tensor<T> div(Tensor<T> o);
	
	private void assertTensor(CompoundNumber<T> o) {
		assert o instanceof Tensor : "cannot operate on a tensor with an undefined compound number";
	}
	
}
