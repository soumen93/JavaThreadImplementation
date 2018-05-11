/**
 * @author I332330
 *Thread join is used to put other thread in hold untill the current thread finish it's execution,
 *i.e. if you call thread join on a particular thread then other thread will wait untill it finish
 *its execution. 
 *
 *In thread you also can mention the time in milisec, to instruct how much time the current thread
 *will continue its execution  
 */
public class JavaThreadJoin {
	public static void main(String[] rags) throws InterruptedException {
		UserThread userThread=new UserThread();
		userThread.setName("fristThread");
		userThread.start();
		//untill firstThread finish it's execution no other thread will run 
		userThread.join();
		
		UserThread userThread1=new UserThread();
		userThread1.setName("secondThread");
		userThread1.start();
		//untill firstThread finish it's execution no other thread will run
		userThread1.join();
		
		UserThread userThread2=new UserThread();
		userThread2.setName("thirdThread");
		userThread2.start();
		userThread2.join();
	}
}
/**
 *So from the execution order you can observe that the thread execution order is as they have been 
 *called i.e. first, second,Third 
 *
 */
class UserThread extends Thread {
	public void run() {
		for(int i=0;i<2;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The running thread is:" +currentThread().getName()+ "Printing: "+i);
		}
	}
}
