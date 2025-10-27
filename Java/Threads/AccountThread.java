public class AccountThread extends Thread {
    Account account;
	String client;
    public AccountThread (String client, Account account) {
	    super(client);
		this.account = account;
		this.client=client;
        
    }
    public void run() {
        for (int i = 0; i < 1000; i++) {

            account.deposit(10);
		   
		    try {
		      this.sleep( (long) Math.random()*1000);
		    } catch (InterruptedException ie) {}
		   
		    account.withdraw(10);

        }
        System.out.println("DONE! " + getName());
    }
}
