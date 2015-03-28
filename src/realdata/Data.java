package realdata;

import java.util.ArrayList;

import statistics.Sample;

public abstract class Data {

	public abstract int getDimensions();
	
	public abstract void convertToBinary(ArrayList<Double> thresh);
	
	public abstract Sample toSample();
	
}
