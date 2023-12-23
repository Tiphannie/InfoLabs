package funwithcalculators3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Set {
	private ArrayList<Integer> elements;
	private int size;

	public Set() {
		elements = new ArrayList<Integer>();
		size = 0;
	}
	
	public Set(ArrayList<Integer> arr) {
		elements = arr;
		size = arr.size();
	}
	
	/**
	 * This method checks if set contains an element
	 * @param T element
	 * @return true if yes
	 */
	public boolean contains(Integer element) {
		for(int i = 0; i < size; i++) {
			if(elements.get(i).equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	//add element to set
	public void add(Integer element) {
		if(!contains(element)) {
			elements.add(element);
			size++;
		}
	}
	 //remove element
	 public void remove(Integer element) {
		 if(!isEmpty()) {	 
			 for(int i = 0; i < size ; i++) {
				 if(elements.get(i).equals(element)) {
					 elements.remove(i);
					 size--;
				 }
			 }
		 }
	 }

	
	public int size() {
		return size;
	}
	
	//clear set
	public void clear() {
		elements.removeAll(elements);
		size = 0;
	}
	//check if string is a set
    public boolean isSetString(String str) {
        // Regular expression to match the set format
        String regex = "\\{\\d+(,\\d+)*\\}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        
        for(int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if(Character.isDigit(c)) {
        		add((int) c);
        	}
        }

        return matcher.matches();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < size; i++) {
            sb.append(elements.get(i));

            if (i < size - 1) {
                sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
    }
	
	 
	 public ArrayList<Integer> getArray() {
		 return elements;
	 }
	
	
	
	
	
	
}
