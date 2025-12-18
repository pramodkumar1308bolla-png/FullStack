package abhisirQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployerSort {
	public static void main(String[] args) {
		ArrayList<Employee> al = new ArrayList<>();
		al.add(new Employee(101, "Dhana", 25000));
		al.add(new Employee(102, "Anil", 30000));
		al.add(new Employee(103, "Bhavya", 28000));
		al.add(new Employee(104, "Charan", 27000));

		Comparator<Employee> nameofEMployee = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		};
		Collections.sort(al, nameofEMployee);

		for (Employee employee : al) {
			System.out.println(employee);

		}
	}

}
