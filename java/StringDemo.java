public class StringDemo {
    public static void main(String[] args) {
        String first = "zhang", last = "san";
        String name = first + " " + last;
        System.out.println("Name = " + name);
        double pi = 3.14159;
        String s = "Hello, " + first;
        System.out.println(s + pi + 7);// pi和7被当作是字符型
        System.out.println(pi + 7 + s);// pi和7都当作double型数值来运算
    }
}