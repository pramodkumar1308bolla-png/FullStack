package com.jsp.ExceptionExamples;

class OutOfStockException extends Exception{
	public OutOfStockException(String message) {
		super(message);
	}
}
class product{
	int stock;
	public product(int stock) {
		this.stock=stock;
	}
	public void placeOrder(int quantity) throws OutOfStockException {
		if(quantity<=0) {
			throw new OutOfStockException("Invalid Quantity ");
		}
		if(quantity>stock) {
			throw new OutOfStockException("Insufficient Stock");
		}
		stock = stock - quantity;
		System.out.println("Remaining stock : " + stock);
	}
	
}
public class ExceptionExample2 {

	public static void main(String[] args) {
		product p= new product(7);
		try {
			p.placeOrder(6);
		}
		catch (OutOfStockException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		

	}
 
}
