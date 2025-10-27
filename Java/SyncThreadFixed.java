import java.io.*;
import java.util.*;

class MyThread extends Thread{
    private static int count = 0;

    public synchronized void increment (){
    	try{
		count = count + 10;
		sleep((long)(Math.random() * 5000));
		System.out.println("Value of Count: " + count);
		System.out.println("Thread Name: " + getName());
	}
	catch(Exception err){
		System.out.println("Die");
	}
	} 

	public MyThread (String name){
		super(name);
	}
	public void run(){
		try{
		for (int i=0 ; i<5 ; i++){
		this.increment();
	}
}
	catch(Exception err){
		System.out.println("Error!");
	}
	}

}


public class SyncThreadFixed{
	public static void main(String[] args){
		new MyThread("T1").start();
		new MyThread("T2").start();
	}
}

/*Value of Count: 20
Thread Name: T1
Value of Count: 30
Thread Name: T1
Value of Count: 40
Thread Name: T2
Value of Count: 50
Thread Name: T2
Value of Count: 60
Thread Name: T2
Value of Count: 70
Thread Name: T1
Value of Count: 80
Thread Name: T1
Value of Count: 90
Thread Name: T2
Value of Count: 100
Thread Name: T1
Value of Count: 100
Thread Name: T2*/

//Το πρόβλημα του Race Condition διορθώθηκε!!!//
//Ο Ένας πόρος θα περιμένει τον άλλον να ολοκληρώσει πρώτα ο,τι κάνει, και μετά θα τρέξει δηλαδη//
