package fakedata;

import java.util.Random;

public class App {

	public static double roundToDecimals(double d, int c)  
	{   
		int temp = (int)(d * Math.pow(10 , c));  
		return ((double)temp)/Math.pow(10 , c);  
	}
	
	public static void main(String[] args) {
		int fold = 8; //8-fold cross validation
		int d = 10;	//d-dimensional feature space
		int c = 4;  //c = classes
		double[][] initialProbabilities = new double[c][d];
		Random r = new Random();
		Sample[] samples = new Sample[c];
		
		for (int j = 0; j < c; ++j) {
			for (int i = 0; i < d; ++i) {
				initialProbabilities[j][i] = r.nextDouble() % 1;
				System.out.print(roundToDecimals(initialProbabilities[j][i], 2) + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < c; ++i) {
			samples[i] = new Sample(2000, d);
			samples[i].generateSample(initialProbabilities[i]);
		}
		
		//cross-validation
		for (int f = 0; f < fold; ++f) {
		
			double[][] estimatedProbabilities = new double[c][d];
			for (int i = 0; i < c; ++i) {
				estimatedProbabilities[i] = samples[i].getEstimatedProbabilities(f, fold);
			}
			
			//testing 
			
		}

	}

}
