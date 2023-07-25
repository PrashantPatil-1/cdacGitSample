package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

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
	private List<Entry> table[];
	public HashTable() {
		table = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			table[i] = new LinkedList<>();
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	public void put(int key, String value) {
		// find slot
		int slot = h(key);
		
		if(!table[slot].isEmpty()) {
			for(Entry ent : table[slot]) {
				if(ent.key == key) {
					ent.value = value;
					return;
				}
			}
		}
		// create entry and add it into linked of slot
		Entry ent = new Entry(key, value);
		table[slot].add(ent);
	}

	public String search(int key) {
		int slot = h(key); // hashcode

		if(!table[slot].isEmpty()) {
			for(Entry ent : table[slot]) {
				if(ent.key == key) {	// equals
					return ent.value;
				}
			}
		}
		return null;
	}
	
}





