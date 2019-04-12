public class ArrayTest {
    public static void main(String[] args) {
        int[][] c = new int[][] { { 1, 2, 3 }, { 4 }, { 5, 6, 7, 8 } };
        for (int i = 0; i < c.length; ++i) {
            for (int j = 0; j < c[i].length; ++j) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}