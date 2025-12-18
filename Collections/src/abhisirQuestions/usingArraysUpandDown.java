package abhisirQuestions;

class product {
	String pname;
	String pBrand;
	double price;

	public product(String pname, String pBrand, double price) {
		super();
		this.pname = pname;
		this.pBrand = pBrand;
		this.price = price;
	}

}

class shampoo extends product {

	shampoo(String pname, String pBrand, double price) {
		super(pname, pBrand, price);

	}

	void shampooDetails() {
		System.out.println("pname :" + pname);
		System.out.println("PBrand :" + pBrand);
		System.out.println("price :" + price);
	}

}

class soap extends product {

	public soap(String pname, String pBrand, double price) {
		super(pname, pBrand, price);

	}

	void soapDetails() {
		System.out.println("pname :" + pname);
		System.out.println("PBrand :" + pBrand);
		System.out.println("price :" + price);
	}

}

class toothBrush extends product {
	public toothBrush(String pname, String pBrand, double price) {
		super(pname, pBrand, price);

	}

	void toothBrushDetails() {
		System.out.println("pname :" + pname);
		System.out.println("PBrand :" + pBrand);
		System.out.println("price :" + price);
	}
}

class productfactory {
	static product getProduct(String input) {
		if (input.equalsIgnoreCase("soap")) {
			return new soap("shampoo", "Head and Sholders", 40);

		} else if (input.equalsIgnoreCase("shampoo")) {
			return new shampoo("soap", "baby soap", 50);
		} else if (input.equalsIgnoreCase("toothBrush")) {
			return new toothBrush("toothBrush", "Colgate", 70);
		} else {
			return null;
		}

	}

}

public class usingArraysUpandDown {
	public static void main(String[] args) {
		String[] s = { "shampoo", "soap", "price" };
		product[] p = new product[s.length];
		for (int i = 0; i <= s.length - 1; i++) {
			p[i] = productfactory.getProduct(s[i]);
			if (p[i] != null) {
				if (p[i] instanceof shampoo) {
					shampoo s1 = (shampoo) p[i];
					s1.shampooDetails();
				} else if (p[i] instanceof soap) {
					soap s2 = (soap) p[i];
					s2.soapDetails();
				} else {
					toothBrush t = (toothBrush) p[i];
					t.toothBrushDetails();
				}
			} else {
				System.out.println("invalid input need to give");
			}
		}

	}

}
