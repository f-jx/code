public class RootTest {
    public static void main(String[] args) {
        new RootLeaf();
        new RootLeaf();
    }
}

// static声明的是类级变量/全局变量/静态变量，只在类加载的时候优先立刻执行一次，之后实例化不再执行
// 类中没有static声明的是对象实例级变量/成员变量，在类每次实例化的时候都会执行一次。
// 方法块中的变量是方法/块级变量/局部变量，只有在方法被调用时执行，方法结束立即销毁。
// super()方法执行父类构造方法，因此随父类构造方法一起执行，在子类实例化之前执行。
// this和super，分别指代当前对象和其直接父类对象。

class Root {
    static {
        System.out.println("父类的静态初始化块");
    }
    {
        System.out.println("父类的普通初始化块");
    }

    public Root() {
        System.out.println("父类的无参数构造函数");
    }

    public Root(String name) {
        this();
        System.out.println("父类的带参构造函数" + name);
    }
}

class RootLeaf extends Root {
    static {
        System.out.println("子类的静态初始化块");
    }

    {
        System.out.println("子类的普通初始化块");
    }

    public RootLeaf() {
        super("abc");// 直接调用父类带参构造函数，在子类普通初始化之前执行。
        System.out.println("子类的无参构造函数");
    }
}
