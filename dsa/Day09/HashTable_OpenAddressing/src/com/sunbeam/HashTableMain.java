package com.sunbeam;

public class HashTableMain {

	public static void main(String[] args) {
		HashTable h = new HashTable();
		
		h.add(8, "v1");
		h.add(3, "v2");
		h.add(10, "v3");
		h.add(4, "v4");
		h.add(6, "v5");
		h.add(13, "v6");
		
		String value = h.search(2);
		if(value != null)
			System.out.println("Key is found : " + value);
		else
			System.out.println("Key is not found");
	}

}
