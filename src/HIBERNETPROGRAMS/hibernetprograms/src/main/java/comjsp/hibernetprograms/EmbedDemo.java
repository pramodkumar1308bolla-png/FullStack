package comjsp.hibernetprograms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		System.out.println("Program starts...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Studentapp s1=new Studentapp();
		s1.setId(104);
		s1.setName("Ankur");
		s1.setCity("patna");
		Certificate certificate=new Certificate();
		s1.setCertificate(certificate);
		certificate.setCourse("IOT");
		certificate.setDuration("2-Months");
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(s1);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

}
