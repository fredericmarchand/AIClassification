package statistics;

public class Utils {

	public static double findMax(double array[]) {
		double max = Double.MIN_VALUE;

		for (int i = 0; i < array.length; ++i) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static double roundToDecimals(double d, int c) {   
		int temp = (int)(d * Math.pow(10 , c));  
		return ((double)temp)/Math.pow(10 , c);  
	}
	
}
