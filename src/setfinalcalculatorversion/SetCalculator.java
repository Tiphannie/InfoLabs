package setfinalcalculatorversion;
import java.util.HashSet; 
import java.util.Set;

public class SetCalculator{
	private Set<Integer>  resultSet; 
	private Set<Integer> temporarySet; 
	
	public SetCalculator() {
		
		resultSet= new HashSet<>(); 
		temporarySet = new HashSet<>(); 
	}
	
	/**
	 * Insert the number to the temporary Set 
	 * @return number
	 */
	
	public void insert(int number) {
		temporarySet.add(number); 
	}
	
	public void count() {
		System.out.println(resultSet.size()); 
	}
	
	/*public boolean isEmpty() {
		return numbers.isEmpty(); 
	}
	
	
	public void delete(int number) {
		numbers.remove(number); 
	}
	
	public boolean member(int number) {
		return numbers.contains(number); 
	}
	
	public int sizeOf() {
		return numbers.size(); 
	}*/
}
