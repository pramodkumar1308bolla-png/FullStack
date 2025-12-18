package threads;

public class Runner extends Thread {
	public Runner(String name) {
		super(name);
	}
	public void run() {
		
		for(int i=1;i<=10;i++) {
//			try {
//				Thread.sleep(1000);
//			}catch (InterruptedException e) {
//				// TODO: handle exception
//				System.out.println(Thread.currentThread().getName()+" thread intrupted");
//				break;
//			}
			System.out.println(Thread.currentThread().getName()+" " +i);
			if(Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName()+" got intrupted");
				return;
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		
		Runner t1=new Runner("Thread-1");
		Runner t2=new Runner("Thread-2");
		t1.start();
		t2.start();
//		t1.sleep(10000);
		t1.interrupt();
		t2.interrupt();
	}
}
