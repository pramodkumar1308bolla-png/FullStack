package Class_and_object;

public class Equals {
    public static void main(String[] args) {
    	int n = 2120;
    	int temp = 0;
    	boolean flag=false;
    	while(n!=0) {
    		temp=n%10;
    		if(temp==0) {
    			flag=true;
    			break;
    		}
    		n=n/10;
    	}
    	System.out.println(flag==true?"Duck":"Not Duck");
    }
}