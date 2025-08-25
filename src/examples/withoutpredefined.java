package examples;

public class withoutpredefined {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		int count=0;
		try {
			while(true) {
				int temparr=arr[count];
				count++;
				System.out.println(temparr);
			}
			
			
		}catch (Exception e) {
		}
	}

}
