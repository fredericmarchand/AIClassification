package realdata;

import java.util.ArrayList;

import statistics.Sample;

public class Wine extends Data {
	private double _class;
	private double _alcohol;
	private double _malicAcid;
	private double _ash;
	private double _alcalityOfAsh;
	private double _magnesium;
	private double _totalPhenols;
	private double _flavanoids;
	private double _nonflavanoidPhenols;
	private double _proanthocyanins;
	private double _colorIntensity;
	private double _hue;
	private double _od280_315;
	private double _proline;
	
	public Wine(double _class, double _alcohol, double _malicAcid, double _ash,
			double _alcalityOfAsh, double _magnesium, double _totalPhenols,
			double _flavanoids, double _nonflavanoidPhenols,
			double _proanthocyanins, double _colorIntensity, double _hue,
			double _od280_315, double _proline) {
		super();
		this._class = _class;
		this._alcohol = _alcohol;
		this._malicAcid = _malicAcid;
		this._ash = _ash;
		this._alcalityOfAsh = _alcalityOfAsh;
		this._magnesium = _magnesium;
		this._totalPhenols = _totalPhenols;
		this._flavanoids = _flavanoids;
		this._nonflavanoidPhenols = _nonflavanoidPhenols;
		this._proanthocyanins = _proanthocyanins;
		this._colorIntensity = _colorIntensity;
		this._hue = _hue;
		this._od280_315 = _od280_315;
		this._proline = _proline;
	}
	
	public Wine(String[] data) {
		this._class = Double.parseDouble(data[0]);
		this._alcohol = Double.parseDouble(data[1]);
		this._malicAcid = Double.parseDouble(data[2]);
		this._ash = Double.parseDouble(data[3]);
		this._alcalityOfAsh = Double.parseDouble(data[4]);
		this._magnesium = Double.parseDouble(data[5]);
		this._totalPhenols = Double.parseDouble(data[6]);
		this._flavanoids = Double.parseDouble(data[7]);
		this._nonflavanoidPhenols = Double.parseDouble(data[8]);
		this._proanthocyanins = Double.parseDouble(data[9]);
		this._colorIntensity = Double.parseDouble(data[10]);
		this._hue = Double.parseDouble(data[11]);
		this._od280_315 = Double.parseDouble(data[12]);
		this._proline = Double.parseDouble(data[13]);
	}
	
	@Override
	public String toString() {
		return "Wine [_class=" + _class + ", _alcohol=" + _alcohol
				+ ", _malicAcid=" + _malicAcid + ", _ash=" + _ash
				+ ", _alcalityOfAsh=" + _alcalityOfAsh + ", _magnesium="
				+ _magnesium + ", _totalPhenols=" + _totalPhenols
				+ ", _flavanoids=" + _flavanoids + ", _nonflavanoidPhenols="
				+ _nonflavanoidPhenols + ", _proanthocyanins="
				+ _proanthocyanins + ", _colorIntensity=" + _colorIntensity
				+ ", _hue=" + _hue + ", _od280_315=" + _od280_315
				+ ", _proline=" + _proline + "]";
	}

	public double get_class() {
		return _class;
	}

	public void set_class(double _class) {
		this._class = _class;
	}

	public double get_alcohol() {
		return _alcohol;
	}

	public void set_alcohol(double _alcohol) {
		this._alcohol = _alcohol;
	}

	public double get_malicAcid() {
		return _malicAcid;
	}

	public void set_malicAcid(double _malicAcid) {
		this._malicAcid = _malicAcid;
	}

	public double get_ash() {
		return _ash;
	}

	public void set_ash(double _ash) {
		this._ash = _ash;
	}

	public double get_alcalityOfAsh() {
		return _alcalityOfAsh;
	}

	public void set_alcalityOfAsh(double _alcalityOfAsh) {
		this._alcalityOfAsh = _alcalityOfAsh;
	}

	public double get_magnesium() {
		return _magnesium;
	}

	public void set_magnesium(double _magnesium) {
		this._magnesium = _magnesium;
	}

	public double get_totalPhenols() {
		return _totalPhenols;
	}

	public void set_totalPhenols(double _totalPhenols) {
		this._totalPhenols = _totalPhenols;
	}

	public double get_flavanoids() {
		return _flavanoids;
	}

	public void set_flavanoids(double _flavanoids) {
		this._flavanoids = _flavanoids;
	}

	public double get_nonflavanoidPhenols() {
		return _nonflavanoidPhenols;
	}

