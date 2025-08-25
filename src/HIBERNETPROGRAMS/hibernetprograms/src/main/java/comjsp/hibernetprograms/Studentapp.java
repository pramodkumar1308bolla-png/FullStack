//Package declaration -This is the folder structure under which the class is stored
package comjsp.hibernetprograms;
//Importing JPA annotations
import javax.persistence.Entity;//Marks this class as entity(a table in the DB)
import javax.persistence.Id;//Specifies the primary key of the entity

//The @Entity annotation marks this class as a Hibernate entity (mapped to a table in DB)
@Entity
public class Studentapp {
	//@Id marks this field as the primary Key of the entity/table
	@Id
	private int Id;
	//'name' and 'city' are the regular fields (columns in the table)
	private String name;
	private String city;
	private Certificate certificate;
	
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	//Parameterized constructors -used when we want to create object with values
	public Studentapp(int id, String name, String city) {
		super();//Calls the constructor of the parent class (object)
		Id = id;
		this.name = name;
		this.city = city;
	}
	//No-argument constructors is REQUIRED by Hibernate/JPA to instantiate the object
	public Studentapp() {
		
	}
	//Getter for 'id' - used to retrieve the ID of the student
	public int getId() {
		return Id;
	}
	//Setter for 'id'-used to set/change the ID of the student
	public void setId(int id) {
		Id = id;
	}
	//Getter for 'name'
	public String getName() {
		return name;
	}
	//Setter for 'Name'
	public void setName(String name) {
		this.name = name;
	}
	//Getter for 'City'
	public String getCity() {
		return city;
	}
	//Setter for 'City'
	public void setCity(String city) {
		this.city = city;
	}
	//toString() method - helpful in debugging, printing student details
	@Override
	public String toString() {
		return "Studentapp [Id=" + Id + ", name=" + name + ", city=" + city + "]";
	}
}
