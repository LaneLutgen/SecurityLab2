import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryAttack {

	public static void main(String[] args) {		
		
		double startTime;
    	double finishTime;
    	double elapsedSeconds;
		BufferedReader buffer = null;
		List<String> hashvalue = new ArrayList<String>();
	 	String curLine = null;
		
		try {
			String inputFilePath = null;
			String dictionaryFilePath = null;
			
			if(args.length > 0)
			{
				inputFilePath = args[0];
			}
			else
			{
				//If no command args are provided, assume the file is in the same directory as the source
				inputFilePath = "hashvalue.txt";
			}
			
			if(args.length > 1)
			{
				dictionaryFilePath = args[1];
			}
			else
			{
				//If no command args are provided, assume the file is in the same directory as the source
				dictionaryFilePath = "dictionary.txt";
			}
			
			buffer = new BufferedReader(new FileReader(inputFilePath));
			
			while ((curLine = buffer.readLine()) != null) {
				hashvalue.add(curLine);
			}
	   	
			buffer = new BufferedReader(new FileReader(dictionaryFilePath));		//need to add the dictionary filepath here
			startTime = System.currentTimeMillis();
			while ((curLine = buffer.readLine()) != null) {
				int i = hashvalue.indexOf(encryptHashValue(curLine));
			
				if(i != -1) {
					finishTime = System.currentTimeMillis();
					elapsedSeconds = (finishTime - startTime)/1000;
					System.out.println();	
					System.out.print("The password for hash value " +hashvalue.get(i)+ " is " +curLine+ ",it takes the program " +elapsedSeconds+ " sec to recover this password");	
					hashvalue.remove(i);
					startTime = System.currentTimeMillis();
				}
			}
		}
		
		catch(IOException e) {
			//Handle exception 
			System.err.println("Error occured. Please enter the file paths as command line arguments");
			System.err.println("args[0] = Input File Path, args[1] = Dictionary File Path");
		}
	}
	
	private static String encryptHashValue(String curLine) {
		
		String hashvalue = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(curLine.getBytes());
			BigInteger k = new BigInteger(1,messageDigest);
			hashvalue = k.toString(16);
			
			while(hashvalue.length()<32) {
				hashvalue = "0" + hashvalue;
			}
		}
		 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashvalue;
	}
}
