package practice.Fibonacci;

/**
 * 斐波拉契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 0,1,1,2,3,5,8,13,21...
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci1(8));
    }

    /**
     * 第n项的值等于第n-1项的值+第n-2项的值,
     * 可采用递归的方式进行计算
     * 该方法耗时长且占用空间大
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 该方式耗时较少
     *
     * @param n
     * @return
     */
    public static int fibonacci1(int n) {
        int a = 1, b = 1, c = 0;
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

}
