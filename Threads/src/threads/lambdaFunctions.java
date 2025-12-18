package threads;

import java.time.LocalDateTime;
import java.util.Random;

interface status{
	public void SystemStatus();
}

public class lambdaFunctions {
	public static void main(String[] args) {
		
		status s=()->{
			System.out.println("System is running smoothly");
			
			
			
		};
		s.SystemStatus();
		
		status s1=()->{
			Random r=new Random();
			int show=(int) (Math.random()*(10000));
			
			System.out.println(show);
		};
		s1.SystemStatus();
		
		status s2=()->{
			System.out.println(LocalDateTime.now());
			
			
			
		};
		s2.SystemStatus();
		
		
	}

}
