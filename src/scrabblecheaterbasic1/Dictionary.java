package scrabblecheaterbasic1;


import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedReader;


public class Dictionary {

	private final int TABLE_SIZE = 407	;
	private Node[] table;
	
	private int word_counter = 0;
	
	public Dictionary() {
		
	}
	
	
	//initiate hash table
	private void init_hash_table()
	{
		table = new Node[TABLE_SIZE];
	    for(int i = 0; i < TABLE_SIZE; i++)
	    {
	        table[i] = null;
	    }
	    return;
	}
	
//	private int hash(String word) {
//	    int hash = 0;
//	    for (int i = 0; i < word.length(); i++) {
//	        hash += word.charAt(i);
//	    }
//	    return hash % TABLE_SIZE;
//	}
	
	private int hash(String word) {
	    int hash = 0;
	    int chainLength = 0;
	    for (int i = 0; i < word.length(); i++) {
	        hash = (hash * 31 + word.charAt(i)) % TABLE_SIZE;
	    }
	   
	    Node currentNode = table[hash];
	    while(currentNode != null) {
	    	chainLength++;
	    	currentNode = currentNode.next;
	    }
	    if(chainLength > 16) {
	    	hash = (hash + 1) % TABLE_SIZE;
	    }
	    
	    return hash;
	}
	
	public String[] lookup(String word) {
		int index = hash(word);
		int i = 0;
		int length = 0;
		Node currentNode = table[index];
		while(currentNode != null) {
			currentNode = currentNode.next;
			length++;
		}
		
		String[] arrayWord = new String[length];
		currentNode = table[index];
		while(currentNode != null) {
			arrayWord[i] = currentNode.word; 
			currentNode = currentNode.next;
			i++;
		}
		
		for(String s : arrayWord) {
			System.out.println(s);
		}
		return arrayWord;
	}
	

	
	public boolean load() throws IOException {
	    String file = "C:\\Users\\luong\\Downloads\\7_letter_words.csv";
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line;
	    
	    init_hash_table();
	    
	    while ((line = reader.readLine()) != null) {
	        String[] fields = line.split(",");
	        if (fields.length >= 2) {
	            String word = fields[1];
	            
	            Node tmp = new Node(word);
	            // Load the word into the table
	            int index = hash(word);
	            
	            tmp.next = table[index];
	            table[index] = tmp;
	            
	            word_counter++;
	        }
	    }
	    reader.close();
	    return true;
	}
	
	//number of entries
	public int size() {
		return word_counter;
	}
	
	
	public int getNumberOfCollisions() {
		int totalCollisions = 0;
		
		for(Node node : table) {
			if(node != null) {
				Node currentNode = node;
				int collisions = 0;
				while(currentNode.next != null) {
					collisions++;	
					currentNode = currentNode.next;
				}
				totalCollisions += collisions;
			}
		}
		return totalCollisions;	
	}

	public int getLongestChain() {	
		int max = 0;
		for(Node node : table) {
			int length = 0;
			if(node != null) {
				Node currentNode = node;
				while(currentNode.next != null) {
					length++;	
					currentNode = currentNode.next;
				}
			}
			if(length > max) {
				max = length;
			}
		}
		return max;	
	}
	
	public Node[] getTable() {
		return table;
	}
	
	public int getTableSize() {
		return TABLE_SIZE;
	}
	
	public class Node {
		private String word;
		private Node next;
		
		public Node(String word) {
			this.word = word;
			next = null;
		}
		
		public String getWord() {
			return word;
		}
		
		public Node getNext() {
			return next;
		}
	}
		
}

