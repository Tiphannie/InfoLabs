package reversepolishnotation;

public interface Stack<E> {
	 public void push (E element);
	 public void pop () throws StackUnderflow;
	 public E top () throws StackUnderflow;
	 public boolean isEmpty ();
	 public void Empty ();
	 public String toString();

	}