package examples;

import java.util.LinkedHashMap;

public class UsingCollections_Isomorphic {
	public static void main(String[] args) {
		String s="aaaaasdfghsdfdssswsasz";
		LinkedHashMap<Character,Integer> m1=new LinkedHashMap<>();
		for(int i=0;i<s.length();i++) {
			if(m1.containsKey(s.charAt(i))) {
				if(m1.containsKey(s.charAt(i))) {
					m1.put(s.charAt(i), m1.get(s.charAt(i))+1);
				}else {
					m1.put(s.charAt(i), 1);
				}
			}
			for(char key:m1.keySet()) {
				System.out.println(key+"-"+m1.get(key));
			}
		}
	}

}
