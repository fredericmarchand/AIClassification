package realdata;

import java.util.ArrayList;

import statistics.Sample;

public class HeartDisease extends Data {
	
	private double _age;
	private double _gender;
	private double _cp;
	private double _trestbps;
	private double _chol;
	private double _fbs;
	private double _restecg;
	private double _thalach;
	private double _exang;
	private double _oldpeak;
	private double _dlope;
	private double _ca;
	private double _thal;
	private double _class;
	
	public HeartDisease(double _age, double _gender, double _cp,
			double _trestbps, double _chol, double _fbs, double _restecg,
			double _thalach, double _exang, double _oldpeak, double _dlope,
			double _ca, double _thal, double _class) {
		super();
		this._age = _age;
		this._gender = _gender;
		this._cp = _cp;
		this._trestbps = _trestbps;
		this._chol = _chol;
		this._fbs = _fbs;
		this._restecg = _restecg;
		this._thalach = _thalach;
		this._exang = _exang;
		this._oldpeak = _oldpeak;
		this._dlope = _dlope;
		this._ca = _ca;
		this._thal = _thal;
		this._class = _class;
	}
	
	public HeartDisease(String[] data) {
		this._age = Double.parseDouble(data[0]);
		this._gender = Double.parseDouble(data[1]);
		this._cp = Double.parseDouble(data[2]);
		this._trestbps = Double.parseDouble(data[3]);
		this._chol = Double.parseDouble(data[4]);
		this._fbs = Double.parseDouble(data[5]);
		this._restecg = Double.parseDouble(data[6]);
		this._thalach = Double.parseDouble(data[7]);
		this._exang = Double.parseDouble(data[8]);
		this._oldpeak = Double.parseDouble(data[9]);
		this._dlope = Double.parseDouble(data[10]);
		this._ca = Double.parseDouble(data[11]);
		this._thal = Double.parseDouble(data[12]);
		this._class = Double.parseDouble(data[13]);
	}
	
	@Override
	public String toString() {
		return "HeartDisease [_age=" + _age + ", _gender=" + _gender + ", _cp="
				+ _cp + ", _trestbps=" + _trestbps + ", _chol=" + _chol
				+ ", _fbs=" + _fbs + ", _restecg=" + _restecg + ", _thalach="
				+ _thalach + ", _exang=" + _exang + ", _oldpeak=" + _oldpeak
				+ ", _dlope=" + _dlope + ", _ca=" + _ca + ", _thal=" + _thal
				+ ", _class=" + _class + "]";
	}

	public double get_age() {
		return _age;
	}

	public void set_age(double _age) {
		this._age = _age;
	}

	public double get_gender() {
		return _gender;
	}

	public void set_gender(double _gender) {
		this._gender = _gender;
	}

	public double get_cp() {
		return _cp;
	}

	public void set_cp(double _cp) {
		this._cp = _cp;
	}

	public double get_trestbps() {
		return _trestbps;
	}

	public void set_trestbps(double _trestbps) {
		this._trestbps = _trestbps;
	}

	public double get_chol() {
		return _chol;
	}

	public void set_chol(double _chol) {
		this._chol = _chol;
	}

	public double get_fbs() {
		return _fbs;
	}

	public void set_fbs(double _fbs) {
		this._fbs = _fbs;
	}

	public double get_restecg() {
		return _restecg;
	}

	public void set_restecg(double _restecg) {
		this._restecg = _restecg;
	}

	public double get_thalach() {
		return _thalach;
	}

	public void set_thalach(double _thalach) {
		this._thalach = _thalach;
	}

	public double get_exang() {
		return _exang;
	}

	public void set_exang(double _exang) {
		this._exang = _exang;
	}

	public double get_oldpeak() {
		return _oldpeak;
	}

	public void set_oldpeak(double _oldpeak) {
		this._oldpeak = _oldpeak;
	}

	public double get_dlope() {
		return _dlope;
	}

	public void set_dlope(double _dlope) {
		this._dlope = _dlope;
	}

	public double get_ca() {
		return _ca;
	}

	public void set_ca(double _ca) {
		this._ca = _ca;
	}

	public double get_thal() {
		return _thal;
	}

