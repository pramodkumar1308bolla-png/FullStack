package Constructor;

class Hotel{
	String CustomerName;
	int Days;
	String HotelName;
	int no_Guests;
	long AadharNumber;
	long PhoneNumber;
	double cost=1000;
	public Hotel(String customerName, int days, String hotelName, int no_Guests, long aadharNumber, long phoneNumber) {
		CustomerName = customerName;
		Days = days;
		HotelName = hotelName;
		this.no_Guests = no_Guests;
		AadharNumber = aadharNumber;
		PhoneNumber = phoneNumber;
	}
	public void totalCost() {
		double totalcost=no_Guests*Days*cost;
		System.out.println("totalcost:"+totalcost);
		
	}
	public void ShowReservationDetails() {
		
		
	}
	
}
public class Demo {

	public static void main(String[] args) {
		

	}

}
