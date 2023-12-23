package reversepolishnotation;

public class LinkedList{
	private Object data; 
	private LinkedList next; 
	
	public LinkedList(Object obj){
		data = obj; 
		next = null; 
	}
	
	public LinkedList(Object obj, LinkedList node ) {
		data= obj; 
		next = node; 
	}
	
	public LinkedList getNext() {
		return next; 
	}
	
	public void setNext(LinkedList node) {
		next = node; 
		
	}
	
	

}