	public void set_thal(double _thal) {
		this._thal = _thal;
	}

	public double get_class() {
		return _class;
	}

	public void set_class(double _class) {
		this._class = _class;
	}
	
	public static ArrayList<Double> getThresholds(ArrayList<Data> list) {
		ArrayList<Double> thresholds = new ArrayList<Double>();
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double f = 0;
		double g = 0;
		double h = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		double l = 0;
		double m = 0;
		for (Data hd: list) {
			a += ((HeartDisease)hd).get_age();     
			b += ((HeartDisease)hd).get_gender();  
			c += ((HeartDisease)hd).get_cp();      
			d += ((HeartDisease)hd).get_trestbps();
			e += ((HeartDisease)hd).get_chol();    
			f += ((HeartDisease)hd).get_fbs();     
			g += ((HeartDisease)hd).get_restecg(); 
			h += ((HeartDisease)hd).get_thalach(); 
			i += ((HeartDisease)hd).get_exang();   
			j += ((HeartDisease)hd).get_oldpeak(); 
			k += ((HeartDisease)hd).get_dlope();   
			l += ((HeartDisease)hd).get_ca();      
			m += ((HeartDisease)hd).get_thal();    
		}
		thresholds.add(a /= list.size());
		thresholds.add(b /= list.size());
		thresholds.add(c /= list.size());
		thresholds.add(d /= list.size());
		thresholds.add(e /= list.size());
		thresholds.add(f /= list.size());
		thresholds.add(g /= list.size());
		thresholds.add(h /= list.size());
		thresholds.add(i /= list.size());
		thresholds.add(j /= list.size());
		thresholds.add(k /= list.size());
		thresholds.add(l /= list.size());
		thresholds.add(m /= list.size());
		
		return thresholds;
	}

	@Override
	public void convertToBinary(ArrayList<Double> thresh) {
		if (_age < thresh.get(0)) {
			_age = 0;
		}
		else {
			_age = 1;
		}
		
		if (_gender < thresh.get(1)) {
			_gender = 0;
		}
		else {
			_gender = 1;
		}
		
		if (_cp < thresh.get(2)) {
			_cp = 0;
		}
		else {
			_cp = 1;
		}
		
		if (_trestbps < thresh.get(3)) {
			_trestbps = 0;
		}
		else {
			_trestbps = 1;
		}
		
		if (_chol < thresh.get(4)) {
			_chol = 0;
		}
		else {
			_chol = 1;
		}
		
		if (_fbs < thresh.get(5)) {
			_fbs = 0;
		}
		else {
			_fbs = 1;
		}
		
		if (_restecg < thresh.get(6)) {
			_restecg = 0;
		}
		else {
			_restecg = 1;
		}
		
		if (_thalach < thresh.get(7)) {
			_thalach = 0;
		}
		else {
			_thalach = 1;
		}
		
		if (_exang < thresh.get(8)) {
			_exang = 0;
		}
		else {
			_exang = 1;
		}
		
		if (_oldpeak < thresh.get(9)) {
			_oldpeak = 0;
		}
		else {
			_oldpeak = 1;
		}
		
		if (_dlope < thresh.get(10)) {
			_dlope = 0;
		}
		else {
			_dlope = 1;
		}
		
		if (_ca < thresh.get(11)) {
			_ca = 0;
		}
		else {
			_ca = 1;
		}
		
		if (_thal < thresh.get(12)) {
			_thal = 0;
		}
		else {
			_thal = 1;
		}
	}

	@Override
	public Sample toSample() {
		int[] data = new int[getDimensions()];
		data[0] = (int)_age;      
		data[1] = (int)_gender;   
		data[2] = (int)_cp;       
		data[3] = (int)_trestbps; 
		data[4] = (int)_chol;     
		data[5] = (int)_fbs;      
		data[6] = (int)_restecg;  
		data[7] = (int)_thalach;  
		data[8] = (int)_exang;    
		data[9] = (int)_oldpeak;  
		data[10] = (int)_dlope;      
		data[11] = (int)_ca;         
		data[12] = (int)_thal;       
		
		return new Sample(getDimensions(), data, (int)_class);
	}

	@Override
	public int getDimensions() {
		return 13;
	}
	
}
