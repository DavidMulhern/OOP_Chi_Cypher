package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.Callable;

public class ChiSquare implements Callable<Double>{
	
	private int key;
	private String encryptedFile;
	Map<Character, Double> expected;
	Map<Character, Integer> occurrences;

	// Constructor
	public ChiSquare(int key, String encryptedFile, Map<Character, Double> expected,
			Map<Character, Integer> occurrences) {
		super();
		this.key = key;
		this.encryptedFile = encryptedFile;
		this.expected = expected;
		this.occurrences = occurrences;
	}

	// This class is not working entirely, I can't seem to return the future double values
	@Override
	public Double call() throws Exception {
		
		double result = 0.0;
		double occVal;
		double expVal;
		double calcVal;
		double tally;
		
		for (Character c : occurrences.keySet())
		{
			// calculations to retrieve "possible" key
			occVal = occurrences.get(c);
			expVal = expected.get(c);
			calcVal = expVal * encryptedFile.length();
			tally = (occVal - calcVal) * (occVal - calcVal) / calcVal;
			result += tally;
			// Working here??? 
			System.out.println("Value: " + result);
		}
		// returning the future result
		return result;
	}

}
