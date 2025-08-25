package com.jsp.ListSenerioBased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Library{
	private List<String> books;
	
	public Library() {
		books = new ArrayList<String>();
	}
	public void addbooks(String bookNames) {
		books.add(bookNames);
	}
	public void display() {
		if(books.isEmpty()) {
			System.out.println("NO books are there in library");
		}
		for(String book:books) {
			System.out.println(book);
		}
	}
	public void removebook(int index) {
		if(index>=0 && index<books.size()) {
			books.remove(index);
			System.out.println("Book is removed at index no : " + index);
		}
		else {
			System.out.println("Invalid index");
		}
	}
	public void sortbooks() {
		Collections.sort(books);
		System.out.println("Books are in alphabetical Order");
	}
}

public class realtime {

	public static void main(String[] args) {
		Library library=new Library();
		
		library.addbooks("Srujana");
		library.addbooks("Hema");
		library.addbooks("Pramod");
		library.addbooks("Anu");
		library.addbooks("Varsha");
		
		library.display();
		System.out.println("After adding Books");
		System.out.println("--------------------------");
		
		library.removebook(3);
		library.display();
		System.out.println("Afetr removing ");
		System.out.println("=====================");
		
		library.sortbooks();
		System.out.println("sorting done ");
		
		
		
	

	}

}
