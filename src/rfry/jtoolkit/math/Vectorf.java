
package robertfry.toolkit.math;

public class Vectorf extends Vector<Float> {
	private static final long serialVersionUID = 5936250311100377076L;
	
	public float[] data;
	
	public Vectorf() {
		this(0);
	}
	
	public Vectorf(int size) {
		this(new float[size]);
	}
	
	public Vectorf(float... values) {
		data = values;
	}
	
	public <E extends Number> Vectorf(Vector<E> vector) {
		this(new float[vector.size()]);
		for (int i = 0; i < size(); i++) {
			data[i] = vector.get(i).floatValue();
		}
	}

	@Override
	public double length() {
		float length = 0;
		for (float f : this) length += f * f;
		return Math.sqrt(length);
	}

	@Override
	public void normalise() {
		final double length = length();
		if (length == 0) return;
		for (int i = 0; i < size(); i++) data[i] /= length;
	}

	@Override
	public int size(int dimension) {
		return data.length;
	}

	@Override
	public Float get(int... indices) {
		return (size(0) == 0) ? null : data[indices[0]];
	}

	@Override
	public void set(Float value, int... indices) {
		if (size(0) == 0) return;
		data[indices[0]] = value;
	}

	@Override
	public CompoundNumber<Float> mul(double o) {
		for (int i = 0; i < size(); i++) data[i] *= o;
		return this;
	}

	@Override
	public Vectorf div(double o) {
		for (int i = 0; i < size(); i++) data[i] /= o;
		return this;
	}

	@Override
	public Vectorf mul(Float o) {
		for (int i = 0; i < size(); i++) data[i] *= o;
		return this;
	}

	@Override
	public Vectorf div(Float o) {
		for (int i = 0; i < size(); i++) data[i] /= o;
		return this;
	}

	@Override
	public Vectorf add(Tensor<Float> o) {
		for (int i = 0; i < size(); i++) data[i] += o.get(i);
		return this;
	}

	@Override
	public Vectorf sub(Tensor<Float> o) {
		for (int i = 0; i < size(); i++) data[i] -= o.get(i);
		return this;
	}

	@Override
	public Vectorf mul(Tensor<Float> o) {
		for (int i = 0; i < size(); i++) data[i] *= o.get(i);
		return this;
	}

	@Override
	public Vectorf div(Tensor<Float> o) {
		for (int i = 0; i < size(); i++) data[i] /= o.get(i);
		return this;
	}
	
}
