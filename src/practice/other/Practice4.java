package practice.other;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 负数等于正数取反+1
 */
public class Practice4 {

    public static void main(String[] args) {
        System.out.println(NumberOf1(-2147483648));
    }

    /**
     * 采用递归的方式来计算
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        if (n > 0) {
            return n % 2 + NumberOf1(n / 2);// 为正数时，1的个数
        } else {
            return 32 - ((- 1 - n) % 2 + NumberOf1((- 1 - n) / 2));// 为负数时，0的个数
        }
    }

    /**
     * 二进制相关操作可使用位运算来计算
     * 以下通过移位运算来处理
     *
     * @param n
     * @return
     */
    public static int NumberOf2(int n) {
        return 0;
    }

}
