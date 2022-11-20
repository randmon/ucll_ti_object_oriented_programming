package abc;

public class ABC {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("------");
        B b = new B();
        System.out.println("------");
        C c = new C();
        System.out.println("------");
        A a2 = new B();
        System.out.println("------");
        A a3 = new C();
    }

    public static class A {
        public A() {
            System.out.println("A");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("B");
        }
    }

    public static class C extends B {
        public C() {
            System.out.println("C");
        }
    }
}
