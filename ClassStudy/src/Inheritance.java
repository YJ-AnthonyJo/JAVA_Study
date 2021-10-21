//상속
//JAVA에서의 상속 : extends키워드를 통해 수행한다.

import com.sun.security.jgss.GSSUtil;

import javax.swing.*;

class Dog extends Animal{ // 상속 받았기에 부모에 있는 것 그대로 사용가능하다.
    public void sleep(){
        //부모 클래스에 없는 것 : 이와 같이 보통 부모클래스에서 상속받은 자식 클래스는
        // 부모의 기능에 더하여 더 많은 기능을 가지도록 설계한다.
        System.out.println(this.name + " zzz");
    }
    public static void main(){
        Dog dog = new Dog();
        dog.setName("Poppy");
        System.out.println(dog.name);
    }
}
public class Inheritance {
    //IS-A의 관계 : Dog는 Animal의 하위개념. -> Dog는 Animal에 포함된다 -> 개는 동물이다라고 표현 가능하다. 이를 JAVA는 IS-A관계라고 표현한다
    //Dog {IS A} Animal.
    //기능주의철학..인가.. 이제 뭐 다 철학이야기네..
    //변수의 자료형(부모 클래스)에서 필요한 기능이 자식 클래스에(더 정확히는 자식 객체에) 모두 있다면, 해당 변수는, 자식 객체로 초기화 가능하다.
    //즉, 자식 객체는 부모 클래스의 자료형인 것 처럼 사용이 가능하다. 자식 객체는 부모 클래스의 변수에 할당가능하다.
    //하지만 반대로 자식 클래스에서 필요한 기능이 부모 객체에 다 있는 것은 아니다. 따라서, 해당 변수는 부모 객체로 초기화가 불가능하다.
    //즉, 부모 객체는 자식 클래스의 자료형인 것 처럼 사용이 불가능하다. 자식 객체는 부모 클래스의 변수에 할당가능하다.

    //부모 클래스의 자료형을 가진 변수 = 자식 객체 : 가능
    Animal dog = new Dog(); // 가능.
    //자식 클래스의 자료형을 가진 변수 = 부모 객체 : 불가능
//    Dog dog = new Animal(); // 불가.
//    자식 객체는 부모 클래스의 자료형인 것 처럼 사용이 가능하다. 자식 객체는 부모 클래스의 변수에 할당가능하다.

    //우선
    //"""변수가 선언되면 해당 변수의 클래스가 가지는 모든 메소드를 다 사용할 수 있어야할 것.
    //이때, 자식클래스 형 변수에 부모클래스의 객체가 선언되면, 자식클래스의 모든 메소드가 부모에 존재하지 않기에 에러가 난다."""
    //라고 이해했다.

    //집합관계로 간단히 생각하자.
    //첫번째의 경우는 Dog is a Animal type 이고,
    //두번째의 경우는 Animal is a Dog type 이다. : 말이 안된다.


}

// 모든 클래스 : Object라는 클래스로 부터 상속받게 되어있다.
//하지만, 굳이 아래처럼 extends로 명시하지 않아도, 자동으로 상속받게끔한다.
class fromobject extends Object{
    public static void main(String[] args) {
        System.out.println("Inheriance by Object Class");
    }
}
//따라서!! 생성되는 모든 클래스는 Object의 child Class이므로, 다음과 같이 사용가능하다.
class fromobject_ {
    Object animal = new Animal();
}

