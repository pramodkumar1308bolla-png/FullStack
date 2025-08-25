package comjsp.hibernetprograms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class another_Method_UsingStudentApp {

    private SessionFactory factory;
    
  //Step:2--->Build SessionFactory from Configuration
    public void setup() {
        Configuration cfg = new Configuration();
        cfg.configure(); 
        factory = cfg.buildSessionFactory();
    }
    // Step 2: Save a Student 
    public void saveStudent() {
        // Create student object
        Studentapp student = new Studentapp();
        student.setId(101);
        student.setName("Ankur");
        student.setCity("Panta");
        System.out.println(student);

        // Open session and begin transaction
        Session session = factory.openSession();
        session.beginTransaction();

        // Save the object
        session.save(student);

        // Commit and close session
        session.getTransaction().commit();
        session.close();
    }
    
    // Step 3: Close SessionFactory
    public void shutdown() {
       
            factory.close();
        
    }

    public static void main(String[] args) {
        System.out.println("Program starts......");
      //Step:1-->Create Configuration objects and load hibernate.cfg.xml
        another_Method_UsingStudentApp app = new another_Method_UsingStudentApp();
        app.setup();
        app.saveStudent(); 
        app.shutdown();  

        System.out.println("Program stops...!");
    }


    
}

