package TypeCasting;

public class Example2 {

	public static void main(String[] args) {
		int Items=3;
		float priceperItem= 199.99f;
		double discount =0.10;
		double TotalPrice=Items*priceperItem;
		double Totaldiscount=TotalPrice*discount;
		double FinalPrice=TotalPrice-Totaldiscount;
		System.out.println("Total items" + Items);
		System.out.println("final amt " + FinalPrice);
		System.out.println("total discount is " + Totaldiscount);
		//Narrowing is applyed to double to int
		int amount=(int) FinalPrice;
		System.out.println("total amount " + amount);
		
		

	}

}
