package fakedata;

import java.util.ArrayList;
import java.util.Random;

public class App {

	public static double roundToDecimals(double d, int c) {   
		int temp = (int)(d * Math.pow(10 , c));  
		return ((double)temp)/Math.pow(10 , c);  
	}
	
	public static double getSampleProbability(Sample sample, double estimatedProbs[], int dimensions) {
		double probability = 1.0;
		
		for (int d = 0; d < dimensions; ++d) {
			if (sample.getVector()[d] == 0)
				probability *= estimatedProbs[d];
			else
				probability *= (1 - estimatedProbs[d]);
		}
		
		return probability;
	}
		
	public static void main(String[] args) {
		int fold = 8; //8-fold cross validation
		int d = 10;	  //d-dimensional feature space
		int c = 4;    //c = classes
		double[][] initialProbabilities = new double[c][d];
		ArrayList<ArrayList<Sample>> testingSets = new ArrayList<ArrayList<Sample>>();
		Random r = new Random();
		SampleSet[] samples = new SampleSet[c];
		
		for (int j = 0; j < c; ++j) {
			for (int i = 0; i < d; ++i) {
				initialProbabilities[j][i] = r.nextDouble() % 1;
				System.out.print(roundToDecimals(initialProbabilities[j][i], 2) + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < c; ++i) {
			samples[i] = new SampleSet(2000, d);
			samples[i].generateSample(initialProbabilities[i]);
		}
		
		//cross-validation
		for (int f = 0; f < fold; ++f) {
		
			double[][] estimatedProbabilities = new double[c][d];
			for (int i = 0; i < c; ++i) {
				estimatedProbabilities[i] = samples[i].getEstimatedProbabilities(f, fold);
			}
			
			//testing 
			
			//get testing sets
			for (int i = 0; i < c; ++i) {
				testingSets.add(samples[i].getTestingSet(f, fold));
			}
			
			//for each sample in each classes test set
			for (ArrayList<Sample> list: testingSets) {
				int class1 = 0;
				int class2 = 0;
				int class3 = 0;
				int class4 = 0;
				//System.out.println(list.size());
				for (Sample sample: list) {
					//classify
					double prob1 = getSampleProbability(sample, estimatedProbabilities[0], d);
					double prob2 = getSampleProbability(sample, estimatedProbabilities[1], d);
					double prob3 = getSampleProbability(sample, estimatedProbabilities[2], d);
					double prob4 = getSampleProbability(sample, estimatedProbabilities[3], d);
					double max = Double.max(prob4, Double.max(prob3, Double.max(prob1, prob2)));
					if (max == prob1) {
						sample.set_class(1);
						class1++;
					}
					else if (max == prob2) {
						sample.set_class(2);
						class2++;
					}
					else if (max == prob3) {
						sample.set_class(3);
						class3++;
					}
					else if (max == prob4) {
						sample.set_class(4);
						class4++;
					}
				}
				System.out.println("Class1: " + class1 + "/250");
				System.out.println("Class2: " + class2 + "/250");
				System.out.println("Class3: " + class3 + "/250");
				System.out.println("Class4: " + class4 + "/250\n");
			}	
			testingSets.clear();
		}
	}
}
