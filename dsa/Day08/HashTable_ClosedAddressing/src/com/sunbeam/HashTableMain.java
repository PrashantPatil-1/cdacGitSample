package com.sunbeam;

public class HashTableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HashTable ht = new HashTable();
		
		ht.put(8, "v1");
		ht.put(3, "v2");
		ht.put(10, "v3");
		ht.put(4, "v4");
		ht.put(6, "v5");
		ht.put(13, "v6");
		ht.put(6, "v100");
		
		String ret = ht.search(6);
		if(ret != null)
			System.out.println("Key is found " + ret);
		else
			System.out.println("Key is not found");
	}

}
