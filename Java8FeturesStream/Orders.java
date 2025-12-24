package Java8FeturesStream;

public class Orders {

	String name;
	double price;
	int id;
	long phno;
	public Orders(String name, double price, int id,long phno) {
		super();
		this.name = name;
		this.price = price;
		this.id = id;
		this.phno=phno;
	}
	
	
	
	public long getPhno() {
		return phno;
	}



	public void setPhno(long phno) {
		this.phno = phno;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Orders [name=" + name + ", price=" + price + ", id=" + id + ", phno=" + phno + "]";
	}
	
}
