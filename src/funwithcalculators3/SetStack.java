package funwithcalculators3;



public class SetStack implements Stack<Set> {


	public static class Node {
		Set data;
		Node next;
		
		public Node(Set data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node top;
	
	public SetStack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void empty() {
		top = null;
	}
	
	public void push(Set obj) {
		Node tmp = new Node(obj);
		tmp.next = top;
		top = tmp;
	}
	
	public Set pop() {
		if(isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}
		Set data = top.data;
		Node tmp = top;
		top = tmp.next;	
		tmp.next = null;
		return data;
	}
	
	public Set top(){
		if(isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}
		return top.data;
	}
	
	public String toString() {
		String str = "";
		Node tmp = top;
		while(tmp != null) {
			str += tmp.data;
			tmp = tmp.next;
		}
		return str;
	}

	
}
