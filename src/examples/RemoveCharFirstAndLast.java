package examples;

public class RemoveCharFirstAndLast {
//	public static void main(String[] args) {
//		String s="Jspiders";
//		System.out.println(s);
//		
//		while(s.length()>1) {
//			s=RemoveRight(s);
//			System.out.println(s);
//			s=RemoveLeft(s);
//			System.out.println(s);
//		}
//		
//	}
//	public static String RemoveRight(String s) {
//		return s.substring(0, s.length()-1);
//	}
//	public static String RemoveLeft(String s) {
//		return s.substring(1);
//	}
	
	public static void main(String[] args) {
		String s= "Jspiders";
		int l=0,h=s.length()-1;
		System.out.println(s);
		for(int i=0;i<s.length();i++) {
			if(i%2==0) {
				h--;
			}
			else {
				l++;
			}
			String temp="";
			for(int j=l;j<=h;j++) {
				temp=temp+s.charAt(j);
			}
			System.out.println(temp);
		}
	}
}
