package finalcalculatorversion;


public class StackAsList implements Stack<Integer> {

	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node top;
	
	public StackAsList() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void empty() {
		top = null;
	}
	
	public void push(Integer obj) {
		Node tmp = new Node(obj);
		tmp.next = top;
		top = tmp;
	}
	
	public Integer pop() {
		if(isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}
		int data = top.data;
		Node tmp = top;
		top = tmp.next;	
		tmp.next = null;
		return data;
	}
	
	public Integer top(){
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
