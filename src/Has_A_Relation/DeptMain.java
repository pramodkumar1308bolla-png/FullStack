package Has_A_Relation;


class Teacher{
	String name;
	String Subject;
	public Teacher(String name, String subject) {
		this.name = name;
		Subject = subject;
	}
	void showTeacherDetails() {
		System.out.println("name  : "+ name);
		System.out.println("subject : " + Subject);
		
	}
	
}
class Department{
	String DeptName;
	int DeptId;
	public Department(String deptName, int deptId) {
		DeptName = deptName;
		DeptId = deptId;
	}
	void showDepartmentDetails() {
		System.out.println(" department name : " + DeptName);
		System.out.println("department id : " + DeptId);
		
	}
	
}

public class DeptMain {

	public static void main(String[] args) {
		Department department=new Department("Developer", 123);
		department.showDepartmentDetails();


	}

}
