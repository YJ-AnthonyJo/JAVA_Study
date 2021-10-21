public class interface_class {
}
class Animal_i0{
    String name;
    public void setName(String name){
        this.name = name;
    }
}

class Tiger0 extends Animal_i0{

}
class Lion0 extends Animal_i0{

}
class ZooKeeper0{
    public void feed(Tiger0 tiger){
        System.out.println("feed apple");
    }
    public void feed(Lion0 lion){
        System.out.println("feed banana");
    }

    public static void main(String[] args) {
        ZooKeeper0 zooKeeper = new ZooKeeper0();
        Tiger0 tiger = new Tiger0();
        Lion0 lion = new Lion0();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}

//동물원의 동물은 호랑이, 사자 뿐만이 아니라 다양하다.
//-> 메소드를 계속 추가해야한다. -> 불편하다.
//-> interface를 사용하자.
// 아래 첫 단어가 class가 아니라 interface이다.
interface Predetor{ //한참 후에나 파악한건데..Predator이다..ㅋㅋㅋㅋㅋ Tab의 단점인가ㅋㅋㅋ 
    public String getFood(); //이 interface를 implements한 class에서 각기 정의가 가능하다.
}

class Animal_i{
    String name;
    public void setName(String name){
        this.name = name;
    }
}

class Tiger extends Animal_i implements Predetor{
    public String getFood() {//Predetor를 implements했기에 getFood를 정의함.
        return "apple";
    }
}
class Lion extends Animal_i implements Predetor{
    public String getFood() {//Predetor를 implements했기에 getFood를 정의함.
        return "banana";
    }
}
class ZooKeeper{
//    public void feed(Tiger tiger){
//        System.out.println("feed apple");
//    }
//    public void feed(Lion lion){
//        System.out.println("feed banana");
//    }
    public void feed(Predetor predetor){
        // tiger, lion은 Tiger, Lion의 객체이기도 하지만, Predator 인터페이스의 객체이기도 하다.
        //따라서 Predetor를 자료형의 타입으로 사용할 수 있는 것이다.
        //이처럼 객체가 한 개 이상의 자료형 타입을 갖게되는 특성을 다형성(플로모피즘)이라고 하는데, 이는 다음 챕터에서 배운다.

        System.out.println("feed "+predetor.getFood());
    }

    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}

//인터페이스로, 하나의 메소드로 구현이 가능해졌다. 여기서 중요한 것은,
//메소드 수가 줄었다는 것이 아니라, ZooKeeper클래스가 동물들의 종류에 의존적인 클래스에서
//비의존적 클래스가 되었다는 점이다.

//물리적 세계의 인터페이스 : USB포트 -> 하드디스크, 메모리스틱, 디카 등 연결 가능
//USB규격만 알면 어떤 기기도 만들 수 있다. 바로 이 점이 인터페이스의 핵심이다.
//마치 사육사가 어떤 육식동물이던지 상관않고 먹이를 주는 것처럼.
//https://wikidocs.net/217