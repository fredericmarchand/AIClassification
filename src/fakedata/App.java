package fakedata;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

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
	
	public static Graph assignWeights(SampleSet samples, int dim) {
		double [] zeroCounts = new double[dim];
		double [] oneCounts = new double[dim];
		
		Graph graph = new Graph();
		
		for (Sample sample: samples.getSamples()) {
			for (int i = 0; i < dim; ++i) {
				if (sample.getVector()[i] == 0) 
					zeroCounts[i]++;
				else
					oneCounts[i]++;
			}
		}
		
		for (int i = 0; i < dim; ++i) {
			
			for (int j = 0; j < dim; ++j) {
				if (i == j)
					continue;
				double weight = 0.0;
				 for (int z = 0; z <= 1; ++z) {
					 for (int o = 0; o <= 1; ++o) {
						 double comboCounts = 0.0;
						 
						 for (Sample sample: samples.getSamples()) {
							 if (sample.getVector()[i] == z &&
								 sample.getVector()[j] == o)
								 comboCounts++;
						 }
						 
						 double vi = (z == 0 ? zeroCounts[i] : oneCounts[i]);
						 double vj = (o == 0 ? zeroCounts[j] : oneCounts[j]);
						 //System.out.println("(" + i + "," + j + "):(" + z + "," + o + ")" + vi/2000 + " " + vj/2000 + " " + comboCounts/2000);
						 
						 weight += ((comboCounts/2000) * Math.log((comboCounts/2000)/((vi/2000) * (vj/2000))));
					 }
				 }
				 graph.addEdge(new Edge(new Vertex(i), new Vertex(j), weight));
			}
		}
		
		return graph;
	}
	
	//Assumption: probabilities given parent=1 are 1-probability
	//Assumption: trees are linear the root is the start of the list and the parent of each is the one with index-1
	public static void main(String[] args) {
		int fold = 8; //8-fold cross validation
		int d = 10;	  //d-dimensional feature space
		int c = 4;    //c = classes
		Probability[][] initialProbabilities = new Probability[c][d];
		ArrayList<ArrayList<Sample>> testingSets = new ArrayList<ArrayList<Sample>>();
		Random r = new Random();
		SampleSet[] samples = new SampleSet[c];
		
		for (int j = 0; j < c; ++j) {
			for (int i = 0; i < d; ++i) {
				double prob = roundToDecimals(r.nextDouble() % 1, 2);
				if (prob == 0.5)
					prob += 0.01;
				initialProbabilities[j][i] = new Probability(prob);
				System.out.print(initialProbabilities[j][i].getProbability() + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < c; ++i) {
			samples[i] = new SampleSet(2000, d);
			samples[i].generateSample(initialProbabilities[i], false);
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
		
		Graph g1 = assignWeights(samples[0], d);
		Graph g2 = assignWeights(samples[1], d);
		Graph g3 = assignWeights(samples[2], d);
		Graph g4 = assignWeights(samples[3], d);
		Graph mst1 = g1.maximumSpanningTree();
		Graph mst2 = g2.maximumSpanningTree();
		Graph mst3 = g3.maximumSpanningTree();
		Graph mst4 = g4.maximumSpanningTree();
		System.out.println(g1.toString());
		System.out.println(mst1.toString());
		System.out.println(mst2.toString());
		System.out.println(mst3.toString());
		System.out.println(mst4.toString());
	}
}
