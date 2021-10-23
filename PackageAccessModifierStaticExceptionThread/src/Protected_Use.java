import AccessModifier.Protected;
public class Protected_Use extends Protected{
    public static void main(String[] args) {
        Protected_Use Anthony = new Protected_Use();
        System.out.println(Anthony.lastname);
        // Protected AccessModifier를 가진 변수 : 상속받은 클래스에서 사용가능하다.
    }
}
