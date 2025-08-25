package com.jsp.JavaAssignmentQues;



import java.util.ArrayList;
import java.util.List;

class DuplicateStrings {
    private List<String> stringList;

    public DuplicateStrings() {
        stringList = new ArrayList<String>();
    }

    public void addElement(String element) {
        stringList.add(element);
    }

    public void display() {
		System.out.println("oder are :");
		for(String element : stringList) {
			System.out.println(element);
			
		}
	}

}

public class ArayaListFirstQuestion {
    public static void main(String[] args) {
        DuplicateStrings duplicates = new DuplicateStrings();
        duplicates.addElement("Apple");
        duplicates.addElement("Banana");
        duplicates.addElement("Apple");
        duplicates.addElement("Cherry");
        duplicates.addElement("Banana");
        duplicates.display();
    }
}