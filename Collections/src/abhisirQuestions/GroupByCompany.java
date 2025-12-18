package abhisirQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupByCompany {
	public static void main(String[] args) {

		ArrayList<Employe> empList = new ArrayList<>();

		empList.add(new Employe(101, "Anil", "TCS", 30000));
		empList.add(new Employe(102, "Bhavya", "Infosys", 35000));
		empList.add(new Employe(103, "Charan", "TCS", 40000));
		empList.add(new Employe(104, "Dhana", "Wipro", 32000));
		empList.add(new Employe(105, "Esha", "Infosys", 37000));

		Map<String, ArrayList<Employe>> map = new HashMap<>();

		for (Employe e : empList) {

			if (map.containsKey(e.company)) {
				map.get(e.company).add(e);
			} else {
				ArrayList<Employe> list = new ArrayList<>();
				list.add(e);
				map.put(e.company, list);
			}
		}

		for (Map.Entry<String, ArrayList<Employe>> entry : map.entrySet()) {
			System.out.println("Company: " + entry.getKey());
			for (Employe e : entry.getValue()) {
				System.out.println("   " + e);
			}
		}
	}
}
