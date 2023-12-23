package reversepolishnotation;

public class StackAsList implements Stack {
	private LinkedList top; 
	
	public StackAsList() {
		top = null; 
	}

	
	@Override
	public void push(Object element) {
		LinkedList list = new LinkedList(element); 
		list.setNext(top);
		top = list; 
		
	}

	@Override
	public void pop() throws StackUnderflow {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object top() throws StackUnderflow {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Empty() {
		// TODO Auto-generated method stub
		
	}
	

}
