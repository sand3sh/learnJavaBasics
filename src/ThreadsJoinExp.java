import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Add a = new Add(); Mul b = new Mul();
		a.start();
		b.start();
		a.join(); b.join(); //Main thread will wait for a and b to complete since it called for join


		double n = ((double)b.value/a.value);
 
		System.out.println(n);
		// Creates a pool of threads which you can add
		ExecutorService executor = Executors.newCachedThreadPool();
		Future fut1 = executor.submit(new Add());
		executor.submit(new Mul());
		executor.shutdown();
		//
		System.out.println(fut1.get());
		System.out.println("All done");
	}

}
