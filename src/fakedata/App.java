package fakedata;

import graph.Graph;

import java.util.ArrayList;
import java.util.Random;

import statistics.Probability;
import statistics.Sample;
import statistics.SampleSet;
import statistics.Utils;

public class App {
	
	public static final boolean INDEP = true;
	public static final boolean DEPEN = false;
	
	//Assumption: probabilities given parent=1 are 1-probability
	//Assumption: trees are linear the root is the start of the list and the parent of each is the one with index-1
	public static void main(String[] args) {
		int fold = 8; //8-fold cross validation
		int d = 10;	  //d-dimensional feature space
		int c = 4;    //c = classes
		
		float independentCorrectClassifications = 0;
		float dependentCorrectClassifications = 0;
		
		Probability[][] initialProbabilities = new Probability[c][d];
		ArrayList<ArrayList<Sample>> testingSets = new ArrayList<ArrayList<Sample>>();
		Random r = new Random();
		SampleSet[] samples = new SampleSet[c];
		
		for (int j = 0; j < c; ++j) {
			for (int i = 0; i < d; ++i) {
				double prob = Utils.roundToDecimals(r.nextDouble() % 1, 2);
				if (prob == 0.5)
					prob += 0.01;
				initialProbabilities[j][i] = new Probability(prob);
				System.out.print(initialProbabilities[j][i].getProbability() + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < c; ++i) {
			samples[i] = new SampleSet(2000, d);
			samples[i].generateSample(initialProbabilities[i], DEPEN);
		}
		
		//cross-validation
		System.out.println("INDEPENDENT CLASSIFICATION");
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
			int testingSetIndex = 0;
			for (ArrayList<Sample> list: testingSets) {
				int[] counts = new int[c];
				
				for (Sample sample: list) {
					//classify
					double probs[] = new double[c];
					for (int i = 0; i < c; ++i) {
						probs[i] = Probability.getSampleProbability(sample, estimatedProbabilities[i], d);
					}
					
					double max = Utils.findMax(probs);
					for (int i = 0; i < c; ++i) {
						if (max == probs[i]) {
							counts[i]++;
							sample.set_class(i+1);
							if (testingSetIndex == i) {
								independentCorrectClassifications++;
							}
							break;
						}
					}
				}
				for (int i = 0; i < c; ++i) {
					System.out.println("Class" + (i+1) + ": " + counts[i] + "/" + samples[i].getSize()/fold);
				}
				System.out.println("");
				testingSetIndex++;
			}	
			testingSets.clear();
		}
		
		double percentage = (independentCorrectClassifications/8000);
		System.out.println("Independent Accuracy: " + Utils.roundToDecimals(percentage, 2) + "%\n");
		
		System.out.println("DEPENDENT CLASSIFICATION");
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
			int testingSetIndex = 0;
			for (ArrayList<Sample> list: testingSets) {
				int[] counts = new int[c];
				
				for (Sample sample: list) {
					//classify
					double probs[] = new double[c];
					for (int i = 0; i < c; ++i) {
						probs[i] = Probability.getSampleProbability(sample, estimatedProbabilities[i], d);
					}
					
					double max = Utils.findMax(probs);
					for (int i = 0; i < c; ++i) {
						if (max == probs[i]) {
							counts[i]++;
							sample.set_class(i+1);
							if (testingSetIndex == i) {
								dependentCorrectClassifications++;
							}
							break;
						}
					}
				}
				for (int i = 0; i < c; ++i) {
					System.out.println("Class" + (i+1) + ": " + counts[i] + "/" + samples[i].getSize()/fold);
				}
				System.out.println("");
				testingSetIndex++;
			}	
			testingSets.clear();
		}
		
		double percentage2 = (dependentCorrectClassifications/8000);
		System.out.println("Dependent Accuracy: " + Utils.roundToDecimals(percentage2, 2) + "%\n");
	
		Graph g1 = Graph.assignWeights(samples[0], d);
		Graph g2 = Graph.assignWeights(samples[1], d);
		Graph g3 = Graph.assignWeights(samples[2], d);
		Graph g4 = Graph.assignWeights(samples[3], d);
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
