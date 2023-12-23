package triangle;

public class TriangleE {

	public static void main(String[] args) {
		int i , j; 
		int size = 5; 
		
		for(i=1; i<=size; i++) 
		{
			for(j=i; j<=size; j++) {
				System.out.print(" "); 
			}
			for(j=1; j<=i; j++) {

				System.out.print("* ");
			}
			System.out.println(" ");
		}

	}

}