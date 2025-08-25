package reference_variables;

public class marks {
	String StudentName;
	int marks;
	public void showdetails() {
		if(marks>=80) {
			System.out.println("excellent");
		}
		else if(marks>=40) {
			System.out.println("Student passed");
		}
		else {
			System.out.println("student failed");
		}
		System.out.println("student Name ="+StudentName);
	}

	public static void main(String[] args) {
		marks s1=new marks();
		s1.StudentName="Pramod";
		s1.marks=90;
		s1.showdetails();

	}

}
