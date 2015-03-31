package realdata;

import graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import statistics.Probability;
import statistics.Sample;
import statistics.SampleSet;
import statistics.Utils;

public class App {
	
	public static final String TYPE_FLOWER = "files/iris.csv";
	public static final String TYPE_WINE = "files/wine.csv";
	public static final String TYPE_DISEASE = "files/heartDisease.csv";
	
	public static ArrayList<Data> readFile(String fileToParse) {
		
		ArrayList<Data> data = new ArrayList<Data>();
		
		//Input file which needs to be parsed
        BufferedReader fileReader = null;
         
        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
             
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                switch (fileToParse) {
                case TYPE_FLOWER:
                	data.add(new Flower(tokens));
                	break;
                case TYPE_WINE:
                	data.add(new Wine(tokens));
                	break;
                case TYPE_DISEASE:
                	data.add(new HeartDisease(tokens));
                	break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return data;
	}
	
	public static SampleSet dataToSampleSet(ArrayList<Data> data) {
		SampleSet set = new SampleSet(data.size(), data.get(0).getDimensions());
		int i = 0;
		for (Data d: data) {
			set.setSample(i++, d.toSample());
		}
		return set;
	}
	
	public static void classify(int c, int d, SampleSet samples) {
		int fold = 8; //8-fold cross validation
		
		float independentCorrectClassifications = 0;
		float dependentCorrectClassifications = 0;
		
		ArrayList<ArrayList<Sample>> testingSets = new ArrayList<ArrayList<Sample>>();
		
		double[][] estimatedProbabilities = new double[c][d];
		for (int i = 0; i < c; ++i) {
			estimatedProbabilities[i] = samples.getProbabilities(i);
		}
		
		for (int i = 0; i < c; ++i) {
			for (int j = 0; j < d; ++j) {
				System.out.print(estimatedProbabilities[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//cross-validation
		System.out.println("INDEPENDENT CLASSIFICATION");
		for (int f = 0; f < fold; ++f) {

			//testing 
			
			//get testing sets
			for (int i = 0; i < c; ++i) {
				testingSets.add(samples.getTestingSet(f, fold));
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
					System.out.println("Class" + (i+1) + ": " + counts[i] + "/" + samples.getSize()/fold);
				}
				System.out.println("");
				testingSetIndex++;
			}	
			testingSets.clear();
		}
		
		double percentage = (independentCorrectClassifications/samples.getSize());
		System.out.println("Independent Accuracy: " + Utils.roundToDecimals(percentage, 2) + "%\n");
		
		System.out.println("DEPENDENT CLASSIFICATION");
		for (int f = 0; f < fold; ++f) {
		
			//testing 
			
			//get testing sets
			for (int i = 0; i < c; ++i) {
				testingSets.add(samples.getTestingSet(f, fold));
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
					System.out.println("Class" + (i+1) + ": " + counts[i] + "/" + samples.getSize()/fold);
				}
				System.out.println("");
				testingSetIndex++;
			}	
			testingSets.clear();
		}
		
		double percentage2 = (dependentCorrectClassifications/samples.getSize());
		System.out.println("Dependent Accuracy: " + Utils.roundToDecimals(percentage2, 2) + "%\n");
	
		Graph g1 = Graph.assignWeights(samples, d);
		Graph mst1 = g1.maximumSpanningTree();
		System.out.println(g1.toString());
		System.out.println(mst1.toString());

	}

    public static void main(String[] args) {
    	String type = TYPE_DISEASE;
    	
    	ArrayList<Data> data = readFile(type);
    	
    	ArrayList<Double> thresh = null;
    	
    	switch (type) {
    	case TYPE_FLOWER:
    		thresh = Flower.getThresholds(data);
        	break;
        case TYPE_WINE:
        	thresh = Wine.getThresholds(data);
        	break;
        case TYPE_DISEASE:
        	thresh = HeartDisease.getThresholds(data);
        	break;    	
        }
    	
    	for (Data d: data) {
    		d.convertToBinary(thresh);
    	}
    	
    	for (Data d: data) {
    		System.out.println(d.toString());
    	}
    	
    	switch (type) {
    	case TYPE_FLOWER:
    		classify(3, 4, dataToSampleSet(data));
        	break;
        case TYPE_WINE:
        	classify(3, 13, dataToSampleSet(data));
        	break;
        case TYPE_DISEASE:
        	classify(5, 13, dataToSampleSet(data));
        	break;    	
        }
    }

}
