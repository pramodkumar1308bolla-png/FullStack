package comjsp.hibernetprograms;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Using_Scanner_Stuapp {

	public static void main(String[] args) {
		System.out.println("Program starts...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Scanner sc = new Scanner(System.in);
		
	}

}
