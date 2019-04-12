public class BooleanDemo {
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("t的值是" + t);
        int x = 2;
        boolean y = (x > 2);
        System.out.println("y的值是" + y);
        x = x + 1;
        y = (x > 2);
        System.out.println("在x加1后，\ny是" + y);
    }
}