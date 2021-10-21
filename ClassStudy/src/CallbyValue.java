// 하나의 .java파일 안에는 여러개의 클래스를 선언할 수 있다.
// 단, 파일명이 CallbyValue.java라면, 해당 파일 내의 CallbyValue라는 Class는 public으로 선언하라는 규칙이 존재한다.
/*public의 의미.
* public class는 다른 패키지에서 접근이 가능하게 된다.
* main이 있는 Class는 public이어야한다. : 음..
* 내가 이 파일을 빌드했더니, class파일이 4개 생겼다.
* 클래스 이름 별로 다 생성되었다..
* 그렇다고 CallbyRef를 decompile(InteliJ는 recreate라고 한다.. 뭐 jvm이니까, 1:1매칭은 쉬울 것이다.)했을 때 public이 붙아있지는 않다..
* Terminal에서 실행했을 때는 main메소드가 존재하는 class들은 다 잘된다..
* 그렇다면 public은 필수적인 사항은 아닌 것인가?
*/
//왜 이런 규칙을 만들었나?
// for 가독성
class Updater{
    public void update(int count){
        count++;
    }
}
public class CallbyValue {
    int count = 0;

    public static void main(String[] args) {
        CallbyValue myCounter = new CallbyValue();
        System.out.println("Before Update : "+myCounter.count);
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter.count);
        System.out.println("After Update : "+myCounter.count);
        // 여전히 0이다. 이유 : parameter값이 int자료형이기 때문이다
    }
}

class Updater_ref{
    public void update(CallbyRef counter){
        counter.count++;
    }
}

class CallbyRef{
    int count=0;

    public static void main(String[] args) {
        CallbyRef myCounter = new CallbyRef();
        System.out.println("Before Update : "+myCounter.count);
        Updater_ref myUpdater = new Updater_ref();
        myUpdater.update(myCounter);
        System.out.println("After Update : "+myCounter.count);
        // parameter로 primitive가 아닌, object가 전달되었다. 따라서, 객체가 변경되었다.
        // 결과 : 1
    }
}