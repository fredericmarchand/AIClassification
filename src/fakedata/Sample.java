package fakedata;

import org.apache.commons.math3.distribution.*;

public class Sample {

	private static int[] values = { 0, 1 };
	
	private int size;
	private int dimensions;
	private int samples[][];
	
	public Sample(int s, int dim) {
		size = s;
		dimensions = dim;
		samples = new int[s][dim];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getSamples() {
		return samples;
	}

	public void setSamples(int samples[][]) {
		this.samples = samples;
	}
	
	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	
	public int generateValue(double probability) {
		double[] probs = { probability, 1-probability };
		EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(values, probs);
		return distribution.sample();
	}
	
	public void generateSample(double[] probabilities) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < dimensions; ++j) {
				samples[i][j] = generateValue(probabilities[j]);
				//System.out.print(samples[i][j] + " ");
			}
			//System.out.println();
		}		
	}

	public double[] getEstimatedProbabilities(int f, int fold) {
		int chunkSize = size / fold;
		int trainingSize = ((fold - 1) * chunkSize);
		
		double zeroCounts[] = new double[dimensions];
		//perform training
		
		//For each sample
		for (int i = 0; i < size; ++i) {
			//for each value in the vector
			for (int j = 0; j < dimensions; ++j) {
				//If within the training set
				if (i <= f * chunkSize || i >= (f+1) * chunkSize) {
					if (samples[i][j] == 0) 
						zeroCounts[j]++;
				}
			}
		}
		for (int i = 0; i < dimensions; ++i) {
			zeroCounts[i] = App.roundToDecimals((zeroCounts[i] / trainingSize), 2);
		}
		return zeroCounts;	
	}
	
	public double getSampleProbability(int sampleIndex, double estimatedProbs[]) {
		double probability = 1.0;
		
		for (int d = 0; d < dimensions; ++d) {
			// P(Xi = 0 | W1)
			
			if (samples[sampleIndex][d] == 0)
				probability *= estimatedProbs[d];
			else
				probability *= (1 - estimatedProbs[d]);
		}
		
		return probability;
	}
	
	public static void main(String[] args) {
		Sample s = new Sample(2000, 10);
		Sample s2 = new Sample(2000, 10);
		
		double[] probs = { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.1 };
		
		s.generateSample(probs);
		double[] estProbs = s.getEstimatedProbabilities(0, 8);
		
		double classProbability = 1.0;
		for (int i = 0; i < s.getDimensions(); ++i) {
			System.out.println(s.getSamples()[0][i]);
			classProbability *= estProbs[i];
		}
		
		System.out.println(classProbability);
		
	}
	
}
