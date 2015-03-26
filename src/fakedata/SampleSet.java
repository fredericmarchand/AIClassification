package fakedata;

import java.util.ArrayList;

import org.apache.commons.math3.distribution.*;

public class SampleSet {

	private static int[] values = { 0, 1 };
	
	private int size;
	private int dimensions;
	private Sample samples[];
	
	public SampleSet(int s, int dim) {
		size = s;
		dimensions = dim;
		samples = new Sample[s];
		for (int i = 0; i < size; ++i) {
			samples[i] = new Sample(dimensions);
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Sample[] getSamples() {
		return samples;
	}

	public void setSamples(Sample samples[]) {
		this.samples = samples;
	}
	
	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	
	public int generateValue(Probability probability, int given) {
		double[] probs0 = { probability.getProbability(), 1-probability.getProbability() };
		double[] probs1 = { 1-probability.getProbability(), probability.getProbability() };
		EnumeratedIntegerDistribution distribution = null;
		if (given == 0)
			distribution = new EnumeratedIntegerDistribution(values, probs0);
		else if (given == 1)
			distribution = new EnumeratedIntegerDistribution(values, probs1);
		return distribution.sample();
	}
	
	public void generateSample(Probability[] probabilities, boolean indep) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < dimensions; ++j) {
				if (indep || j == 0) {
					samples[i].getVector()[j] = generateValue(probabilities[j], 0);
				}
				else {
					samples[i].getVector()[j] = generateValue(probabilities[j], samples[i].getVector()[j-1]);
				}
			}
		}		
	}

	public double[] getEstimatedProbabilities(int f, int fold) {
		int chunkSize = size / fold;
		int trainingSize = ((fold - 1) * chunkSize);
		//System.out.println(trainingSize);
		
		double zeroCounts[] = new double[dimensions];
		//perform training
		
		//For each sample
		for (int i = 0; i < size; ++i) {
			//for each value in the vector
			for (int j = 0; j < dimensions; ++j) {
				//If within the training set
				if (i <= (f * chunkSize) || i >= ((f+1) * chunkSize)) {
					if (samples[i].getVector()[j] == 0) 
						zeroCounts[j]++;
				}
			}
		}
		for (int i = 0; i < dimensions; ++i) {
			zeroCounts[i] = (zeroCounts[i] / trainingSize);
		}
		return zeroCounts;	
	}
	
	public ArrayList<Sample> getTestingSet(int f, int fold) {
		int testingSize = size / fold;
		//System.out.println(testingSize);
		ArrayList<Sample> samples = new ArrayList<Sample>();
		
		//For each sample
		for (int i = 0; i < size; ++i) {
			//If within the training set
			if (i >= (f * testingSize) && i < ((f+1) * testingSize)) {
					samples.add(this.samples[i]);
			}
		}
		return samples;	
	}
	
	public static void main(String[] args) {
		SampleSet s = new SampleSet(2000, 10);
		
		Probability[] probs = { new Probability(0.1), 
								new Probability(0.2), 
								new Probability(0.3), 
								new Probability(0.4), 
								new Probability(0.5), 
								new Probability(0.6),
								new Probability(0.7), 
								new Probability(0.8), 
								new Probability(0.9), 
								new Probability(0.1) };
		
		s.generateSample(probs, false);
		double[] estProbs = s.getEstimatedProbabilities(0, 8);
		
		double classProbability = 1.0;
		for (int i = 0; i < s.getDimensions(); ++i) {
			System.out.println(s.getSamples()[0].getVector()[i]);
			classProbability *= estProbs[i];
		}
		
		System.out.println(classProbability);
		
	}
	
}
