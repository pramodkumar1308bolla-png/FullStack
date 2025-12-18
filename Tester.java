package Java8Features;

public class Tester {
	public static void main(String[] args) {
		
//		Greatings g1=()->" Morning";
//		System.out.println(g1.msg());
		
//		Greatings g1=(x)->x+" Morning";
//		System.out.println(g1.msg("Pramod"));
		
		Arthematic add=(a,b)->a+b;
		Arthematic sub=(a,b)->a-b;
		Arthematic mul=(a,b)->a*b;
		Arthematic div=(a,b)->a/b;
		System.out.println(add.calci(12, 3));
		System.out.println(sub.calci(12, 3));
		System.out.println(mul.calci(12, 3));
		System.out.println(div.calci(12, 3));
	}

}
