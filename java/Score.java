public class Score {
    public static void main(String[] args) throws java.io.IOException {
        String str = ""; // 声明字符串
        char c = ' ';
        // 声明字符型变量
        int score;
        // 声明整型变量
        System.out.println("请输入分数:\n");
        while (c != '\n') // 如果按回车键,则退出循环
        {
            c = (char) System.in.read(); // 从键盘输入一个字符赋值给c
            str = str + c; // 将字符添加到str的末尾;?为什么？
            str = str.trim();// 除去字符串开始和尾部空格
        }
        score = Integer.parseInt(str); // 将字符串转换为整型数
        if (score >= 90 & score <= 100)
            System.out.println("优秀");
        else if (score >= 80 & score < 90)
            System.out.println("良好");
        else if (score >= 70 & score < 80)
            System.out.println("中等");
        else if (score >= 60 & score < 70)
            System.out.println("及格");
        else if (score >= 0 & score < 60)
            System.out.println("不及格");
        else
            System.out.println("输入错误!");
    }
}