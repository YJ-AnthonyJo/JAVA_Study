/*
Abstract Class : 인터페이스 역할을 하면서 동시에 구현체도 가지고 있는 클래스.
점프투자바 지필인 : 추상 클래스는 인터페이스로 대체하는 것이 좋은 디자인이라고 이야기한다.

Polymorphism에서 만들었던 Predator인터페이스를 추상클래스로 바꾸허보자.
 */

//추상클래스 명시 규칙 : abstract를 앞에 붙인다. && 메소드 또한 abstract를 붙여야한다.
//abstract 메소드는 인터페이스의 메소드와 마찬가지로 몸통이 없다.
//-> abstract클래스를 상속하는 클래스에서 구현해야한다.
//abstract Class에서 실제 메소드도 추가가능하다.
abstract class Predator_Abstract_Class extends Animal{
    public abstract String getFood();

    //아래와 같이, abstract Class에서 실제 메소드도 추가가능하다.
    public boolean isPredator(){
        return true;
    }
}

//기존 : Predator을 implements하였다.
//지금 : Predator을 extends한다.
//즉, 인터페이스 -> 클래스
class Tiger_AbstractClass extends Predator_Abstract_Class implements BarkPredetor{

    @Override
    public String getFood() {
        return "apple";
    }

    @Override
    public void bark() {
        System.out.println("어흥");
    }
}

class Lion_AbstractClass extends Predator_Abstract_Class implements BarkPredetor{

    @Override
    public String getFood() {
        return "banana";
    }

    @Override
    public void bark() {
        System.out.println("으르렁");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Tiger_AbstractClass tiger = new Tiger_AbstractClass();
        Lion_AbstractClass lion = new Lion_AbstractClass();
        if(tiger.isPredator()) {
            tiger.bark();
            System.out.println("음식 : " + tiger.getFood());
        }
        if(lion.isPredator()){
            lion.bark();
            System.out.println("음식 : "+ lion.getFood());
        }
    }
}