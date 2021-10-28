package Thread;
//Thread : 한 프로세스 내에서 두가지 혹은 그 이상의 일을 동시에 할 수 있게 하는 것.

import javax.print.attribute.TextSyntax;
import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

//기본
public class Thread extends java.lang.Thread {
    public void run(){
        System.out.println("Thread run.");
    }

    public static void main(String[] args) {
        Thread test = new Thread();
        test.start(); // java.lang.Thread의 메소드 -> 클래스의 run메소드를 수행한다.(Thread클래스는 start시, run메소드가 수행되도록 내부적으로 코딩되어있다.)

    }
}

//Thread의 실행동작을 체크해보자
class Thread_loop extends java.lang.Thread {
    int seq;
    public Thread_loop(int seq){ // initializer
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq + "thread start.");
        try {
            Thread.sleep(1000);
        }catch (Exception e){}
        System.out.println(this.seq + "thread end.");
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            Thread_loop test = new Thread_loop(i);
            test.start(); // java.lang.Thread의 메소드 -> 클래스의 run메소드를 수행한다.(Thread클래스는 start시, run메소드가 수행되도록 내부적으로 코딩되어있다.)
        }

    }
}
/*
**결과**
0 thread start.
4 thread start.
6 thread start.
2 thread start.
main end.
3 thread start.
7 thread start.
8 thread start.
1 thread start.
9 thread start.
5 thread start.
0 thread end.
4 thread end.
2 thread end.
6 thread end.
7 thread end.
3 thread end.
8 thread end.
9 thread end.
1 thread end.
5 thread end.
* 0~9번 쓰레드 까지 순차적으로 실행되지 않고, 순서가 일정치 않다.
* -> 쓰레드는 순서와 상관없이 동시에 실행된다.
* 더욱이 신기한 것은, main이 중간에 종료되었다는 점이다.
 */

class Join extends java.lang.Thread { // 모든 thread가 종료된 후 main메소드 종료시키고자 할때.
    int seq;
    public Join(int seq){
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq + "thread start.");
        try {
            Thread.sleep(1000);
        }catch (Exception e){}
        System.out.println(this.seq + "thread end.");
    }

    public static void main(String[] args) {
        ArrayList<java.lang.Thread> threads = new ArrayList<java.lang.Thread>();
        for(int i=0;i<10;i++){
            java.lang.Thread t = new Join(i);
            t.start();
            threads.add(t);
        }

        for(int i=0;i<10;i++){
            java.lang.Thread t = threads.get(i);
            try {
                t.join(); // 쓰레드가 종료될 때까지 기다린다.
            }catch (Exception e){}
        }
        System.out.println("main end.");
    }
}//쓰레드를 사용할 때 가장 많이 하는 실수가, 쓰레드가 종료되지 않았는데 종료된 줄알고 다음 로직을 수행하는 것(Business Logic에서 문제가 생긴다.)
//-> 이를 해결하기 위해서 쓰레드가 종료된 이후에 다음 로직을 수행해야하는데, 이때 필요한 것이 바로 java.lang.Thread의 join메소드이다.

//Runnable인터페이스로 쓰레드 객체 구현 : 더 유연한 프로그램이 되었다.
class Runnalbe_test implements java.lang.Runnable{
    int seq;
    public Runnalbe_test(int seq){
        this.seq = seq;
    }

    public void run(){ // Runnable Interface가 요구하는 메소드.
        System.out.println(this.seq+" thread start.");
        try {
            java.lang.Thread.sleep(1000);
        }catch (Exception e){}
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        ArrayList<java.lang.Thread> threads = new ArrayList<java.lang.Thread>();
        for(int i=0;i<10;i++){
            java.lang.Thread t = new java.lang.Thread(new Runnalbe_test(i));
            //java.lang.Thread의 생성자로 Runnable 인터페이스를 구현한 객체를 넘길 수 있다.
            // (원리가 뭐지.. 공부했었는데 기억못하는건가..)
            t.start();
            threads.add(t);
        }

        for(int i=0;i<10;i++){
            java.lang.Thread t = threads.get(i);
            try {
                t.join();
            }catch (Exception e){}
        }
        System.out.printf("main end.");
    }
}