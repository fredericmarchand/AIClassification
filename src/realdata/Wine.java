package realdata;

public class Wine {
	private double _class;
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
}
