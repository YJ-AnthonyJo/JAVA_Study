package AccessModifier;

// 접근제어자로 private이 붙은 변수, 메소드는 해당 클래스에서만 접근이 가능하다.
public class Private {
    private String secret = "Secret";
    private String getSecret(){
        return this.secret;
    }

    public static void main(String[] args) {
        Private test = new Private();
        System.out.println(test.getSecret());
        System.out.println(test.secret);
        //클래스 안에서 정상작동.
    }
}

class AccessAttempt{
    public static void main(String[] args) {
        Private test = new Private();
//        System.out.println(test.getSecret);
//        System.out.println(test.secret);
        //두 print문 다 에러. -> 해당 클래스에서만 접근 가능
    }
}