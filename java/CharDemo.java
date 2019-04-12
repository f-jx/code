public class CharDemo {
    public static void main(String[] args) {
        char a = 'A';
        char b = (char) (a + 1);
        System.out.println(a + b);
        System.out.println("a + b is " + a + b);
        int x = 75;
        char y = (char) x;
        char omega = '\u03A9';// 反斜杆加u开头指的是字符型数据，0000 0011 1010 1001
        System.out.println("y is " + y + " omega is " + omega);
    }
}