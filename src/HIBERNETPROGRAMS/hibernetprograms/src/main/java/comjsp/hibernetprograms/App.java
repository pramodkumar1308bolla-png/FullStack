package comjsp.hibernetprograms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Profram starts......" );
        //Step:1-->Create Configuration objects and load hibernate.cfg.xml
        //It tells Hibernate where to find database connection details and entity
        //classes
        Configuration cfg=new Configuration();
        cfg.configure();//Loads 'hibernate.cfg.xml' by default from src/main/resources or root
        //Step:2--->Build SessionFactory from Configuration
        //SessionFactory is a heavyweight object -created only once per application
        SessionFactory factory = cfg.buildSessionFactory();
        //Step:3-->Create a new instance of StudentApp and set values 
        //This is the object we want to save to the database
        Studentapp studentapp=new Studentapp();
        studentapp.setId(101);
        studentapp.setName("Ankur");
        studentapp.setCity("Panta");
        //Print the object to the verify values (calls toString())
        System.out.println(studentapp);
        //Step:4-->Open a session using the factor
        //Session represents a single unit of work (like a DB connection)
        Session session=factory.openSession();
        //Step:5-->Begin a transaction (all DB operations should be wrapped in a transaction)
        session.beginTransaction();
        //Step:6--->Save the object to the database (Hibernate will generate  an INSERT query)
        session.save(studentapp);
        //Step:7-->Commit the transaction (make changes permanent)
        session.getTransaction().commit();
        //Step:8-->Close the session
        session.close();
        System.out.println("Program stops...!");
        
    }

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
