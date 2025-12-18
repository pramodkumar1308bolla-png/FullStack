package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo1 {
	public static void main(String[] args) {
		ArrayList<Employee> l1 = new ArrayList<Employee>();
		l1.add(new Employee("abc", 123, 123456));
		l1.add(new Employee("abd", 123, 123456));
		l1.add(new Employee("abe", 123, 123456));
		l1.add(new Employee("aba", 123, 123456));

		Comparator<Employee> c1 = (Employee e1, Employee e2) -> {
			return e1.sal-e2.sal;
		};
		Collections.sort(l1, c1);
		for (Employee ele : l1) {

			System.out.println(ele);

		}
	}

}
