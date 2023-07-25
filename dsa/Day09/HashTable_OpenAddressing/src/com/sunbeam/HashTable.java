package com.sunbeam;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}
	private final int SIZE = 10;
	private Entry table[];
	public HashTable() {
		table = new Entry[SIZE];
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public int h(int k, int i) {
		return (h(k) + i) % SIZE;
	}
	
	public void add(int key, String value) {
		// find slot corresponding to key
		int slot = h(key);
		int i = 1;
		
		// if slot is not empty
		while(table[slot] != null){
			// check for updation of value 
			if(key == table[slot].key) {
				table[slot].value = value;
				return;
			}
			
			slot = h(key, i++);
		}
		
		// Create new entry to be added at slot
		Entry ent = new Entry(key, value);
		// add created entry at slot
		table[slot] = ent;		
	}
	
	public String search(int key) {
		// find slot corresponding to key
		int slot = h(key);
		int i = 1;
		
		while(table[slot] != null){
			if(key == table[slot].key)
				return table[slot].value;
			
			slot = h(key, i++);
		}
		
		// if key is not found
		return null;
	}
	

}







