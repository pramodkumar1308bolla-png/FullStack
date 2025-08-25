package com.jsp.Servicelayer;

import java.util.List;

import com.jsp.DAO.OneToOneDAO;
import com.jsp.Entity.Passport;
import com.jsp.Entity.Person;

public class OneToOneService {
	
	private OneToOneDAO dao = new OneToOneDAO();
	
	public void createPassport(String issueDate, String expiryDate) {
		dao.savePassport(new Passport(expiryDate, issueDate));
	}
	
	public void registerPerson(Person person) {
		dao.savePerson(person);
	}
	
	public Passport getPassportById(int id) {
		return dao.findPassportById(id);
	}
	
	public Person getPersonById(int id) {
		return dao.findPersonById(id);
	}
	
	public List<Person> getAllPersons(){
		return dao.findAllPersons();
	}
	
	public void updatePerson(int id, String name, int age) {
		Person person = dao.findPersonById(id);
		if(person !=null) {
			person.setName(name);
			person.setAge(age);
			dao.updatePerson(person);
		}
	}
	
	public void deletePerson(int id) {
		dao.deletePerson(id);
	}

}
