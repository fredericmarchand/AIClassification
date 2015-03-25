package realdata;

public class HeartDisease {
	
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
	
}
