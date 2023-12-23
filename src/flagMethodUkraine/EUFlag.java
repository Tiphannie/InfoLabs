package flagMethodUkraine;

public class EUFlag {

	public static void main(String[] args) {
		String outputLine;  
		for (int row = 1; row <= 40; row++){      
		    outputLine = "";      
		    for (int column = 1; column <= 40; column++){
		        outputLine = outputLine+determineCharacter (column, row);
		    }      
		    System.out.println (outputLine);
		}  

	}
	
	private static char determineCharacter(int column, int row) {
	    if (row <= 2 || row >38 || column<= 2 || column > 38) {
	        return '?';
	    }
	    int rise = (column + row);
	    if(rise == 41) {
	    	return '+';
	    }
	    if(column == 17 && row < 17) {
	    	return '|';
	    }
	    if(row == 17 && column <17) {
	    	return '-';
	    }
	    if((row + column) % 3 == 0 && row <=16 && column <= 16) {
	    	return '/';
	    }
	    
	    if((row + column) % 3 == 1 && row <=16 && column <= 16) {
	    	return '=';
	    }
	    if(row % 3 == 0 && (row+column) >40) {
	    	return ')';
	    }
	    if(column % 5 == 0 && (row + column) < 41 && (row > 17 || column > 17)) {
	    	return '(';
	    }
	    return ' ';
	}

}
