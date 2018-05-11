package JavaThreadPool;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author I332330
 *Java Thread-pool is used to restrict program to create unnecessary thread when already thread is avilable.
 *This helps also helps to maintain the performance of a applocation otherwise too many thread creation may cause on application performance.
 *
 *Thread-pool is a capabilities that provided by the JAVA "executor-service" which is a sub interface of java "Executors" interface.
 *
 *you can create a java thread poll in types--i) fixed size thread pool i.e. Executor.newFixedThreadPol(int size);
 *                                           ii) thread pool which will increase if required otherwise it will use existing threads i.e. Executor.newCachedThreadPool();
 *                                          iii)Single Threaded Thread pool i.e Executor.newSingleThreadPool();
 *                                          
 *You have to pass runnable object to the threadPoolExcutor to execute the runnable i.e. threadPoolObject.execute(runnableObject);
 */

/**
 *There is some disadvantage of using thread-poll is 
 *   i) deadlock: of thread using the threadpool threads for long time then other task will be in the queue for ever.
 *  ii)Thread-Leakage: while using thread-pool you should alawys handle the exception otherwise, if one stopped abruptly due to some exception then the thread will be destroy from the thread-poll
 *              for ever. So it may lead to state when no other thread is avilable but some task yet to be executed. which never going to be executed as there is to thread left.  
 *
 */
public class JavaFixedThreadPool {
	public static void main(String[] args) {
		//creating the runnable objects which need to pass when in the thread pool executor  
		 Runnable printCount1=new Calculate("Thread NO:1");
		 Runnable printCount2=new Calculate("Thread NO:2");
		 Runnable printCount9=new Calculate("Thread NO:9");
		 Runnable printCount3=new Calculate("Thread NO:3");
		 Runnable printCount4=new Calculate("Thread NO:4");
		 Runnable printCount5=new Calculate("Thread NO:5");
		 Runnable printCount6=new Calculate("Thread NO:6");
		 Runnable printCount7=new Calculate("Thread NO:7");
		 Runnable printCount8=new Calculate("Thread NO:8");
		
		//creating a thread-pool with max thread size of 3.
		//To create a threadpool you have to use executors interface which will actually return am object of type ExceutorService
		ExecutorService threadPool=Executors.newFixedThreadPool(3);
		
		//running the threads and executing runnable objects
		threadPool.execute(printCount1);
		threadPool.execute(printCount8);
		threadPool.execute(printCount3);
		threadPool.execute(printCount4);
		threadPool.execute(printCount6);
		threadPool.execute(printCount5);
		threadPool.execute(printCount7);
		threadPool.execute(printCount9);
		threadPool.execute(printCount2);
		
		//after executing the operation you need to shutdown the thread-pool
		threadPool.shutdown();
	}
}

class Calculate implements Runnable{
	private String threadNo;
	
	public Calculate(String threadNo) {
		this.threadNo=threadNo;
	}
	
	@Override
	public synchronized void run() {
		
		System.out.println("\n\nThe running ThreadNameIs: "+threadNo);
		Date date=new Date();
		System.out.println("Current System time is: "+date);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
