public class AndDemo {
    public static void main(String[] args) {
        int n1 = 1, n2 = 2, n3 = 3, n4 = 4;
        boolean x = true, y = true;
        boolean z = (x = n1 > n2) && (y = n3 > n4);// 判定x=false，直接得出z=false，不再对y=n3>n4进行运算，所以y=true。
        // 逻辑运算又成为布尔运算，主要用于条件判定，其结果只有true和false两种，只要从符号左边能得到结果，就不对右边进行判定。
        System.out.println("&&: x=" + x + ",y=" + y + ",z=" + z);
        x = true;
        y = true;
        z = (x = n1 > n2) & (y = n3 > n4);// 判定x=false，y=false，两者运算得出结果z=false。
        // 按位运算是一种二进制运算，必须对两边都进行运算后才能得出结果。若两个数都是布尔值，其结果与逻辑运算相同。
        System.out.println("&: x=" + x + ",y=" + y + ",z=" + z);
    }
}