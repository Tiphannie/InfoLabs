package setcalculator;

import java.util.ArrayList;

public class SetCalculator {

	QueueAsList operatorQueue; //stores the operators in the set 
	QueueAsList operandQueue; //stores the numbers in the set
	Set set;
	
	public SetCalculator() {
		 operatorQueue = new QueueAsList();
		 operandQueue = new QueueAsList();
		 set = new Set();

	}
	
	public String calculateSet(String str) {
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
				
				if(c == '{' || c == '}' || c == ',') {
					continue;
				}
				
				else if (Character.isDigit(c)) {
					int operand = c - '0';
					operandQueue.enqueue(operand);
				}
				else if(isOperator(c)) {
					while(!operatorQueue.isEmpty()) {
						int operator = operatorQueue.front();
						performCalculation((char) operator);
					}
					if(operatorQueue.isEmpty()) {
						while(!operandQueue.isEmpty()) {
							int operand = operandQueue.front();
							set.add(operand);	
							operandQueue.dequeue();
						}
						operatorQueue.enqueue((int) c);
					}
				}
		

		}
		while(!operatorQueue.isEmpty()) {
			int operator = operatorQueue.front();
			performCalculation((char) operator);
		}
		
		str = set.toString();
		return str;
	}
	
	private void performCalculation(char c) {
		if(c == '+') {
			while(!operandQueue.isEmpty()) {
				int operand = operandQueue.front();
				set.add(operand);	
				operandQueue.dequeue();
			}
			operatorQueue.dequeue();
		}
		
		if(c == '/') {
			while(!operandQueue.isEmpty()) {
				int operand = operandQueue.front();
				set.remove(operand);	
				operandQueue.dequeue();
			}
			operatorQueue.dequeue();
		}
		
		if(c == '\u2229') {
			ArrayList<Integer> arr = new ArrayList<>();
			while(!operandQueue.isEmpty()) {
				int operand = operandQueue.front();
				if(set.contains(operand)) {
					arr.add(operand);
				}
				operandQueue.dequeue();
			}
			operatorQueue.dequeue();
			set = new Set(arr);
		}
		
	}

	private boolean isOperator(Character c) {
        return c == '+' || c == '/' || c == '\u2229';

	}
	
	//check if input is valid
	public boolean isValid(String str) {
		// TODO Auto-generated method stub
		int openBracket = 0;
		int closeBracket = 0;
		
		for(int i = 0; i < str.length();i++) {
			Character c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				continue;
			}
			else if(c == ',') {
				continue;
			}
			else if(c == '{') {
				openBracket++;
			}
			else if(c == '}') {
				closeBracket++;
			}
			else if(isOperator(c)) {
				if(i == 0 || i == str.length() - 1) {
					return false;
				}
				char next = str.charAt(i + 1);
                char prev = str.charAt(i - 1);		
                
                if (next != '{') {
                    return false; 
                }

                if (prev != '}') {
                    return false; 
                }
			}
			else {
				return false;
			}
		}
		return openBracket == closeBracket;
	}
	
}
