/**
 * @author I332330
 *Java Thread is can be implemented by extending Runnable interface too.
 *Where  Runnable interface gives you the capabilities to override the run method not any other method of thread class.
 *So it is the best idea to implements the Runnable interface when only you need to override the
 *Run method in a thread.
 *
 *It also helps you from the overhead of other thread class.
 *
 *But Need to keep in mind that Runnable only a method. if you only call it. to run it in different thread
 *you need to pass it in a thread as a argument. 
 */
public class JavaThreadRunnableInterface {

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			//creating a thread which using the demoThread object as argument
			Thread myThread=new Thread(new ClassImplementsRunnable());
			myThread.start();
		}
	}

}

class ClassImplementsRunnable implements Runnable{

	@Override
	public void run() {
		//run method defines what operation one thread should perform
		System.out.println("The current runninf thread id is: "+Thread.currentThread().getId());
	}
	
}
