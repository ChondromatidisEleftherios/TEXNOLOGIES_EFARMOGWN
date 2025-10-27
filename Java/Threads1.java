import java.io.*;
import java.util.*;

class MyThread extends Thread{
	public MyThread (String name){
		super(name);
	}
	public void run(){ //Είναι άδεια μέθοδος και εμείς τη καθορίζουμε
		String str = "We starting!";
		System.out.println(str);
		String name = getName();
		System.out.println(name);
	}
}

public class Threads1{
	public static void main (String[] args){
		try{
			new MyThread("T1").start(); 
			//Η μέθοδος start λεει "Ξεκινα Thread" και ΑΜΕΣΩΣ θα ψάξει για τη run και θα την εκτελέσει
		}
		catch(Exception err){
			System.out.println("ERROR!");
		}
	}
}