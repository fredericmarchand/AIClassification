package realdata;

public class Flower {
	
	private String _class;
	private double _sepalLength;
	private double _sepalWidth;
	private double _petalLength;
	private double _petalWidth;
	
	public Flower(double sl, double sw, double pl, double pw, String cl) {
		_class = cl;
		_sepalLength = sl;
		_sepalWidth = sw; 
	    _petalLength = pl;
		_petalWidth = pw; 
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
