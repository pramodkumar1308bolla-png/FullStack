package Java8Features;

public class Mobile {
	private int id;
	private String name;
	private double price;
	private String ram;
	private String company;
	private String color;
	private int camera;
	private int yom;

	

	public Mobile(int id, String name, double price, String ram, String company, String color, int camera, int yom) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.ram = ram;
		this.company = company;
		this.color = color;
		this.camera = camera;
		this.yom = yom;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getRam() {
		return ram;
	}



	public void setRam(String ram) {
		this.ram = ram;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getCamera() {
		return camera;
	}



	public void setCamera(int camera) {
		this.camera = camera;
	}



	public int getYom() {
		return yom;
	}



	public void setYom(int yom) {
		this.yom = yom;
	}



	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", price=" + price + ", ram=" + ram + ", company=" + company
				+ ", color=" + color + ", camera=" + camera + ", yom=" + yom + "]";
	}



	

}