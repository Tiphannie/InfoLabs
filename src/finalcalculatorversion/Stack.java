package finalcalculatorversion;


public interface Stack<T> {

	public void push(T obj);
	public T pop();
	public boolean isEmpty();
	public void empty();
	public String toString();
	public T top();
		
	
}
