import java.io.*;

public class DictionaryAttack {

	private static final String passOne = "6f047ccaa1ed3e8e05cde1c7ebc7d958";
	private static final String passTwo = "275a5602cd91a468a0e10c226a03a39c";
	private static final String passThree = "b4ba93170358df216e8648734ac2d539";
	private static final String passFour = "dc1c6ca00763a1821c5af993e0b6f60a";
	private static final String passFive = "8cd9f1b962128bd3d3ede2f5f101f4fc";
	private static final String passSix = "554532464e066aba23aee72b95f18ba2";
	
	private static long startTime;
	private static long finishTime;
	
	public static void main(String[] args) {
		//Receive dictionary file via command line arg
		String dictFilePath = null;
		BufferedReader buffer;
		
		if(args.length > 0)
		{
			dictFilePath = args[0];
		}
		
		if(dictFilePath != null)
		{
			//If dictionary file was entered, attempt to parse it
			try
			{
				buffer = new BufferedReader(new FileReader(dictFilePath));
				
				String curLine;
				while ((curLine = buffer.readLine()) != null) 
				{
					//Apply MD5 algorithm and check if a password is found in the dictionary
				}
			}
			catch(IOException e)
			{
				System.err.println("Dictionary file was not found. Please enter the file path as a command line arg.");
			}
			
		}
		else
		{
			System.err.println("Dictionary file was not found. Please enter the file path as a command line arg.");
		}
		
		// TODO Auto-generated method stub
		String resolvedOne = resolvePassword(passOne);
		String resolvedTwo = resolvePassword(passTwo);
		String resolvedThree = resolvePassword(passThree);
		String resolvedFour = resolvePassword(passFour);
		String resolvedFive = resolvePassword(passFive);
		String resolvedSix = resolvePassword(passSix);
	}
	
	private static String resolvePassword(String password)
	{
		//Timer starts here
		startTime = System.currentTimeMillis();
		
		
		
		//Timer ends here
		finishTime = System.currentTimeMillis();
		float elapsedSeconds = ((float)(finishTime - startTime)/1000.0f);
		System.out.println("Program took "+elapsedSeconds+" seconds to recover this password.");
		return null;
	}
}
