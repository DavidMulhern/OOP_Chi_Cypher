package ie.gmit.sw;

import java.util.concurrent.*;

// This class allows threads to decrypt
public class MapsToWork implements Callable<String> {
	
	// Private variables, assigned via constructor
	private int key;
	private String encryptedFile;
	
	// Constructor for the 'put maps to work' class
	public MapsToWork(int key, String encryptedFile) {
		super();
		this.key = key;
		this.encryptedFile = encryptedFile;
	}

	// Callable override, the threads will run this and return their attempts
	@Override
	public String call() throws Exception {
		Decrypt de = new Decrypt(key, encryptedFile);
		String ans = de.getCracking();
		return ans;
	}
}
