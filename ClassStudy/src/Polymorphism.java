public class Polymorphism {
}

//step 1 : 그냥 개발(if문 써서)
class Bouncer{
    public void barkAnimal(Animal_i animal){
        if(animal instanceof Tiger){// instanceof : 특정 객체가 클래스의 객체인지를 조사할 때 사용하는 자바의 내장 키워드
            System.out.println("어흥");
        } else if(animal instanceof Lion){
            System.out.printf("으르렁");
        }
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}

//step2 : 위 : 별로 마음에 안든다. -> interface를 사용하자(interface로 if문을 대체하자)
interface Barkable{
    public void bark();
}

class Tiger_poly extends Animal implements Barkable, Predetor{

    @Override
    public void bark() {
        System.out.println("으르렁");
    }

    @Override
    public String getFood() {
        return "apple";
    }
}

class Lion_poly extends Animal implements Barkable, Predetor{

    @Override
    public void bark() {
        System.out.printf("어흥");
    }

    @Override
    public String getFood() {
        return "banana";
    }
}

class Bouncer_poly{
    public void barkAnimal(Barkable animal){ // 단 이렇게 Barkable의 자료형으로 선언된 객체는 해당 자료형이 가지고 있는 메소드만 사용 가능하다.
        //여기서 animal은 bark메소드만 호출 가능하다.
        //반대로 Predetor로 선언되었다면 getFood()만 호출가능할 것이다.
        animal.bark();
        //animal.getFood(); //없는 메소드이다.
        //자세한 건, 이 클래스의 main에서 말한다.
        //이렇게 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것을 객체지향 세계에서는 다형성, 폴리모피즘(Polymorphism)이라고 부른다.
        //이또한 사용하고자 한다면 Lion_poly로 선언하거나, 이 둘(Barkable, Predetor) 모두를 포함한 인터페이스 혹은 class를 만들면 된다.
    }

    public static void main(String[] args) {
        Tiger_poly tiger = new Tiger_poly();
        //모든 메소드 활용가능
        tiger.getName();
        tiger.setName("testTiger");
        tiger.getFood();
        tiger.bark();

        Animal animal = new Tiger_poly();
        //animal에 포함된 메소드인 Name의 Getter, Setter만 사용가능하다.
        animal.setName("testTiger");
        animal.getName();
//        animal.getFood(); // Error
//        animal.bark(); //error

        Predetor predator = new Tiger_poly();
        //Predetor에 포함된 메소드인 getFood만 사용가능하다.
        //Predetor에는 Animal에 없다.
//        predator.getName();//Error
//        predator.setName();//Error
        predator.getFood();
//        predator.bark();//Error

        Barkable barkable = new Tiger_poly();
        //Barkable에 포함된 메소드인 bark만 사용 가능하다.
//        barkable.getName(); // Error
//        barkable.setName(); // Error
//        barkable.getFood();//Error
        barkable.bark();
    }
}

//step3. 모든 인터페이스와 기타 클래스의 메소드 사용할 수 있게하기

// : 새로운 인터페이스를 만들자.
interface BarkPredetor extends Barkable, Predetor{//, Animal{ // interface에서 extends의 대상은(extends 뒤에 나오는 것) interface인가보다.
    //extends Animal하면 에러난다. 에러 메시지 : "Interface expected here"
    //또한 클래스는 단일 상속만 가능한 반면, 인터페이스는 다중 상속이 가능하다.
}

class Lion_poly_mulitinheritance implements BarkPredetor{

    @Override
    public void bark() {
        System.out.println("어흥");
    }

    @Override
    public String getFood() {
        return "banana";
    }
}
class Tiger_poly_mulitinheritance implements BarkPredetor{

    @Override
    public void bark() {
        System.out.println("으르렁");
    }

    @Override
    public String getFood() {
        return "apple";
    }
}

class Bouncer_poly_mulitineritance{
    public void barkAnimal(BarkPredetor animal){
        animal.bark();
        System.out.println("음식 : "+animal.getFood());
    }

    public static void main(String[] args) {
        Tiger_poly_mulitinheritance tiger = new Tiger_poly_mulitinheritance();
        Lion_poly_mulitinheritance lion = new Lion_poly_mulitinheritance();
        Bouncer_poly_mulitineritance bouncer = new Bouncer_poly_mulitineritance();

        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}