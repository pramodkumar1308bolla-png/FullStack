package examples;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "hello";
        String s2 = "lolleh";

        if (isAnagram(s, s2)) {
            System.out.println(s + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s + " and " + s2 + " are not anagrams.");
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();


        Arrays.sort(ch1);
        Arrays.sort(ch2);

       
        return Arrays.equals(ch1, ch2);
    }
}
