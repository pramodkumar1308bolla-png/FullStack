package examples;

public class StringIsomorphic {
	// String Isomorphic
//    public static boolean isIsomorphic(String s1, String s2) {
//    	int[] S1 = new int[256];
//        int[] S2 = new int[256];
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        
//
//        for (int i = 0; i < s1.length(); i++) {
//            char c1 = s1.charAt(i);
//            char c2 = s2.charAt(i);
//
//            if (S1[c1] != S2[c2]) {
//                return false;
//            }
//
//            if (S1[c1] == 0) {
//                S1[c1] = i + 1;
//                S2[c2] = i + 1;
//            }
//        }
//
//        return true;
//    }
//    public static void main(String[] args) {
//        System.out.println(isIsomorphic("eghhgww", "addcc")); 
//        System.out.println(isIsomorphic("papershhs", "titledd")); 
//        System.out.println(isIsomorphic("foo", "bar"));
//    }
	public static String sequenceCounter(String s) {
		int c = 1;
		String ans = "";
		for (int i = 0; i <s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				c++;

			} else {
				ans = ans + c;
				c = 1;
			}

		}
		ans = ans + c;
		return ans;

	}

	public static void main(String[] args) {
		String s1 = "badc";
		String s2 = "baba";

		if (sequenceCounter(s1).equals(sequenceCounter(s2))) {
			System.out.println("Isomorphic");
		} else {
			System.out.println("Not Isomorphic");
		}

	}
}