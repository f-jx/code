
// import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 增强for循环
 */
public class NewForTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        int sum1 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum1 = sum1 + list.get(i);
        }
        System.out.println("普通循环计算结果" + sum1);
        int sum2 = 0;
        for (int c : list) {// 用增强for循环来写
            sum2 = sum2 + c;
        }
        System.out.println("增强for循环计算结果" + sum2);
    }
}