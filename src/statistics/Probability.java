package statistics;

public class Probability {

	private double probability;

	public Probability(double probability) {
		super();
		this.probability = probability;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
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
	
	public static double getSampleProbabilityDependent(Sample sample, double estimatedProbs[], int dimensions) {
		double probability = 1.0;
		
		for (int d = 0; d < dimensions; ++d) {
			if (sample.getVector()[d] == 0) {
				if (d != 0) {
					if (sample.getVector()[d-1] == 0) {
						probability *= estimatedProbs[d];
					}
					else {
						probability *= (1-estimatedProbs[d]);
					}
				}
				else {
					probability *= estimatedProbs[d];
				}
			}
			else {
				if (d != 0) {
					if (sample.getVector()[d-1] == 0) {
						probability *= (1-estimatedProbs[d]);
					}
					else {
						probability *= estimatedProbs[d];
					}
				}
				else {
					probability *= (1-estimatedProbs[d]);
				}
			}
		}
		
		return probability;
	}
	
}
