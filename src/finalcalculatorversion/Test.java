package finalcalculatorversion;


public class Test {
	
	
	public static void main(String[] args) {
		StackAsList stack = new StackAsList();
		stack.push(5);
		stack.push(4);
		System.out.println(stack.top());
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.top());

		// this is to test infixtopostfix method 
		checkInfixToPostfix("(1 + 2) * 3  - 4 ^ 5 + 6");
		
		Postfix pf = new Postfix();
		pf.infixToConsole();
		
	}
	
	public static void checkInfixToPostfix(String infix) {
		System.out.println("Infix: " + infix);
		Postfix pf = new Postfix();
		String postfix = pf.infixToPostfix(infix);
		System.out.println("Postfix: " + postfix);

	}
	
	
}
