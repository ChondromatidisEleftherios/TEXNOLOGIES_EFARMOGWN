public class Account {
    private int balance = 0;
	
	Account(int balance) {
	  this.balance = balance;
	}
	
	public synchronized void deposit (int ammount) { //Synchronized Method
	  balance = balance + ammount;
	}
	
	public synchronized void withdraw(int ammount) { //Synchronized Method
	  balance = balance - ammount;
	}
	
	public int getBalance() {
	  return balance;
	}

}
