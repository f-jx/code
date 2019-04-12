class Outer {
    private int index = 10;

    class Inner {
        private int index = 20;

        void print() {
            int index = 30;
            System.out.println(this); // the object created from the Inner
            System.out.println(Outer.this); // the object created from the Outer
            System.out.println(index); // output is 30
            System.out.println(this.index); // output is 20
            System.out.println(Outer.this.index); // output is 10
        }
    }

    void print() {
        Inner inner = new Inner();// 得到内部类的引用
        inner.print();
    }
}

public class OuterTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.print();
    }
}