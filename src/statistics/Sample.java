package statistics;

import java.util.Arrays;

public class Sample {

	private double probability;
	private int vector[];
	private int dimensions;
	private int _class;
	private int givenClass;
	
	public Sample(int dimensions) {
		super();
		_class = 0;
		this.probability = 0.0;
		this.vector = new int[dimensions];
		this.dimensions = dimensions;
	}
	
	public Sample(int dimensions, int vector[]) {
		super();
		_class = 0;
		this.probability = 0.0;
		this.vector = vector;
		this.dimensions = dimensions;
	}
	
	public Sample(int dimensions, int vector[], int given) {
		super();
		_class = 0;
		givenClass = given;
		this.probability = 0.0;
		this.vector = vector;
		this.dimensions = dimensions;
	}
	
	public Sample(Sample s) {
		super();
		_class = 0;
		this.probability = 0.0;
		this.vector = s.vector;
		this.dimensions = s.dimensions;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int vector[]) {
		this.vector = vector;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "Sample [probability=" + probability + ", vector=" + vector
				+ ", dimensions=" + dimensions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dimensions;
		long temp;
		temp = Double.doubleToLongBits(probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(vector);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		if (dimensions != other.dimensions)
			return false;
		if (Double.doubleToLongBits(probability) != Double
				.doubleToLongBits(other.probability))
			return false;
		if (!Arrays.equals(vector, other.vector))
			return false;
		return true;
	}

	public int get_class() {
		return _class;
	}

	public void set_class(int _class) {
		this._class = _class;
	}

	public int getGivenClass() {
		return givenClass;
	}
	
}
