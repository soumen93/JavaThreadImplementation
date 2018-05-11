/**
 *Java synchronized actually serve the same purpose as the 
 *
 *you can also declare a part of a method as synchronized
 *
 */
//here we will make an obejct synchronized which is shared by multiple thread
public class JavaSynchronizedMethod {

	public static void main(String[] args) {
		Sender1 sender=new Sender1();
		senderThread1 senderThread=new senderThread1("Hi Soumen",sender);
		
		senderThread1 senderThread2=new senderThread1("What are you doing",sender);
		
		senderThread.start();
		senderThread2.start();
	}

}

/**
 *creating the senderThread, which responsible to send the message  
 *
 */
class senderThread1 extends Thread{
	Sender1 sender;
	String message;
	public senderThread1(String message, Sender1 sender) {
		this.message=message;
		this.sender=sender;
	}
	
	public void run() {
			sender.sendMessgae(message);
	}
}

/**
 * The sender class which actually send the message
 */
class Sender1{
	/**
	 *Making this method as synchronized, so that only one thread can access this method at a time.
	 *So now this method will act as a monitor which can be acquire by only one thread and when it
	 *release this then only another thread can access it. 
	 */
	public synchronized void sendMessgae(String message) {
		System.out.println("recive the messgae");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The message: "+message +" has been sent");
		
	}
}
