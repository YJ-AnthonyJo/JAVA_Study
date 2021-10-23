import AccessModifier.Default;

public class Default_Use {
    public static void main(String[] args) {
        Default kim = new Default();
//        System.out.println(kim.lastname);
        //default AccessModifier로 지정된 것은 해당 패키지 밖에서 접근 불가.
        //에러남.
    }
}