	public void set_nonflavanoidPhenols(double _nonflavanoidPhenols) {
		this._nonflavanoidPhenols = _nonflavanoidPhenols;
	}

	public double get_proanthocyanins() {
		return _proanthocyanins;
	}

	public void set_proanthocyanins(double _proanthocyanins) {
		this._proanthocyanins = _proanthocyanins;
	}

	public double get_colorIntensity() {
		return _colorIntensity;
	}

	public void set_colorIntensity(double _colorIntensity) {
		this._colorIntensity = _colorIntensity;
	}

	public double get_hue() {
		return _hue;
	}

	public void set_hue(double _hue) {
		this._hue = _hue;
	}

	public double get_od280_315() {
		return _od280_315;
	}

	public void set_od280_315(double _od280_315) {
		this._od280_315 = _od280_315;
	}

	public double get_proline() {
		return _proline;
	}

	public void set_proline(double _proline) {
		this._proline = _proline;
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
		for (Data w: list) {
			a += ((Wine)w).get_alcohol();             
			b += ((Wine)w).get_malicAcid();           
			c += ((Wine)w).get_ash();                 
			d += ((Wine)w).get_alcalityOfAsh();       
			e += ((Wine)w).get_magnesium();           
			f += ((Wine)w).get_totalPhenols();        
			g += ((Wine)w).get_flavanoids();          
			h += ((Wine)w).get_nonflavanoidPhenols(); 
			i += ((Wine)w).get_proanthocyanins();     
			j += ((Wine)w).get_colorIntensity();      
			k += ((Wine)w).get_hue();                 
			l += ((Wine)w).get_od280_315();           
			m += ((Wine)w).get_proline();             
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
		if (_alcohol < thresh.get(0)) {
			_alcohol = 0;
		}
		else {
			_alcohol = 1;
		}
		
		if (_malicAcid < thresh.get(1)) {
			_malicAcid = 0;
		}
		else {
			_malicAcid = 1;
		}
		
		if (_ash < thresh.get(2)) {
			_ash = 0;
		}
		else {
			_ash = 1;
		}
		
		if (_alcalityOfAsh < thresh.get(3)) {
			_alcalityOfAsh = 0;
		}
		else {
			_alcalityOfAsh = 1;
		}
		
		if (_magnesium < thresh.get(4)) {
			_magnesium = 0;
		}
		else {
			_magnesium = 1;
		}
		
		if (_totalPhenols < thresh.get(5)) {
			_totalPhenols = 0;
		}
		else {
			_totalPhenols = 1;
		}
		
		if (_flavanoids < thresh.get(6)) {
			_flavanoids = 0;
		}
		else {
			_flavanoids = 1;
		}
		
		if (_nonflavanoidPhenols < thresh.get(7)) {
			_nonflavanoidPhenols = 0;
		}
		else {
			_nonflavanoidPhenols = 1;
		}
		
		if (_proanthocyanins < thresh.get(8)) {
			_proanthocyanins = 0;
		}
		else {
			_proanthocyanins = 1;
		}
		
		if (_colorIntensity < thresh.get(9)) {
			_colorIntensity = 0;
		}
		else {
			_colorIntensity = 1;
		}
		
		if (_hue < thresh.get(10)) {
			_hue = 0;
		}
		else {
			_hue = 1;
		}
		
		if (_od280_315 < thresh.get(11)) {
			_od280_315 = 0;
		}
		else {
			_od280_315 = 1;
		}
		
		if (_proline < thresh.get(12)) {
			_proline = 0;
		}
		else {
			_proline = 1;
		}
	}

	@Override
	public Sample toSample() {
		int[] data = new int[getDimensions()];            
		data[0] = (int)_alcohol;             
		data[1] = (int)_malicAcid;           
		data[2] = (int)_ash;                 
		data[3] = (int)_alcalityOfAsh;       
		data[4] = (int)_magnesium;           
		data[5] = (int)_totalPhenols;        
		data[6] = (int)_flavanoids;          
		data[7] = (int)_nonflavanoidPhenols; 
		data[8] = (int)_proanthocyanins;     
		data[9] = (int)_colorIntensity;      
		data[10] = (int)_hue;                 
		data[11] = (int)_od280_315;           
		data[12] = (int)_proline;             
		
		return new Sample(getDimensions(), data, (int)_class);
	}

	@Override
	public int getDimensions() {
		return 13;
	}
}
