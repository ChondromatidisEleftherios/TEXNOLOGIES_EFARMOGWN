import java.io.*;
import java.util.*;

 class SimpleThread extends Thread {
 public SimpleThread(String name) {
 super(name);
 }
 public void run() {
 for (int i = 0; i < 3; i++) {
 System.out.println(i + "-" + getName());
 try {
 sleep((long)(Math.random() * 5000));
 } catch (Exception err) {
    System.out.println("Error!!!");
 }
 }
 System.out.println(getName()+ " is Finished!!!"); //Ενδέχεται τα threads να μην τελειώσουν με τη σωστή σειρά
 }
 }



 public class Threads2 {
 public static void main (String[] args) {
 new SimpleThread("Jamaica").start();
 new SimpleThread("Fiji").start();
 }
 }

 /*0-Jamaica
0-Fiji
1-Fiji
1-Jamaica
2-Fiji
Fiji is Finished!!!
2-Jamaica
Jamaica is Finished!!!*/