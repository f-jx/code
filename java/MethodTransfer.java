public class MethodTransfer {
    public static String name = "张三";

    public static String getName() {
        return name;
    }

    public static void main(String[] args)// java程序从main函数开始，堆栈调用其它方法，最后回归到main方法
    {
        getName();
    }

}