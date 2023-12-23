package histogram;
import java.io.*;


public class Histogram {
	private FileReader reader;
	private BufferedReader bufferedReader;
	//private FileWriter writer;
	
	public Histogram(String filenameIn) throws FileNotFoundException, IOException{
		//writer = new FileWriter(filenameOut);
		reader = new FileReader(filenameIn);
		bufferedReader = new BufferedReader(reader);
		
		
		
	}
	
	public char getNextChar() throws IOException{
		int i;
		while ((i = bufferedReader.read()) != -1) {
			if(i != '\r') {
				char c = (char) i;
				return c;
			}
		}
		bufferedReader.close();
		return '\0';
	}	
	
	public void printChars() throws IOException {
		try {
			char nextChar = getNextChar();
			while(nextChar != '\0') {
				System.out.print(nextChar + " ");
				nextChar = getNextChar();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Writing a String and an int to a file 
	 * @throws IOException
	 */
	public void writeIntToFile() throws IOException {
		//The file name/path -either is okay 
		File file = new File("/Users/tiphanniebyakuleka/Desktop/InfoLabs/WritingFile");
		PrintWriter pW = new PrintWriter (file);
		 
		int a = 122; 
		
		//writing a String to a file
		pW.println("Hello World! \nNice to meet you \nHope you are well in this fine evening ");
		
		//writing an int to a file
		pW.write(a); 
		pW.write(" \n"); 
		
		 
		pW.close(); 
		System.out.println("\nDone!!\n"); 
		
	}
	
	/**
	 * Writing a float to a file 
	 * @throws IOException
	 */
	public void writeFloatToFile() {
		//The file name/path -either is okay 
	try {
		String path = "/Users/tiphanniebyakuleka/Desktop/InfoLabs/WritingFile"; 
		FileOutputStream fos = new FileOutputStream(path); 
		DataOutputStream dos = new DataOutputStream (fos); 
		
		float b = 5.314f; 
		
		//writing a float to a file
		dos.writeFloat(b); 
		dos.close(); 
		System.out.println("\n \n Done for now!! \n"); 
		
		} catch (IOException e) {
			System.err.println( "\nError writing to file: " + e.getMessage()); 
			e.printStackTrace(); 
			}
		}
	
	/**
	 * Reading in a file character by character, 
	 * counting the frequencies with which each character occurs.
	 * @throws IOException
	 */
	public void countCharacter() throws IOException {
		File file = new File("/Users/tiphanniebyakuleka/Downloads/Infolabreport-documents/sherlock.txt"); //File to be read
		BufferedReader bF = new BufferedReader(new FileReader (file)); 
		
		//create output file and printWriter object 
		File freqText = new File("/Users/tiphanniebyakuleka/Downloads/Infolabreport-documents/character_frequencies.txt");
		PrintWriter pw = new PrintWriter (freqText); 
		
		int nextCharacter; // holds the integer value of the next char read from file 
		char cha = 0; 
		 
		pw.println("The frequency with which each character occurs: \n"); 
		
		int[] count = new int [26]; //of each letter of the alphabet 
		 while ((nextCharacter = bF.read()) != -1) { //loop iterates over the count array 
	          cha = Character.toLowerCase(((char) nextCharacter));
	          if (cha >= 'a' && cha <= 'z')
	          count[cha - 'a']++;
	        }

	        for (int i = 0; i < 26; i++) {
	        	    char ch = (char) (i + 'a'); 
	        		pw.printf("%c = %d\n", ch, count[i]); //prints each letter and its frequency
	           
	        }
		
	        bF.close(); 
	        pw.close(); 
	}
	
	public void justPrintLetters() throws IOException {
		File file = new File("/Users/tiphanniebyakuleka/Downloads/Infolabreport-documents/sherlock.txt"); //File to be read
		BufferedReader bF = new BufferedReader(new FileReader (file)); 
		
		int nextCharacter; // holds the integer value of the next char read from file 
		char cha = 0; 
		 
 
		
		int[] count = new int [26]; //of each letter of the alphabet 
		 while ((nextCharacter = bF.read()) != -1) { //loop iterates over the count array 
	          cha = Character.toLowerCase(((char) nextCharacter));
	           if (cha >= 'a' && cha <= 'z')
	          count[cha - 'a']++;
	        }
		for (int i = 0; i < 26; i++) {
    	    char ch = (char) (i + 'a'); 
    		System.out.printf("\n%c= \n ", ch); //prints each letter and its frequency
       
    }
		bF.close(); 
	}
	
	
}
