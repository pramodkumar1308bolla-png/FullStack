package AbstractClassMethod;

 abstract class patentRights{
	 int Students;
	 String degree;
	int Teacher;
	 
	 public patentRights(int student, String degree, int teacher) {
		Students = student;
		this.degree = degree;
		Teacher = teacher;
	}

	abstract public void Details();
	void showdetails() {
		System.out.println("Number of students" + Students);
		System.out.println(" Number of Teachers" + Teacher);
	}
 }
 class accept extends patentRights{

	public accept(int student, String degree, int teacher) {
		super(student, degree, teacher);
		
	}

	@Override
	public void Details() {
		double cost=Students*1000+Teacher*2000;
		int total=Students+Teacher;
		if(degree== "B.tech") {
			if(total==5) {
				if(Students>=3 && total==5) {
					System.out.println("Eligible");
					System.out.println("Total cost for applying : " + cost);
				}
				else {
					System.out.println("insufficient number of studens");
				}
			}
			else {
				System.out.println("Total members should be 5");
				
			}
		}
		else {
			System.out.println("Not Eligible(Should be in B.tech/Completed)");
		}
	}
	 
 }
 class teachers extends patentRights{
 
	public teachers(int student, String degree, int teacher) {
		super(student, degree, teacher);
	}

	@Override
	public void Details() {
		double cost=Teacher*2000;
		if(Teacher==5) {
			System.out.println("Tost cost for applying is : " + cost);
			
		}
		else {
			System.out.println("insufficient number of Teachers Should be equals to 5 ");
		}
		
	}
	 
 }

public class Example {

	public static void main(String[] args) {
		accept a=new accept(4, "B.tech", 1);
		a.Details();
		System.out.println("===============================");
		teachers t=new teachers(0, "B.tech", 5);
		t.Details();

	}
}
