package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MobileService {

	static List<Mobile> getAllMobiles() {
		List<Mobile> mobileList = new ArrayList<>();
		mobileList.add(new Mobile(107, "Galaxy S22", 74999.99, "12GB", "Samsung", "Green", 108, 2022));
		mobileList.add(new Mobile(108, "iPhone 15 Pro", 129999.99, "8GB", "Apple", "Red", 48, 2023));
		mobileList.add(new Mobile(109, "Pixel 7 Pro", 89999.99, "12GB", "Google", "Black", 50, 2022));
		mobileList.add(new Mobile(110, "OnePlus 11", 64999.99, "16GB", "OnePlus", "Silver", 200, 2023));
		mobileList.add(new Mobile(111, "Xiaomi Mi 12", 39999.99, "12GB", "Xiaomi", "White", 108, 2022));
		mobileList.add(new Mobile(112, "Realme Narzo 50", 17999.99, "6GB", "Realme", "Gray", 48, 2021));
		mobileList.add(new Mobile(113, "Oppo Find X5", 56999.99, "8GB", "Oppo", "Purple", 64, 2022));
		mobileList.add(new Mobile(114, "Vivo X80", 45999.99, "12GB", "Vivo", "Orange", 50, 2022));
		mobileList.add(new Mobile(115, "Asus ROG Phone 6", 79999.99, "16GB", "Asus", "Red", 64, 2022));
		mobileList.add(new Mobile(116, "Motorola Edge 30", 32999.99, "8GB", "Motorola", "Blue", 50, 2022));
		mobileList.add(new Mobile(117, "Samsung Galaxy A52", 22999.99, "6GB", "Samsung", "Blue", 64, 2021));
		mobileList.add(new Mobile(118, "iPhone SE", 39999.99, "4GB", "Apple", "White", 12, 2020));
		mobileList.add(new Mobile(119, "Google Pixel 5a", 34999.99, "6GB", "Google", "Green", 16, 2021));
		mobileList.add(new Mobile(120, "OnePlus Nord 2", 28999.99, "8GB", "OnePlus", "Gray", 50, 2021));
		mobileList.add(new Mobile(121, "Xiaomi Redmi Note 11", 14999.99, "6GB", "BlackBerry", "Black", 48, 2022));
		mobileList.add(new Mobile(122, "Realme C35", 11999.99, "4GB", "Realme", "Green", 50, 2022));
		mobileList.add(new Mobile(123, "Oppo Reno 8", 32999.99, "8GB", "Oppo", "Gold", 64, 2022));
		mobileList.add(new Mobile(124, "Vivo V25", 27999.99, "8GB", "Vivo", "Blue", 64, 2022));
		mobileList.add(new Mobile(125, "Asus Zenfone 8", 49999.99, "8GB", "Asus", "Black", 64, 2021));
		mobileList.add(new Mobile(126, "Motorola G71", 18999.99, "6GB", "Motorola", "Neptune Green", 50, 2022));


		return mobileList;
		
		}
//	void printMobileOfCompany(String Company) {
//		Predicate<String> p1=(str)->str.equals(Company);
//		getAllMobiles().forEach((ele)->{
//			if(p1.test(ele.getCompany())) {
//				System.out.println(ele);
//			}
//		});

//	}

	public static void main(String[] args) {
		List<Mobile> mobile=getAllMobiles();
		
//		->Get all List mobiles who price greater than 5000 and belongs Samsung
		List<Mobile> str1=mobile.stream().filter(m->m.getPrice()>5000 && m.getCompany().equalsIgnoreCase("Samsung")).collect(Collectors.toList());
		System.out.println("Samsung Mobiles >5000 : "+str1);
		System.out.println("============================================================================================================");
		
		
		Set<Mobile> str2=mobile.stream().filter(m->m.getYom()>2018 && m.getColor().equalsIgnoreCase("Red")).map(m->{ m.setPrice(m.getPrice()+10000);
		return m;}).collect(Collectors.toSet());
		System.out.println(str2);
		System.out.println("============================================================================================================");
		
		List<String> str3=mobile.stream().filter(m->m.getPrice()>10000).map(m->m.getCompany()).distinct().collect(Collectors.toList());
	    System.out.println(str3);
		System.out.println("======================================");
		
		
		//Map of mid and name whose yom >2020
		Map<Integer,String> str4=mobile.stream().filter(m->m.getYom()>2021).collect(Collectors.toMap((m)->m.getId(),(m)->m.getCompany()));
		System.out.println(str4);
		System.out.println("====================");
		
		//Sum of Price of all the Samsung Mobiles	
		Double str5=mobile.stream().filter(m->m.getCompany().equalsIgnoreCase("Samsung")).map((m)->m.getPrice()).reduce(0.0,(a,b)->a+b);
		System.out.println(str5);
		System.out.println("======================================");
		System.out.println("============================");
		
		//Company name :{All Mids for every Thing} Hint <String,List<Integer>>
		Map<Object, List<Object>> str6=mobile.stream().collect(Collectors.groupingBy((m)->m.getCompany(),Collectors.mapping((m)->m.getId(),Collectors.toList())));
		System.out.println(str6);
		System.out.println("============");
		
		Map<String,Map<Integer,Double>> str7=mobile.stream().collect(Collectors.groupingBy(Mobile::getCompany,Collectors.toMap(Mobile::getId, Mobile::getPrice)));
		System.out.println(str7);
		
		

		
		
		
	}


	
}
