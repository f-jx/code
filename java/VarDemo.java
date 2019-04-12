public class VarDemo {
    public static String name = "变量作用域例程"; // 类级变量
    public int i; // 对象实例级变量
    // 初始化块
    {
        int j = 2;// 块级变量
    }

    public void method1() {
        int j = 3; // 方法级变量
        if (j == 3) {
            int k = 5; // 块级变量
        }
        // 块级变量只能在块内部访问
        System.out.println("name=" + name + ", i=" + i + ", j=" + j);
    }

    public static void main(String[] args) {
        // 不创建对象,直接通过类名访问类级变量
        System.out.println(VarDemo.name);
        // 创建对象并访问它的方法
        VarDemo demo = new VarDemo();
        demo.method1();
    }
}