package Java8Features;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateAndTimeApi {
	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());

		LocalDate d= LocalDate.of(2025, 8, 15);
		System.out.println(d);
		
		LocalTime t=LocalTime.of(23, 00);
		System.out.println(t);
		
		LocalDate ld=LocalDate.of(2024,1,1);
		System.out.println(ld.isLeapYear());
		
	

		System.out.println(LocalDate.now().plusDays(30));

		System.out.println(LocalDate.now().minusDays(30));
		System.out.println(LocalDate.now().minusMonths(6));
		
		LocalDate d1= LocalDate.of(2025, 1, 5);
		System.out.println(d.compareTo(d1));
		
		//age based on date of birth
		LocalDate db= LocalDate.of(2002, 8, 15);
		
		Period p=Period.between(db, LocalDate.now());
		System.out.println(p.getYears());
		
		//formating date
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		System.out.println(LocalDate.now().getMonth());
		
		LocalTime t1=LocalTime.of(23, 00);
		
		Duration du=Duration.between(LocalTime.now(), t1);
		System.out.println(du.toHours());
		//add 45 min to current time
		System.out.println(LocalTime.now().plusMinutes(45));
		
		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
		
		
//		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		
		
		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		
		
		System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
		
		
		//employe had joined 
		//online booking allows cancilation only 24 hrs for cancillation check cancilation is allowed or not
		
		//poduct has a warenty of one year from purchase date write a program to check the product is under warenty
		//A company process sal on the first monday of every month write a program to find the first monday of current month
		//to find the next working day if today is weakend
		//validate give date string is valid or not
		//write a p to find the number of weaknedns in given date
		
		

		
		


		
	

	}

}
