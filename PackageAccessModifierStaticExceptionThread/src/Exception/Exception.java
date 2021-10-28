package Exception;

/////////////////////////////////////////////////
public class Exception { //단순 예외처리 : 산술예외
    public void shouldBeRun(){
        System.out.println("Oh thanks.");
    }
    public static void main(String[] args) {
        Exception test = new Exception();
        //예외처리
        int c;
        try {
             c = 4/0;
        }catch (ArithmeticException e){
            c = -1;
        }finally { //에러 여부 상관없이 무조건 실행.
            test.shouldBeRun();
        }
    }
}

/////////////////////////////////////////////////
class JustBranch{ //예외 발생시키기 -1 : 단순 분기 처리
    public void sayNick(String nick){
        if("fool".equals(nick))
            return; //기본 분기

        System.out.println("당신의 별명은 "+nick+"입니다.");
    }

    public static void main(String[] args) {
        JustBranch test = new JustBranch();
        test.sayNick("fool");
        test.sayNick("genious");
    }
}

/*Exception 종류
    1. RuntimeException : 실행중 발생하는 예외(실행 중 발생할 수도, 발생하지 않을 수도 있음) # Unchecked Exception이라고도 불린다.
    2. Exception : 컴파일시 발생하는 예외(컴파일시 예측가능) #Checked Exception이라고도 불린다.
*/
/////////////////////////////////////////////////
class ThrowThrows_RuntimeException{ //예외 발생시키기 -2 : Runtime Exception
    public void sayNick(String nick){
        if("fool".equals(nick))
            throw new FoolException_RuntimeException(); //RuntimeException

        System.out.println("당신의 별명은 "+nick+"입니다.");
    }

    public static void main(String[] args) {
        ThrowThrows_RuntimeException test = new ThrowThrows_RuntimeException();
        test.sayNick("fool");;
        test.sayNick("genious");
    }
}

class FoolException_RuntimeException extends RuntimeException{ //RuntimeException상속
    /*Exception 종류
    1. RuntimeException : 실행중 발생하는 예외(실행 중 발생할 수도, 발생하지 않을 수도 있음) # Unchecked Exception이라고도 불린다.
    2. Exception : 컴파일시 발생하는 예외(컴파일시 예측가능) #Checked Exception이라고도 불린다.
     */
}

/////////////////////////////////////////////////
class ThrowThrows_Exception{ //예외 발생시키기 -3 : Exception
    public void sayNick(String nick){
        try{ //예측가능한 Checked Exception -> 예외처리를 반드시해야한다.(try - catch)
            if("fool".equals(nick))
                throw new FoolException_Exception(); //Exception
            System.out.println("당신의 별명은 "+nick+"입니다.");
        }
        catch (FoolException_Exception e){
            System.err.println("FollException_Exception이 발생하였습니다.");
        }

    }

    public static void main(String[] args) {
        ThrowThrows_Exception test = new ThrowThrows_Exception();
        test.sayNick("fool");;
        test.sayNick("genious");
    }
}

class FoolException_Exception extends java.lang.Exception {
    //예측가능한 Checked Exception -> 예외처리를 반드시해야한다.(try - catch)
    /*Exception 종류
    1. RuntimeException : 실행중 발생하는 예외(실행 중 발생할 수도, 발생하지 않을 수도 있음) # Unchecked Exception이라고도 불린다.
    2. Exception : 컴파일시 발생하는 예외(컴파일시 예측가능) #Checked Exception이라고도 불린다.
     */
}
/////////////////////////////////////////////////

class Throws{ //예외 던지기
    //예외를 위로 보내기 ( 예외를 뒤로 미루기 )
    //미루면 예외를 처리해야하는 주체가 함수가 아닌 그 메소드가 호출되는 곳이다(맞나?)
    public void sayNick(String nick) throws FoolException_Throws{
        if("fool".equals(nick))
            throw new FoolException_Throws();
        System.out.println("당신의 별명은 "+nick+"입니다.");
    }

    public static void main(String[] args) {
        Throws test = new Throws();
        try { //FoolException_Throws : Exception -> try-catch문 있어야.
            test.sayNick("fool");
            test.sayNick("genious");
        }
        catch (FoolException_Throws e){
            System.err.println("FoolException이 발생하였습니다");
        }
    }
}
class FoolException_Throws extends java.lang.Exception {

}

/////////////////////////////////////////////////
//예외처리를 sayNick 메소드에서 하는 것이 날까, main메소드에서 하는 것이 날까?
// 둘 사이에는 큰 차이가 있다.
//sayNick : sayNick("genious")가 실행된다.
//main : sayNick("genious")가 실행되지 않는다. 이미 예외가 발생하여 catch로 빠졌기 때문이다.
//Exception을 처리하는 위치는 중요하다. -> 잘 정하자.


/////////////////////////////////////////////////
//Transaction
//Transaction : 하나의 작업단위를 뜻한다.

//예시 : 쇼핑몰의 상품발송
//여기서는 포장, 영수증 발행, 발송의 단계가 있을 것이다.
//이중 하나라도 실패하게되면 3단계 모두 취소하고 발송 전 상태로 되돌리고 싶을 것이다.
//모두 취소하지 않으면 데이터의 정합성이 크게 흔들린다.
//이렇게 모두 취소하는 것을 롤팩(Rollback)이라고 한다.
//이 경우 예외처리는 어떻게 해야하겠는가?
/*
: 기본코드(수도코드(pseudo))
수도코드(슈도코드, pseudocode)는 특정 프로그래밍 언어의 문법을 따라 씌여진 것이 아니라, 일반적인 언어로 코드를 흉내내어 알고리즘을 써놓은 코드를 말한다.
수도코드는 말그대로 흉내만 내는 코드이기 때문에, 실제적인 프로그래밍 언어로 작성된 코드처럼 컴퓨터에서 실행할 수 없으며,
특정 언어로 프로그램을 작성하기 전에 알고리즘의 모델을 대략적으로 모델링하는 데에 쓰인다.

상품발송() {
    포장();
    영수증발행();
    발송();
}

포장() {
   ...
}

영수증발행() {
   ...
}

발송() {
   ...
}
/////////////////////////////////////////////////
->올바른 예외 처리
상품발송() {
    try {
        포장();
        영수증발행();
        발송();
    }catch(예외) {
       모두취소();
    }
}

포장() throws 예외 {
   ...
}

영수증발행() throws 예외 {
   ...
}

발송() throws 예외 {
   ...
}
/////////////////////////////////////////////////
->올바르지 못한 예외처리 : 뒤죽박죽된다.
상품발송() {
    포장();
    영수증발행();
    발송();
}

포장(){
    try {
       ...
    }catch(예외) {
       포장취소();
    }
}

영수증발행() {
    try {
       ...
    }catch(예외) {
       영수증발행취소();
    }
}

발송() {
    try {
       ...
    }catch(예외) {
       발송취소();
    }
}
: 위와 같이 Transaction관리 잘못하면 고생한다. 재앙에 가깝다.
*/