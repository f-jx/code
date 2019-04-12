public class OuterClassTest extends OuterClass {
    public static void main(String args[]) {
        OuterClass.A a = new OuterClass.A();// 建立静态内部类对象
        B b = new OuterClass().new B();// 建立非静态内部类的对象
        // 注意这个OuterClass().new B();相当于生成一个外部类的对象,然后在利用外部类对象生成内部类对象
        OuterClass t = new OuterClass();
        t.disp();
        // 通过外部对象调用一个对象方法的形式,新建立了对象C.
    }
}

class OuterClass {
    static class A {// 静态内部类
        public A() {// 无参构造函数
            System.out.println("Test$A !");
        }
    }

    class B {// 非静态内部类
        public B() {
            System.out.println("Test$B !");
        }
    }

    public void disp() {
        final int a = 10;
        int b;
        class C { // 成员函数中的局部内部类
            public C() {
                System.out.println("in class C a=" + a);
            }
        }
        C c = new C();
    }
}
