import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author I332330
 *We all know that Java thread we can create in two different way--i)extending the Thread class
 *                                                                ii)implementing the runnable interface
 *But using runnable interface we can return the result so for that we have a diferent implementaion
 *i.e. "Callable".
 *      while extending "Callable" interface you need to overider "call method" as in case of Runnable we do "run"
 * But callable directly cannot be use to create thread.
 * So if you want to use the callable in a thread we need to extend another class called futureTask.
 * 
 *What callable does after performing every task it have to store the result in an object known to main
 *thread so that can know the result the thread return.
 *but the question is how this object can be obtained in future, for that we need the futureTask object
 *whic will store the result not right now but when the callable return the result.
 *     this is one of the way main thred can keep track how other threads and running and retruning the result
 *                           
 */
public class JavaCallabeAndFutureTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//creating an array of future task
		FutureTask[] futureTasks=new FutureTask[5];
		
		for(int i=0;i<5;i++) {
			//creating a callable object
			Callable callable=new CallableObject();
			
			//creating a future task and you need to pass calable object as an argument to the futureTask
			futureTasks[i]=new FutureTask<>(callable);
			
			//we can pass future task as an argument while creating a thread as it implements the 
			//Runnable 
			Thread thread=new Thread(futureTasks[i]);
			
			thread.start();
		}
		
		//obtaing the result using futureTask object which return by the callable object
		for(int i=0;i<5;i++) {
			System.out.println(futureTasks[i].get());
			//.get() method will block till the result is avilable. 
		}
	}
}

class CallableObject implements Callable{

	@Override
	public Object call() throws Exception {
		 Random random=new Random();
		 int num=random.nextInt(5);
		 Thread.sleep(100);
		 return num;
	}
	
}