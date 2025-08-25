package comjsp.hibernetprograms;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class app2 {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Project started");
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Studentapp studentapp=new Studentapp();
		studentapp.setId(103);
		studentapp.setName("Romith");
		studentapp.setCity("Kolkata");
		System.out.println(studentapp);
		
		//create object of aaddress class
		Address ad= new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.34);
		
		//reading image
		FileInputStream fis=new FileInputStream("src/main/java/img.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(studentapp);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}
	

}

