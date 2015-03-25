package realdata;

public class Flower {
	
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
	

	
}
