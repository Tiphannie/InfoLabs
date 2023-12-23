package scrabblecheaterbasic;

import java.util.List;
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader; 

public class Dictionary {
	private int size; //size of the hashtable 
	private List<List<String>> table; 
	private int entries; 
	private int collisions; 
	private int longestChain; 
	
	public Dictionary (int size) {
		this.size = size;
		this.table = new ArrayList<>(size); 
		
		for(int i =0; i< size; i++) {
			table.add(new LinkedList<>()); 
		}
		
		this.entries = 0; 
		this.collisions = 0; 
		this.longestChain = 0; 
		
	}
	
	public void readFile(String filename) {
		try(BufferedReader read = new BufferedReader(new FileReader(filename))){
			String line; 
			while((line = read.readLine()) != null) {
				insert(line.trim()); 
			}
		}catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	
	public void insert(String word) {
        int index = hashFunction(word) % size;
        List<String> bucket = table.get(index);
        if (bucket.contains(word)) {
            collisions++;
        } else {
            entries++;
            bucket.add(word);
            if (bucket.size() > longestChain) {
                longestChain = bucket.size();
            }
        }
    }

	public static boolean isPrime(int n) {
		if(n<=1) {
			return false; 
		}
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(n%1==0) {
				return false; 
			}
		}
		return true; 
	}
	
	private int hashFunction(String word) {
        int hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash += word.charAt(i);
        }
        int prime = closestPrime(16); ; 
        return hash % prime;
    }
	
	
	private int closestPrime(int lengthOfChain) {
        if (isPrime(lengthOfChain)) {
            return lengthOfChain;
        }
        int smaller = lengthOfChain - 1;
        int larger = lengthOfChain + 1;
        while (true) {
            if (isPrime(smaller)) {
                return smaller;
            }
            if (isPrime(larger)) {
                return larger;
            }
            smaller--;
            larger++;
        }
    }
	public int getNumberOfEntries() {
        return entries;
    }

	
    public int getNumberOfCollisions() {
        return collisions;
    }

    
    public int getLongestChain() {
        return longestChain;
    }

}
