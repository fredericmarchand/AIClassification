package realdata;

import java.util.ArrayList;

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
	public void convertToBinary(ArrayList<Integer> thresh) {
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
	
	public static ArrayList<Integer> getThresholds(ArrayList<Data> list) {
		ArrayList<Integer> thresholds = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		for (Data f: list) {
			a += ((Flower)f).get_sepalLength();
			b += ((Flower)f).get_sepalWidth();
			c += ((Flower)f).get_petalLength();
			d += ((Flower)f).get_petalWidth();
		}
		thresholds.add(a /= list.size());
		thresholds.add(b /= list.size());
		thresholds.add(c /= list.size());
		thresholds.add(d /= list.size());
		
		return thresholds;
	}
	
}
