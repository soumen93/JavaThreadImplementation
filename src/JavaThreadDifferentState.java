/**
 * @author I332330
 * There are total 5 different states of a Java Thread. If you are creating a thread
 * it must any of these states. Those different states are-->
 *        i)New
 *       ii)Runnable
 *      iii)Waiting
 *       iv)Timed Waiting
 *       v)Terminated
 * When a thread has been created in java you can know the state of the thread
 * using "currentThread.getState()"
 */
public class JavaThreadDifferentState extends Thread{

	public static void main(String[] args) {
		//Tread1 only created.
		Thread thread1=new Thread();
		
		//printing the current state of the tread1
		System.out.println("As thread one just has beem created, so the state of thread1 is: " +thread1.getState());
		
		//starting the thread1
		thread1.start();
		
		System.out.println("Thread1 has been started, so no the state of the thread1 is: "+thread1.getState());
		
		AnotherThread anotherThread=new AnotherThread();
		anotherThread.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Printing the state of the thread2 after thread.join() has been called :" +thread1.getState());
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("printing the state of the thread2: "+JavaThreadDifferentState.currentThread().getState());
	}
}

class AnotherThread extends Thread{
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}