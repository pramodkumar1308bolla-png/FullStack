package com.jsp.ListSenerioBased;

import java.util.LinkedHashSet;

class LibraryManagemenet{
	private LinkedHashSet<String> remove;

	public LibraryManagemenet() {
		remove=new LinkedHashSet<String>();

	}
	public void addBooks(String book) {
		remove.add(book);
	}
	public void display() {
		System.out.println("Books in oredr are :");
		for(String book : remove) {
			System.out.println(book);
			
		}
	}
}



public class RemovingDuplicatesInOrder {

	public static void main(String[] args) {
		LibraryManagemenet lib=new LibraryManagemenet();
		lib.addBooks("Time makes a person successful");
		lib.addBooks("Time makes a person ");
		lib.addBooks("Time ");
		lib.addBooks("Time makes a person successful");
		lib.display();
	}

}
