//생성자 : Constructor
// new로 객체 생성시 인지값 들어가는 것을 강제하는 방법 : Integer도 이 Constructor를 사용하지 않았을까 싶다.

import java.awt.print.Pageable;

//생성자 적용x(상세히 말하면, default constructor)
class HouseDog_ extends Dog {
    public void sleep() {
        System.out.println(this.name+" zzz in house");
    }

    public void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }

    public static void main(String[] args) {
        HouseDog_ houseDog = new HouseDog_();
        houseDog.setName("happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }
}


public class Constructor {
    public static void main(String[] args) {
        HouseDog_ dog = new HouseDog_();
        System.out.println(dog.name); //null
    }
}

//생성자 적용
class HouseDog_1 extends Dog {
    //이게(HouseDog_1메소드) Constructor이다.(생성자.) : python의 __init__()
    //Constructor메소드 : 클래스명과 메소드 명이 동일하다.
    //Constructor메소드 : 리턴타입을 정의하지 않는다. (void도 아니다...)
    public HouseDog_1(String name){
        this.setName(name);
    }

    public void sleep() {
        System.out.println(this.name+" zzz in house");
    }

    public void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }

    public static void main(String[] args) {
        HouseDog_1 houseDog = new HouseDog_1("puppy");
        houseDog.setName("happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }
}


class Constructor1 {
    public static void main(String[] args) {
        HouseDog_1 dog = new HouseDog_1("puppy"); // 이렇게 인자를 꼭 넣어주어야한다.
        System.out.println(dog.name); //null
    }
}


//default 생성자. : 우리가 생성자를 지정해주지 않을 때 자동으로 지정되는 것이다.
//사용자가 생성자를 작성하면, 컴파일러는 디폴트 생성자를 추가하지 않는다.
class HouseDog_2 extends Dog {
    //이게 Constructor이다.(생성자.) : python의 __init__()
    //Constructor메소드 : 클래스명과 메소드 명이 동일하다.
    //Constructor메소드 : 리턴타입을 정의하지 않는다. (void도 아니다...)
    public HouseDog_2(){
    }

    public void sleep() {
        System.out.println(this.name+" zzz in house");
    }

    public void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }

    public static void main(String[] args) {
        HouseDog_2 houseDog = new HouseDog_2();
        houseDog.setName("happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }
}


class Constructor2 {
    public static void main(String[] args) {
        HouseDog_2 dog = new HouseDog_2();
        System.out.println(dog.name); //null
    }
}


//생성자 오버로딩 : 하나의 클래스에 대해 다른 생성자를 만들 수 있다.(단 parameter가 다 달라야..)
class HouseDog_3 extends Dog {
    //이게 Constructor이다.(생성자.) : python의 __init__()
    //Constructor메소드 : 클래스명과 메소드 명이 동일하다.
    //Constructor메소드 : 리턴타입을 정의하지 않는다. (void도 아니다...)
    public HouseDog_3(String name){
        this.setName(name);
    }
    public HouseDog_3(int type){
        if(type==1) {
            this.setName("yorkshire");
        }
        else if(type==2){
            this.setName("Bordercollie");
        }
    }

    public void sleep() {
        System.out.println(this.name+" zzz in house");
    }

    public void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }

    public static void main(String[] args) {
        HouseDog_3 houseDog = new HouseDog_3(1);
        houseDog.setName("happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }
}


class Constructor3 {
    public static void main(String[] args) {
        HouseDog_3 dog = new HouseDog_3("happy");
        HouseDog_3 dog1 = new HouseDog_3(2);
        System.out.println(dog.name);
        System.out.println(dog1.name);
    }
}