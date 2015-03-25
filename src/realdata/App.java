package realdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public static void main(String[] args) {
    	String type = TYPE_DISEASE;
    	
    	ArrayList<Data> data = readFile(type);
    	//for (Data d: data) {
    	//	System.out.println(d.toString());
    	//}
    	
    	ArrayList<Integer> thresh = null;
    	
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
    }

}
