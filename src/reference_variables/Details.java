package reference_variables;

public class Details {
	String StudentName;
	int Id;
	String emailId;
	long PhoneNumber;
	 public void showDetails() {
		 System.out.println("StudentName = "+ StudentName);
		 System.out.println("Id = "+Id);
		 System.out.println("Student Email = "+emailId);
		 System.out.println("Student phone number = "+PhoneNumber);
	 }

	public static void main(String[] args) {
		Details s1=new Details();
		s1.StudentName="Riya";
		s1.Id=101;
		s1.emailId="Riya@gmail.com";
		s1.PhoneNumber=1234567890;
		s1.showDetails();
		System.out.println("-----------------------");
		Details s2=new Details();
		s2.StudentName="Riya";
		s2.Id=101;
		s2.emailId="Riya@gmail.com";
		s2.PhoneNumber=1234567890;
		s2.showDetails();
		System.out.println("-----------------------");

	}

}
