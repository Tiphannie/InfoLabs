package histogram;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		final String filename = "/Users/tiphanniebyakuleka/Desktop/Labhisto/RandomTextFile";
		//final String filename2 = "/Users/tiphanniebyakuleka/Desktop/InfoLabs/WritingFile";
		Histogram histogram = new Histogram(filename); 
		histogram.writeIntToFile();
		histogram.printChars();
		histogram.writeFloatToFile(); 
		histogram.countCharacter();
	    histogram.justPrintLetters(); 
	}
}
