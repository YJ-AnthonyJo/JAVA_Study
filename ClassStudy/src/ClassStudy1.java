public class ClassStudy1 {
    //다른 언어에는 함수라는 것이 별도로 존재한다. 하지만 자바는 클래스를 떠나 존재할 수 있는 것은 없다.
    //따라서 자바의 함수는 따로 존재하지 않고 클래스 내에 존재하게 된다. 즉 메소드이다.
    //<보통 함수와 메소드가 공존하는 언어(예:파이썬)에서는 두 개를 구분하여 말하기도 하지만
    //자바는 보통 메소드와 함수를 구분하여 말하지 않는다. 다만 자바에서 사용되는 함수의 정확한 명칭은 메소드이다.>
    //메소드 : 입력을 가지고 어떤 일을 수행한 다음에 길과물을 내어놓는 것.

    //return : 리턴 자료형이 void인 메소드를 빠져나가기 위해 return만 단독으로 써서 메소드를 즉시 빠져나갈 수 있다.
    //참고. return 문만을 써서 메소드를 빠져나가는 이 방법은 리턴자료형이 void형인 메소드에만 해당된다.
    //리턴자료형이 명시되어 있는 메소드에서 return 문만 작성하면 컴파일 시 오류가 발생한다.
    public void say_nick(String nick) {
        if ("fool".equals(nick)) {
            return;
        }
        System.out.println("나의 별명은 "+nick+" 입니다.");
    }

    // 메소드 내에서 선언되는 변수 : local variable, 해당 메소드 안에서만 사용가능하다.
    /*단, parameter가 object라면, 이야기가 다르다.
    * 객체가 전달되고 이 객체의 값이 메소드 안에서 바뀐다면, 그 변경된 속성 값은 유지된다.*/

    //메소드 외부의 변수를 변경하는 방법 : return과 assignment이용하기
    //추측이건데, JAVA에는 python의 global같은 것이 없는가보다..

    // 객체를 넘기는 방법 예시
    //자료형인 경우, primitive자료형이 전달되고, 그 이외의 경우(reference 자료형) 객체가 전달된다.

    //    int a = new int(); //에러 : int는 class가 아니다?? yes!!
    // primitive에 대한 class는 따로 준다. int -> Integer
//    Integer a = new Integer(10);
    //primitive는 가볍다. 그래서 사용된다.
    //완전한 OOP라면 이 primitive가 존재해서는 안되겠지만, JAVA에서는 존재한다.

    //call by value, call by ref인가?
    int a;
    public void vartest(ClassStudy1 test) {
        test.a++;
    }

    public static void main(String[] args) {
        ClassStudy1 myTest = new ClassStudy1();
        myTest.a = 1; // setter없는 거 불편..
        myTest.vartest(myTest);
        System.out.println(myTest.a);
    }

}
