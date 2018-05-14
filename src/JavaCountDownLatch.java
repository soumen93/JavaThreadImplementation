import java.util.concurrent.CountDownLatch;

import javax.xml.crypto.Data;

/**
 * @author I332330
 *Java countDown Latch is used to control thread execution where one thread only can start execution only after perticular number of tread start it's execution.
 *
 *perfect example is let's say, one server only can start it's exceution when all other per-requisite service is started 
 */

public class JavaCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
	//creating one countdown latch where specifing no of thread must start it's execution before the calling thread start. 
	CountDownLatch latch=new CountDownLatch(3);
	
	Worker worker1=new Worker("worker1", 50, latch);
	Worker worker2=new Worker("worker2", 100, latch);
	Worker worker3=new Worker("worker3", 150, latch);
	
	//starting the thread
	worker1.start();
	worker2.start();
	worker3.start();
	
	//latch is waiting until the latch count come to zero, when each thread start it's execution latch count will decrease by one and when it become 0. current thread then only can start execution 
	 latch.await();
	 
	 System.out.println("Now current thread is running");
	}
}

class Worker extends Thread{
	private String name;
	private int delay;
	private CountDownLatch latch;
	
	public Worker(String name, int delay,CountDownLatch latch ) {
		super(name);
		this.delay=delay;
		this.latch=latch;
	}
	
	public void run() {
		try {
			this.sleep(delay);
			
			System.out.println("Thread: "+this.getName()+ " finish it's execution");
			//decrementing the count of the latch as it's aready finish it's execution
			latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
