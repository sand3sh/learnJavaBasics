import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


public class ThreadsBasics {

	static Vector<String> list = new Vector<String>();
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//demoThreadCreation();
		//demoConcurrentModificationExceptions();
		demoRaceCondition();
	}
	
	static void demoThreadCreation(){
		new Thread(new AThread("Thread 1")).start();
		new Thread(new AThread("Thread 2")).start();
		new Thread(new AThread("Thread 3")).start();
	}
	
	static void demoConcurrentModificationExceptions() throws InterruptedException{
		for(int i = 0;i<100;i++){
			new Thread(new AThread("Thread "+i)).start();
		}
		//Thread.sleep(5000);
		
		/*for(String s:ThreadsBasics.list){
			//ThreadsBasics.list.remove(0);
			System.out.println(s);
		}*/
		Iterator<String> CrunchifyIterator = ThreadsBasics.list.iterator();
		while (CrunchifyIterator.hasNext()) {
			System.out.println(CrunchifyIterator.next());
		}
	}
	
	static void demoRaceCondition() throws InterruptedException{
		TwoSums t = new TwoSums();
		for(int i = 0;i<100;i++){
			AThread at = new AThread("Thread "+i);
			at.t=t;
			new Thread(at).start();
		}
	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+t.getSum1());
		
		
	}
	
	
	public static int randInt(int min, int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
class AThread implements Runnable  {

	String name;
	TwoSums t;
	AThread(String name){
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int sec = ThreadsBasics.randInt(1,5)*1000;
			System.out.println(name + " is running for seconds "+sec);
			Thread.sleep(sec);
			t.add(2);
			ThreadsBasics.list.add(name);
			System.out.println(name + " --END-- ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class TwoSums {
    
     int sum1 = 0;
    
    public int getSum1() {
		return sum1;
	}

	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}

	public void add(int val1){
        //synchronized(this){
            this.sum1 += val1;   
        //}
    }
}
