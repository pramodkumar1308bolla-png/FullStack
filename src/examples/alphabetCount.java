package examples;

public class alphabetCount {
	public static void main(String[] args) {
		String s1="hello hi bye";
		char[] arr1=s1.toCharArray();
		char[] arr2=s1.toCharArray();
		int count=0;
		for(int i=0;i<s1.length()-1;i++) {
			count=0;
			for(int j=0;j<s1.length()-1;j++) {
				if(arr1[i]==arr2[j]) {
					arr2[j]='\0';
					count++;
				}
			}
			if(count>0) {
				System.out.println(arr1[i]+"-"+count);
			}
			
			
		}
		

	}
}
