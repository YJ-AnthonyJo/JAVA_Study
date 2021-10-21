public class Animal {
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
