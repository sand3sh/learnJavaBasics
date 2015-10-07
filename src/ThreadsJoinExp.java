
class Add extends Thread {
	int value;
 
	public void run() {
		value = 1 + 2;
		try {
			this.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Add");
	}
}
 
class Mul extends Thread {
	int value;
 
	public void run() {
		value = 1 * 2;
		try {
			this.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Mul");
	}
}

public class ThreadsJoinExp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Add a = new Add(); Mul b = new Mul();
		a.start();
		b.start();
		a.join(); b.join(); //Main thread will wait for a and b to complete since it called for join


		double n = ((double)b.value/a.value);
 
		System.out.println(n);
	}

}
