package oops;

public class D {
    public static void main(String[] args) {
        A a = new C();
        a.display();
        System.out.println(fun(true));
    }

    public static A fun(boolean flag) {
        if (flag)
            return new C();
        else
            return new B();

    }
}
