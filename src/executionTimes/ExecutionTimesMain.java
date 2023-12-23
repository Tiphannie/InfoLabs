package executionTimes;

public class ExecutionTimesMain {
	
	 public static boolean isPrime(int n) {
	    if (n <= 1) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	 }

	

	  public static void main(String[] args) {
	        int[] nValues = {10, 100, 1000, 10000, 100000, 1000000};
	        
	        int[] primeNumbers = {23, 14, 11, 7, 5}; 
	        
	        for (int n : primeNumbers) {
	        	boolean isPrime = isPrime(n); 
	        	System.out.println(" is " + n +  " prime? = " + isPrime); 
	        }
	        System.out.println("\n");

	        // Fragment #1
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                sum++;
	            }
	            System.out.println("Fragment #1 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #2
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    sum++;
	                }
	            }
	            System.out.println("Fragment #2 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #3
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                for (int j = i; j < n; j++) {
	                    sum++;
	                }
	            }
	            System.out.println("Fragment #3 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #4
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                sum++;
	            }
	            for (int j = 0; j < n; j++) {
	                sum++;
	            }
	            System.out.println("Fragment #4 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #5
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n*n; j++) {
	                    sum++;
	                }
	            }
	            System.out.println("Fragment #5 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #6
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < i; j++) {
	                    sum++;
	                }
	            }
	            System.out.println("Fragment #6 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #7
	        for (int n : nValues) {
	            int sum = 0;
	            for (int i = 1; i < n; i++) {
	                for (int j = 0; j < n*n; j++) {
	                    if (j % i == 0) {
	                        for (int k = 0; k < j; k++) {
	                            sum++;
	                        }
	                    }
	                }
	            }
	            System.out.println("Fragment #7 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 

	        // Fragment #8
	        for (int n : nValues) {
	            int sum = 0;
	            int i = n;
	            while (i > 1) {
	                i = i / 2;
	                sum++;
	            }
	            System.out.println("Fragment #8 for n=" + n + ": " + sum);
	        }
	        System.out.println("\n"); 
	    }
	  
	  
}
