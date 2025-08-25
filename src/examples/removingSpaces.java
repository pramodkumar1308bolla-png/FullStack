package examples;

public class removingSpaces {
    public static void main(String[] args) {
        String str = "Hello   World   This   is   a   test";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' || (i > 0 && str.charAt(i + 1) != ' ')) {
                result += str.charAt(i);
                
            }
        }
        System.out.println(result);

        
       
    }
}

