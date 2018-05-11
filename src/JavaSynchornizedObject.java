/**
 *While working in a multi Threading environment, we need to restict thread access to access any
 *shared object otherwise result may be different than expected.
 *
 * In java you can make an object, a method or a part of method synchronized.
 *But we cannot use java synchronized method in case of variable
 */

//here we will make an obejct synchronized which is shared by multiple thred
public class JavaSynchornizedObject {

	public static void main(String[] args) {
		Sender sender=new Sender();
		senderThread senderThread=new senderThread("Hi Soumen",sender);
		
		senderThread senderThread2=new senderThread("What are you doing",sender);
		
		senderThread.start();
		senderThread2.start();
	}

}

/**
 *creating the senderThread, which responsible to send the message  
 *
 */
class senderThread extends Thread{
	Sender sender;
	String message;
	public senderThread(String message, Sender sender) {
		this.message=message;
		this.sender=sender;
	}
	
	public void run() {
		/**
		 * making the sender as synchronized object as always it can be accessed by only one thread
		 * and when that thread will release the monitor another thread can use that only
		 */
		synchronized (sender) {
			sender.sendMessgae(message);
		}
		
	}
}

/**
 * The sender class which actually send the message
 */
class Sender{
	public void sendMessgae(String message) {
		System.out.println("recive the messgae");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The message: "+message +" has been sent");
		
	}
}
