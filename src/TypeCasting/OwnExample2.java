package TypeCasting;

public class OwnExample2 {

	public static void main(String[] args) {
		int noOfStudents=5;
		int noOfTeachers=2;
		float StudentPrice=noOfStudents*999.96f;
		float TecacherPrice=noOfTeachers*1999.97f;
		double GST=0.20;
		double totalPrice=StudentPrice+TecacherPrice;
		double FinalPrice=totalPrice*GST;
		System.out.println("no students" + noOfStudents);
		System.out.println("no Teachers" + noOfTeachers);
		System.out.println("price of students is " + StudentPrice);
		System.out.println("price of teachers is " + TecacherPrice);
		System.out.println("total price " + totalPrice);
		System.out.println("total price after Gst " + GST);
		int totalamount=(int) FinalPrice;
		System.out.println("totalamount is " + totalamount);
		
		
		
		
		

	}

}
