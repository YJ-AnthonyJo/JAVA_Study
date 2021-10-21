package jump2java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class HelloWorld {
    public static void main(String args[]) {
        boolean isSuccess = true;
        boolean isNotSuccess = false;
        char a1 = 'a'; // charator style
        char a2 = 97; // ascii style
        char a3 = '\u0061'; //unicode style
        //궁금증 : 저장되는 byte값은 어떻게 될 것인가?
//        c처럼 ascii기반일 것인가?
//        아 뭐 그렇겠지.. 보다 엄밀히 말하면 unicode스타일.

//        어차피 unicode의 첫 부분은 ascii와 같으니..
        String a = "hello";
        String b = "java";
        String c = "hello";
        String d = "Hello Java";
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(d.indexOf("Java"));
        System.out.println(d.substring(0,4));
        // : Python의 슬라이싱(끝위치(여기서 4)는 마찬가지로 포함되지 않는다.)
//        System.out.println((d.toUpperCase(Locale.ROOT))); // Locale.ROOT는 무엇인가..
        System.out.println((d.toUpperCase()));

        if(isSuccess) {
            System.out.println("Hello World!");
        }
        else if(isNotSuccess){
            System.out.println("Hello Hacker~");
        }


        //StringBuffer : 문자열을 추가하거나 변경할 때 사용가능.
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        System.out.println(sb.toString()); // 문자열형태는 아니다. toString()함수를 써주어야한다.
        //^위 예제는 String에서 다음과 같이 작성할 수 있다.
        String temp = "";
        temp += "hello";
        temp += "jump to java";
        System.out.println(temp);

        //결과는 동일하지만, 내부적으로 객체가 생성되고 메모리가 사용되는 과정은 다르다.
        /*
        StringBuffer : 객체가 단 한번만 생성되어, 객체 자체가 바뀌지 않는다.
        String : 새로운 객체를 만들어 반환한다.
            String : 한번 생성되면 가 값을 변경할 수 없다.
            immutable하다.

        -> StringBuffer만을 사용하는 것이 좋을까?
        StringBuffer : String보다 무거운 자료형이다.
            여기서 무겁다는 것은, 아마.. 메소드가 많다는 뜻이 아닐까.
            일반 String보다 메모리 사용량도 많고 속도도 느리다.
        -> 결론 : 사용방법
        StringBuffer : 문자열 추가나 변경등의 작업이 많을 경우
        String : 문자열 변경 작업이 거의 없는 경우
        */

        sb.insert(0,"hello ");
        System.out.println(sb.substring(0,4)); // String의 substring과 동일하다.
        // 질문 : String의 모든 기능(메소드들)을 StringBuffer가 다 포함하고 있나?

        //배열(Array)
        int[] odds = {1,3,5,7,9};
        String[] weeks = new String[7];
        weeks[0] = "월";
        weeks[1] = "화";
        weeks[2] = "수";
        weeks[3] = "목";
        weeks[4] = "금";
        weeks[5] = "토";
        weeks[6] = "일";
//        int odd[7]; //이와같은 형태는 안된다.
//        길이를 나타내고 싶을 때는, new를 사용한다.
//        -> primitive 자료형에도 이것이 필요한가?
        int[] odd = new int[7];
        
        //리스트
        //배열과 비슷한 자바의 자료형 -> 편리한 기능 지원.
        //동적으로 자료형 개수 변환되는 경우. -> list가 유용하다.
        // List자료형 중 가장 간단한 자료형 : ArrayList
        /*List자료형에는
        * ArrayList
        * LinkedList등이 있다.*/
        //add : list에 추가
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        pitches.add(0,"133"); //index기준으로 add할 수도 있다.
        //insert같은..?
        //get : 인덱스 얻기
        System.out.println(pitches.get(1));
        System.out.println(pitches.size());
        //contains
        System.out.println(pitches.contains("142"));
        System.out.println(pitches.remove("129")); // 삭제 성공 여부 반환(boolean)
        System.out.println(pitches.remove(0)); //index로도 가능하다.
        //ArrayList : 무조건 안에 있는 데이터가 문자열인가?

        //Generics : <>..
        ArrayList<String> aList = new ArrayList<String>();
        // python의 Annotation같은..? 보다는 강제성 있는..
        /*
        <String> 이라는 제네릭스 표현식은
        "ArrayList 안에 담을 수 있는 자료형은 String 타입 뿐이다" 라는 것을 의미
        String외에도, 직접 선언한
        Generics의 기능 : type check가능.

        Generics 미사용시 : ArrayList안에 추가되는 객체는 Object자료형.
        Object : 모든 자료형..
        */


        //maps : python의 dictionary같은 것.
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.get("people"));
        System.out.println(map.containsKey("people"));
        System.out.println(map.remove("people")); //없앤 value리턴
        System.out.println(map.size());

//        java의 if 사용법 : C와 동일
//        java의 switch - case 사용법 : C와 동일.
//        ArrayList.contains(parm) : parm이 해당 ArrayList Object에 존재하는가?
        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        pocket.add("money");

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        }else {
            System.out.println("걸어가라");
        }


//        java의 while 사용법 : C와 동일, 단 true라는 boolean class(이게 class가 맞나?)가 있는 것이 차이?
//        java의 for 사용법 : C와 동일, ""

//        java의 for each문 : python의 for문과 비슷하다고 할 수 있을 듯하다.
        /*for(type var:iterate){
        * body of loop
        * }
        */
        /*의미
        * iterate를 반복횟수마다 하나씩 순차적으로 var에 대입된다.
        * iterate : ArrayList등이 가능하다.
        * */

        String[] numbers = {"one", "two", "three"};
        for(String number: numbers) {
//            for (type var: iterate) {
//                  body-of-loop
//              }
            System.out.println(number);
        }

//        단, foreach문은 따로 반복회수를 명시적으로 주는 것이 불가능하고, 1스탭씩 순차적으로 반복될때만 사용가능하다는 제약이 있다.
//        python에서도 iterate의 하나씩 하였다.

    }
}
