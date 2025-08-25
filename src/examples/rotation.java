package examples;

public class rotation {
	public static void rotate(int[] arr) {
		int temp=arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr[i]=arr[i-1];
		}
		arr[0]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {10,7,3,1,18,5};
		int r=3;
		for(int i=1;i<=r;i++) {
			rotate(arr);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	
}
