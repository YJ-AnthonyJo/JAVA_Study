//java.lang패키지에 속하지 않은 클래스는 항상 import 해서 사용해야한다.
//InputStream은 자바의 내장클래스이다. 그래도 java.lang에 속하지 않으므로 import해준다.

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws Exception{
        //**********IN**********
        InputStream in = System.in; //객체가 미리 만들어져있는 것인가?
        //부모인 InputStream에 이 객체(System.in)가 있는 듯하다.

        int a;
        a = in.read(); //1바이트의 사용자 입력을 받는다.
        //이때 읽은 byte는 byte형으로 저장되지 않고 int형으로 저장된다.
        //이때 int값은 0~255사이의 값이다.
        //엔터 키를 입력해야 전달된다.
        //"a"입력후 엔터 하면 아래 sout(println)에 97이 출력되고
        //여기에 "abc"를 입력해도 97이 출력된다.
        //이유 : InputStream의 read 메소드는 1byte만을 읽기 때문.
        //"abc"라는 3바이트를 전달했지만, 프로그램에서 1byte만 읽은 경우라고 할 수 있다.
        System.out.println(a);
        //콘솔에서 입력된 데이터 : 입력 스트림이라고 한다.
        // 스트림 : 이어져있는 데이터의 형태.
        // A수도관에서 B수도관으로 이동하는 물의흐름.
        //추가 설명(스트림)
        /* 프로그래밍에서의 스트림
        1. 파일데이터 : 파일은 그 시작과 끝이 있는 데이터의 스트림이다.
        2. HTTP응답데이터 : 브라우저가 요청하고 서버가 응답하는 HTTP 응답 데이터도 스트림이다.
        3. 키보드 입력 : 사용자가 키보드로 입력하는 문자열은 스트림이다.
         */

        //"abc"3바이트 모두 입력받는 방법 #1
        int b, c;
        a = in.read(); // 공백도 인식한다. 즉 scanf보다는 getchar에 가깝다고 할 수 있다.
        b = in.read();
        c = in.read();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //"abc"3바이트 모두 입력받는 방법 #2
        byte[] d = new byte[3];
        in.read(d);

        System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[2]);

        //문자로 입력받는 방법 : 문자로 입력스트림을 읽자. : InputStreamReader가 사용된다.
        //InputStreamReader를 사용하면, char배열을 사용할 수 있게 된다.
        InputStreamReader reader = new InputStreamReader(in);
        char[] e = new char[3];
        reader.read(e);
        // -> gets_s와 비슷하다고 할 수 있다.(3바이트만 읽도록 고정되어있다.)
        System.out.println(e); //"abc"한번에 출력됨.

        // 엔터키입력시까지 입력받는방법 : BufferedReader사용!
        InputStreamReader reader_BR = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader_BR);
        String f = br.readLine();
        System.out.println(f);


        /*정리 : 다음과 같이 이해하자.
        InputStream - byte
        InputStreamReader - character
        BufferedReader - String
         */

        //*****Scanner*****
        //J2SE 5.0부터 java.util.Scanner클래스가 추가되었다. -> 이를 이용하면 보다 쉽게 콘솔입력이 가능하다.
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
        //sc.next : 단어 하나(Token)를 읽어들인다.
        //sc.nextLine : 라인을 읽어들인다.
        //sc.nextInt : 정수를 읽어들인다.


        //**********OUT**********
        // System.out :PrintStream 클래스의 객체
        // PrintStream : 콘솔에 값을 출력할 때 사용되는 클래스
        // System.out.println은 문자열 출력에서 사용된다.
        //System.err는 System.out과 동일한 기능을 하지만, 오류메시지를 출력할 경우에 사용하게 되어있다.
        System.err.println("error"); // Intellij상으로 빨간석으로 출력된다.
    }
}