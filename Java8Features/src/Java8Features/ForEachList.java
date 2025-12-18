package Java8Features;

import java.util.HashMap;
import java.util.Map;

public class ForEachList {
	public static void main(String[] args) {
//		List<Integer> list=Arrays.asList(10,20,30,40);
//		list.forEach(s1->System.out.println(s1));
		
		
//		List<Integer> list=Arrays.asList(1,20,30,40);
//		list.forEach(s1->{
//			if(s1%2==0)
//			System.out.println(s1);
//		});
		
		Map<Integer,String> map=new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "orange");map.put(3, "Banana");
		map.forEach((key,value)->
		System.out.println(key+"- "+value));
	}

}
