public class TwoAccountThreadsDemo {
    public static void main (String[] args) {
	    Account account = new Account(1000);
		
		System.out.println ("Starting Balance: " + account.getBalance());
		
        Thread t1 = new AccountThread("User1", account);
		Thread t2 = new AccountThread("User2", account);
		
		t1.start();
		t2.start();
				
		try {
		t1.join();
		t2.join();
		} catch (InterruptedException e) {
		  System.err.println (e.toString());
		}
		
		System.out.println("Ending Balance: " + account.getBalance());

    }
}