//메소드 오버라이딩
class HouseDog extends Dog{
    public static void main(String[] args) {
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        //HouseDog들은 잠을 집에서만 자서, happy zzz가 아니라, happy zzz in house가 되어야한다고 가정해보자.
//        houseDog.sleep(); //단지 happy zzz가 나온다.
        //이때 할 수 있는 것이 메소드 오버라이딩이다.
        //물론, Dog자체를 바꿀 수도 있겠으나, 기본적으로 Dog는 zzz가 어울린다고 해보자. 변경안하고 이 HouseDog에 대해서만 바꿀 수 있는 방법이 이 MethodOverride이다.
    }
}
class HouseDog_override extends Dog{
    public void sleep(){
        System.out.println(this.name+" zzz in house");
    }
    public static void main(String[] args) {
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        //HouseDog들은 잠을 집에서만 자서, happy zzz가 아니라, happy zzz in house가 되어야한다고 가정해보자.
        houseDog.sleep(); //happy zzz in house가 잘 나온다.
        //HouseDog클래스에 Dog클래스와 동일한 형태의 sleep메소드를 구현하면, HoseDog클래스의 sleep 메소드가 Dog의 sleep 메소드보다
        //더 높은 우선순위를 가진다.
        //이렇게 부모클래스의 메소드를 자식 클래스가 동일한 형태로 또다시 구현하는 행위를 메소드 오버라이딩(Method Overriding)이라고 한다.
    }
}


//메소드 오버로딩 : method overloading : c++
class HouseDog_overloading extends Dog{
    //입력항목이 다를경우(parameter가 다를경우), 동일한 이름의 메소드를 생성할 수 있다. 이를 메소드 오버로딩이라고 한다. Method Overloading
    //앞선 sleep 메소드와 parameter가 차이가 있다.(앞 : 없음, 지금 : int hour)
    public void sleep(int hour){
        System.out.println(this.name+" zzz in house for " + hour+" hours");
    }
    public static void main(String[] args) {
        HouseDog_overloading houseDog = new HouseDog_overloading();
        houseDog.setName("happy");
        houseDog.sleep(); //sleep()메소드 호출
        houseDog.sleep(3); // sleep(int hour)메소드 호출
    }
}

//다중 상속 : 클래스가 동시에 하나 이상의 클래스를 상속받는 것을 뜻한다.
//C++, Python 등 많은 언어들이 다중상속을 지원하나, JAVA는 다중상속을 지원하지 않는다.
//만약 JAVA가 다중상속을 지원한다면, 다음 코드가 만들어질 수 있을 것이다.
/*class A {
    public void msg() {
        System.out.println("A message");
    }
}

class B {
    public void msg() {
        System.out.println("B message");
    }
}

class C extends A, B {
    public void static main(String[] args) {
        C test = new C();
        test.msg();
    }
}
*/
//위 코드는 실제로 동작하지 않는 코드.
//다만 작동한다고 가정할때, msg()는 A의 msg를 실행해야하나, 아니면 B의 msg를 실행해야하나?
//JAVA는 이런 불분명함을 제거한 언어이다.
//*다중상속을 지원하는 다른 언어들(C++, Python 등)은, 동일한 메소드를 상속받는 경우, 우선순위등을 적용하여 해결한다.






//참고 : Animal Class
/*public class Animal {
    String name; // Class에 선언된 변수 : 객체 변수, 속성(Attribute), 인스턴스 변수, 멤버 변수라고 부른다.
    // 내가 알던 것과는 조금 다를 듯?
    // 내가 아는 것(in python) : 객체의 변수와 클래스의 변수가 있는 것으로 기억하는데.. 아닌가? 기억이 가물가물..
    //이렇게 선언만 해두면, null이 들어간다.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; // this : Animal 클래스에 의해서 생성된 객체를 가리킨다.
        //즉 이 class로 생긴 object(인스턴스)가 cat이라면, 이 this.name은 cat.name을 가르키게된다.
    }

    public static void main(String[] args) { // 이렇게 클래스 안에 main을 선언할 수도 있다. 아마 이것이, 생성자가 아닐까?
        //생성자 : 인스턴스가 만들어질 때, 자동으로 실행되기로 약속된 메소드.
        // 이 main도 하나의 메소드라고 보여질 수 있다.
        Animal cat = new Animal();
        cat.setName("boby");
        System.out.println(cat.name);
    }
}
*/