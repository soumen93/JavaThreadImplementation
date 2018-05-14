import java.util.concurrent.Semaphore;
/**
 * @author I332330
 *
 *Semaphore is a concurrency mechanism provided by the Java in the java.util.concurrecncy package. Which can be used as a lock to ensure synchronization of accessing a shared variable.
 *
 *i) Initially the semaphore count is 0. so if any thread wants to access the lock , it can enter and use the shared variable.When a thread access the lock, semaphore will increase it's value to 1.
 *         So no other thread will grant the permission to enter the block. They are in blocked state.
 * ii)Once one thread finish it's execution, it will release the lock and then other blocking thread can access the lock and can use the shared resource.
 * 
 * iii)you can create a semaphore object and pass with the thread objects that need to be synchronized and then it will takes care of the synchronization
 *           
 */

class Shardresource{
	public static int variable=0;
}

class MyThread extends Thread{
	public String name;
	public Semaphore sem;
	
	public MyThread(String name,Semaphore sem){
		super(name);
		this.name=name;
		this.sem=sem;
	}
	
	public void run() {
		if(this.getName().equals("Thread-1")) {
			System.out.println("Thread-1 waiting for permission");
			
			try {
				
				//need to acquire semaphore lock before using the thread 
				sem.acquire();
				
				System.out.println("Thread-1 get the lock");
				
				for(int i=0;i<3;i++) {
					System.out.println(Shardresource.variable);
					Shardresource.variable++; 
				}
				
				Thread.sleep(50);
				//after performing the operation current thread need to release the lock
				sem.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			
			System.out.println("Thread-2 waiting for permission");
			try {
				//need to acquire semaphore lock before using the thread 
				sem.acquire();
				
				System.out.println("Thread-2 get the lock");
				
				for(int i=0;i<3;i++) {
					System.out.println(Shardresource.variable);
					Shardresource.variable--;
				}
				
				Thread.sleep(50);
				
				//after performing the operation current thread need to release the lock
				sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}

public class JavaSemaphoreImplementation {
	public static void main(String[] args) throws InterruptedException {
		//creating a semaphore object
		//only 1 permission is allowed to access the share resource
		Semaphore sem=new Semaphore(1);
		
		//creating two thread which will run synchroneously using semaphore
		MyThread firstThread=new MyThread("Thread-1",sem);
		MyThread secondThread=new MyThread("Thread-2",sem);
		
		//starting the thread
		firstThread.start();
		secondThread.start();
		
		//main thread is waiting to complete the operation of child thread
		firstThread.join();
		secondThread.join();
		
		System.out.println("shared object count should be zero at the end of the exceution. Shared object count is:"+Shardresource.variable);
		
	}
}
