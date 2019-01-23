
package robertfry.toolkit.math;

public class Matrixf extends Matrix<Float> {
	private static final long serialVersionUID = 6001317260990461425L;
	
	public float[][] data;
	
	public Matrixf() {
		this(0, 0);
	}
	
	public Matrixf(int rows, int cols) {
		this(new float[rows][cols]);
	}
	
	public Matrixf(float[]... rows) {
		data = rows;
	}
	
	public <E extends Number> Matrixf(Matrix<E> matrix) {
		this(new float[matrix.size(0)][matrix.size(1)]);
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] = matrix.get(i, j).floatValue();
	}

	@Override
	public int size(int dimension) {
		switch (dimension) {
		case 0:
			return data.length;
		case 1:
			return data[0].length;
		default:
			assert dimension <= 1 : "incorect dimension size " + dimension + " > max = 1";
		}
		return 0;
	}

	@Override
	public Float get(int... indices) {
		return data[indices[0]][indices[1]];
	}

	@Override
	public void set(Float value, int... indices) {
		data[indices[0]][indices[1]] = value;
	}

	@Override
	public Matrixf minor(int i, int j) {
		Matrixf minor = new Matrixf(size(0) - 1, size(1) - 1);
		for (int _i = 0, i_ = 0; _i < size(0); _i++) {
			if (_i == i) continue;
			for (int _j = 0, j_ = 0; _j < size(1); _j++) {
				if (_j == j) continue;
				minor.data[i_][j_] = data[_i][_j];
				j_++;
			}
			i_++;
		}
		return minor;
	}

	@Override
	public Matrixf adjoint() {
		Matrixf adjoint = new Matrixf(size(1), size(0));
		for (int i = 0; i < size(0); i++) {
			for (int j = 0; j < size(1); j++) {
				adjoint.data[j][i] = data[i][j];
			}
		}
		return adjoint;
	}

	@Override
	public Matrixf inverse() {
		Matrixf inverse = new Matrixf(size(0), size(1));
		for (int i = 0; i < size(0); i++) {
			for (int j = 0; j < size(1); j++) {
				inverse.data[i][j] = (float) (minor(i, j).det() * Math.pow(-1, i + j));
			}
		}
		return inverse.adjoint().div(det());
	}

	@Override
	public Matrixf mul(double o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] *= o;
		return this;
	}

	@Override
	public Matrixf div(double o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] /= o;
		return this;
	}

	@Override
	public Matrixf mul(Float o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] *= o;
		return this;
	}

	@Override
	public Matrixf div(Float o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] /= o;
		return this;
	}

	@Override
	public Matrixf add(Tensor<Float> o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] += o.get(i, j).floatValue();
		return this;
	}

	@Override
	public Matrixf sub(Tensor<Float> o) {
		for (int i = 0; i < size(0); i++) for (int j = 0; j < size(1); j++) data[i][j] -= o.get(i, j).floatValue();
		return this;
	}

	@Override
	public Matrixf mul(Tensor<Float> o) {
		return this;
	}

	@Override
	public Matrixf div(Tensor<Float> o) {
		return mul((Tensor<Float>)o.inverse());
	}
	
}
