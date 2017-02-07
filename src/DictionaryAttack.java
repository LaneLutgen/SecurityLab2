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
        startTime = System.currentTimeMillis();
		BufferedReader buffer = null;
		List<String> hashvalue = new ArrayList<String>();
	    String curLine = null;
		
		try{
			buffer = new BufferedReader(new FileReader("/input/hashvalue.txt"));
			
			while ((curLine = buffer.readLine()) != null) {
				hashvalue.add(curLine);
			}
	   	
			buffer = new BufferedReader(new FileReader("/input/"));		//need to add the dictionay filepath here
		
			while ((curLine = buffer.readLine()) != null) {
				int i = hashvalue.indexOf(encryptHashValue(curLine));
			
				if(i != -1){
					finishTime = System.currentTimeMillis();
					elapsedSeconds = (finishTime - startTime)/1000;
					System.out.println();	
					System.out.print("The password for hash value " +hashvalue.get(i)+ " is " +curLine+ ",it takes the program " +elapsedSeconds+ " sec to recover this password");	
					hashvalue.remove(i);
				}
			}
		}
		
		catch(IOException e) {
			//Handle exception 
		}
	}
	
	private static String encryptHashValue(String curLine) {
		
		String hashvalue = null;
		
		try {
			MessageDigest j = MessageDigest.getInstance("MD5");
			byte[] messageDigest = j.digest(curLine.getBytes());
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
