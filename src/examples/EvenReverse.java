package examples;

public class EvenReverse {

	public static void main(String[] args) {
		String s1 = "hello madam how level hi abba jik gsh";
        String[] arr = s1.split(" ");
        int Count = 0;

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equalsIgnoreCase(reversed)) {
                System.out.println(word);
                Count++;
            }
        } 

        System.out.println(Count);
    }

}
