package main;

import java.util.Random;

public class App {

	public static double roundToDecimals(double d, int c)  
	{   
		int temp = (int)(d * Math.pow(10 , c));  
		return ((double)temp)/Math.pow(10 , c);  
	}
	
	public static void main(String[] args) {
		int d = 10;	//d-dimensional feature space
		int c = 4;  //c = classes
		double[][] vectors = new double[c][d];
		Random r = new Random();
		
		for (int j = 0; j < c; ++j) {
			for (int i = 0; i < d; ++i) {
				vectors[j][i] = r.nextDouble() % 1;
				System.out.print(roundToDecimals(vectors[j][i], 2) + " ");
			}
			System.out.println();
		}
		
		
		
	}

}
