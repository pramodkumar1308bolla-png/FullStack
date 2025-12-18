package Java8Features;

import java.util.Optional;

public class OptionalBasic {
	public static void main(String[] args) {
//		String name="Omi";
		Optional<String> s1=Optional.ofNullable(null);
//		s1.ifPresent(v1->System.out.println(v1));
		System.out.println(s1.orElse("there is a null"));
		System.out.println(s1.orElseGet(()->"there is a null"));
		System.out.println(s1.isEmpty()+"Not present");
	}

}
