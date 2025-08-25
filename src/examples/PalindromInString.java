package examples;

public class PalindromInString {
//	public static void main(String[] args) {
//		String s1 = "hello madam how level hi abba jik gsh";
//		String[] arr = s1.split(" ");
//		int count = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//			String word = arr[i];
//			String reversed = new StringBuilder(word).reverse().toString();
//			if (word.equalsIgnoreCase(reversed)) {
////				System.out.println(word );
//				count++;
//			}
//			System.out.println(word );
//		}
//		
//		System.out.println(count);
//	}
	
		static boolean isPalindrome(String s)
		{
			String rev="";
			for(int i=s.length()-1;i>=0;i--) {
				rev=rev+s.charAt(i);			
			}
			return rev.equals(s);
		}
	
		public static void main(String[] args) {
			String s="aabbaahjkjhyuioallao";
			String LongestSubstring="";
			for(int i=0;i<s.length();i++)
			{
				String temp=""+s.charAt(i);
				for(int j=i+1;j<s.length();j++)
				{
					temp = temp+s.charAt(j);
					if(isPalindrome(temp))
					{
						if(temp.length()>LongestSubstring.length()) {
							LongestSubstring=temp;
							
						}
//						System.out.println(temp);
						
					}
				}
			}
			System.out.println(LongestSubstring);
		}
}

