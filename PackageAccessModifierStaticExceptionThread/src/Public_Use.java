import AccessModifier.Public;

public class Public_Use {

    public static void main(String[] args) {
        Public Anthony = new Public();
        System.out.println(Anthony.info);
        // 어디에서나 접근 가능.
        // extends시, lastname도 접근 가능.
    }
}
