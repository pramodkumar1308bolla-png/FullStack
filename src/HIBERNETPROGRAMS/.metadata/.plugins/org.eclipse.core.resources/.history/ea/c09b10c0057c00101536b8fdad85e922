package com.jsp.HibernateJPA;

import com.jsp.Entity.Passport;
import com.jsp.Entity.Person;
import com.jsp.Servicelayer.OneToOneService;

public class App {
	public static void main(String[] args) {

		// One To One Mapping - Person -> Passport
		OneToOneService service = new OneToOneService();
		service.createPassport("01/06/2025", "01/06/2035");
		Passport generatedPass = service.getPassportById(1);
		service.registerPerson(new Person("Ron", 21, generatedPass));

		service.createPassport("21/06/2025", "21/06/2035");
		Passport generatedPass2 = service.getPassportById(2);
		service.registerPerson(new Person("Rhea", 25, generatedPass2));

		System.out.println("Details of person with ID 2 : " + service.getPersonById(2));
		System.out.println("All people: " + service.getAllPersons());

		service.updatePerson(2, "Harry", 20);

		service.deletePerson(2);

	}
}