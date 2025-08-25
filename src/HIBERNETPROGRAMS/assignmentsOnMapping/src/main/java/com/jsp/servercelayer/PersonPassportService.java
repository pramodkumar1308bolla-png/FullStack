package com.jsp.servercelayer;


import java.util.List;

import com.jsp.Entityies.Passport;
import com.jsp.Entityies.Person;
import com.jsp.OnetoOneDAO.PersonDAO;


public class PersonPassportService {

    private PersonDAO dao = new PersonDAO();

    public void registerPersonWithPassport(String name, String city, int pincode, String passportType, int countries) {
        Passport passport = new Passport();
        passport.setPassportType(passportType);
        passport.setNumberOfCountriesElibile(countries);

        Person person = new Person();
        person.setName(name);
        person.setCity(city);
        person.setPincode(pincode);
        person.setPassport(passport);

        passport.setPerson(person); 

        dao.savePersonWithPassport(person);
    }

    public void registerPassportOnly(String passportType, int countries) {
        Passport passport = new Passport();
        passport.setPassportType(passportType);
        passport.setNumberOfCountriesElibile(countries);
        dao.savePassport(passport);
    }

    public Person fetchPersonById(int id) {
        return dao.getPersonById(id);
    }

    public List<Person> fetchAllPersons() {
        return dao.getAllPersons();
    }

    public Passport fetchPassportById(int id) {
        return dao.getPassportById(id);
    }

    public void updatePerson(int id, String name, String city, int pincode, String passportType, int countries) {
        Person person = dao.getPersonById(id);
        if (person != null) {
            person.setName(name);
            person.setCity(city);
            person.setPincode(pincode);

            Passport passport = person.getPassport();
            if (passport != null) {
                passport.setPassportType(passportType);
                passport.setNumberOfCountriesElibile(countries);
            }

            dao.updatePerson(person);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    public void deletePerson(int id) {
        dao.deletePerson(id);
    }

    public void deletePassport(int id) {
        dao.deletePassport(id);
    }

    public void shutDown() {
        dao.closeFactory();
    }
}

