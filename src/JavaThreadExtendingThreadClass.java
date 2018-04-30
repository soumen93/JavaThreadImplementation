/**
 * @author I332330
 *One of the way to create thread in java is to extending the thread class
 * i)extending thread class will give you other flexibility like using join() and other thread methods.
 * 
 * ii)But if you are extending thread class then you can't extend any other class.
 * 
 * iii)In a thread 'thread.start()' actually call the the "thread.run()" method so if you call 
 *     'thread.run()' instead of 'thread.start()' it will not create any other thread.
 *      it will run only on single thread
 */
public class JavaThreadExtendingThreadClass {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
		DemoThread demoThread=new DemoThread();
		demoThread.start();
		}
	}

}

class DemoThread extends Thread {
	public void run() {
		System.out.println("Thee running thread id is: "+currentThread().getId());
	}
}