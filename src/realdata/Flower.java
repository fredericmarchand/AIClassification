package realdata;

import java.util.ArrayList;

import statistics.Sample;

public class Flower extends Data {
	
	private double _sepalLength;
	private double _sepalWidth;
	private double _petalLength;
	private double _petalWidth;
	private String _class;
	
	public Flower(double sl, double sw, double pl, double pw, String cl) {
		_sepalLength = sl;
		_sepalWidth = sw; 
	    _petalLength = pl;
		_petalWidth = pw; 
		_class = cl;
	}
	
	public Flower(String[] data) {
		_sepalLength = Double.parseDouble(data[0]);
		_sepalWidth =  Double.parseDouble(data[1]); 
	    _petalLength =  Double.parseDouble(data[2]);
		_petalWidth =  Double.parseDouble(data[3]); 
		_class =  data[4];
	}
	
	@Override
	public String toString() {
		return "Flower [_sepalLength=" + _sepalLength + ", _sepalWidth="
				+ _sepalWidth + ", _petalLength=" + _petalLength
				+ ", _petalWidth=" + _petalWidth + ", _class=" + _class + "]";
	}

	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	public double get_sepalLength() {
		return _sepalLength;
	}
	public void set_sepalLength(double _sepalLength) {
		this._sepalLength = _sepalLength;
	}
	public double get_petalLength() {
		return _petalLength;
	}
	public void set_petalLength(double _petalLength) {
		this._petalLength = _petalLength;
	}
	public double get_petalWidth() {
		return _petalWidth;
	}
	public void set_petalWidth(double _petalWidth) {
		this._petalWidth = _petalWidth;
	}
	public double get_sepalWidth() {
		return _sepalWidth;
	}
	public void set_sepalWidth(double _sepalWidth) {
		this._sepalWidth = _sepalWidth;
	}
	
	@Override
	public void convertToBinary(ArrayList<Double> thresh) {
		if (_sepalLength < thresh.get(0)) {
			_sepalLength = 0;
		}
		else {
			_sepalLength = 1;
		}
		
		if (_sepalWidth < thresh.get(1)) {
			_sepalWidth = 0;
		}
		else {
			_sepalWidth = 1;
		}
		
		if (_petalLength < thresh.get(2)) {
			_petalLength = 0;
		}
		else {
			_petalLength = 1;
		}
		
		if (_petalWidth < thresh.get(3)) {
			_petalWidth = 0;
		}
		else {
			_petalWidth = 1;
		}
	}
	
	public static ArrayList<Double> getThresholds(ArrayList<Data> list) {
		ArrayList<Double> thresholds = new ArrayList<Double>();
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		for (Data f: list) {
			a += ((Flower)f).get_sepalLength();
			b += ((Flower)f).get_sepalWidth();
			c += ((Flower)f).get_petalLength();
			d += ((Flower)f).get_petalWidth();
		}
		thresholds.add(a /= list.size());
		System.out.println(thresholds.get(thresholds.size()-1));
		thresholds.add(b /= list.size());
		thresholds.add(c /= list.size());
		thresholds.add(d /= list.size());
		
		return thresholds;
	}

	@Override
	public Sample toSample() {
		int[] data = new int[getDimensions()];
		data[0] = (int)_sepalLength; 
		data[1] = (int)_sepalWidth;  
		data[2] = (int)_petalLength; 
		data[3] = (int)_petalWidth;       
		
		return new Sample(getDimensions(), data, classNameToNum(_class));
	}
	
	public static int classNameToNum(String name) {
		if (name.equals("Iris-setosa")) {
			return 0;
		}
		else if (name.equals("Iris-versicolor")) {
			return 1;
		}
		else {
			return 2;
		}
	}

	@Override
	public int getDimensions() {
		return 4;
	}
	
}
