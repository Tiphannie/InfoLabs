package calculator2;

import java.util.Scanner;

public class Postfix {

	StackAsList operandStack;
	StackAsList operatorStack;
	
	public Postfix() {
		operandStack = new StackAsList();
		operatorStack = new StackAsList();
	}
	
	public int evaluate(String pfx) {
		for(int i  = 0; i < pfx.length(); i++) {
			char c = pfx.charAt(i);
			
		
			if(Character.isDigit(c)) {
				int operand = c - '0'; //converting ASCII value to integer value
				operandStack.push(operand);
			}
			else if(isHexaLetters(c)) {
				operandStack.push((int) c);
			}
			
			else if(c == ' ') {
				continue;
			}
			
			else if(isOperator(c)) {
				int operand1 = operandStack.pop();
				if(isHexaLetters((char) operand1)) {
					operand1 = operand1 - 55;
				}
				int operand2 = operandStack.pop();
				if(isHexaLetters((char) operand2)) {
					operand2 = operand2 - 55;
				}
				int result;
				switch(c) {
				case '+':
					result = operand1 + operand2;
					break;
				case '-':
					result = operand2 - operand1;
					break;
				case '*':
					result = operand1 * operand2;
					break;
				case '/':
					result = operand2 / operand1;
					break;
				case '^':
					result = (int) Math.pow(operand2, operand1);
					break;
				default:
					throw new IllegalArgumentException("Invalid operator: " + c);
				}
				operandStack.push(result);
			}
		}
		
		return operandStack.top();
	}
	
	public String infixToPostfix(String ifx) {
//		if(!isValid(ifx)) {
//			throw new IllegalArgumentException("Invalid input string");	
//		}
		String r = "";
		for(int i = 0; i < ifx.length(); i++) {
			char c = ifx.charAt(i);
			
			if(Character.isDigit(c) || isHexaLetters(c)) {
				r = r + c;
			}
			else if( c == ' ') {
				continue;
			}
			else if(c == '(') {
				operatorStack.push((int) c);
			}
			else if( c == ')') {
				while(!operatorStack.isEmpty() && operatorStack.top() != '(') {
					int operator = operatorStack.top();
					r = r + (char) operator;
					operatorStack.pop();
				}
				if(!operatorStack.isEmpty() && operatorStack.top() == '(')
				operatorStack.pop();
			}
			else if( isOperator(c)) {    
				while(!operatorStack.isEmpty() && getPrecedence(operatorStack.top()) >= getPrecedence(c)) {
					int operator = operatorStack.top();
					r = r + (char) operator;
					operatorStack.pop();
				}
				operatorStack.push((int) c);
			}
		}
		while(!operatorStack.isEmpty()) {
			int operator = operatorStack.top();
			r = r + (char) operator;
			operatorStack.pop();
		}
		return r;
	}

	private int getPrecedence(int c) {
		// TODO Auto-generated method stub
		switch((char) c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}	
	}
	
	//check if a char is an operator
	private boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';

	}
	
	//check if a char is hexadecimal letter
	private boolean isHexaLetters(Character c) {
        return Character.toUpperCase(c) == 'A' ||
        	   Character.toUpperCase(c) == 'B' ||
        	   Character.toUpperCase(c) == 'C' ||
        	   Character.toUpperCase(c) == 'D' ||
               Character.toUpperCase(c) == 'E' ||
        	   Character.toUpperCase(c) == 'F';
	}
	
	public boolean isValid(String str) {
		int openBracket = 0;
		int closeBracket = 0;
		for(int i = 0; i < str.length();i++) {
			Character c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				continue;
			}
			else if(c == ' ') {
				continue;
			}
			else if(c == '(') {
				openBracket++;
			}
			else if(c == ')') {
				closeBracket++;
			}
			else if(isOperator(c)) {
				if(i == 0 || i == str.length() - 1) {
					return false;
				}
				char next = str.charAt(i + 1);
                char prev = str.charAt(i - 1);		
                
                if (!Character.isDigit(next) || next != '(') {
                	if(next == ' ') continue;
                    return false; // Operator must be followed by digit or '('
                }

                if (!Character.isDigit(prev) || prev != ')') {
                	if(prev == ' ') continue;
                    return false; // Operator must be preceded by digit or ')'
                }
			}
			else {
				return false;
			}
		}
		return openBracket == closeBracket;
	}
	
	public void infixToConsole(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Infix: ");
		String str = sc.nextLine();
		if(isValid(str)) {
			String postfix = infixToPostfix(str);
			System.out.println("Postfix :" + infixToPostfix(str));
			System.out.println("Result :" + evaluate(postfix));
			}
		else {
			sc.close();
			throw new IllegalArgumentException("Invalid infix: " + str);
		}
		sc.close();
	}
}
