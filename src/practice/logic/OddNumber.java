package practice.logic;

public class OddNumber {

    /**
     * 判断一个数是否是奇数(负奇数也算)
     *
     * 思路：看到这一题，一般都会用数学的思维方式求解，将这个数除以2，如果除不尽那这个数就是奇数
     *
     * 但我们需要用程序员的思路来解题，奇数的二进制最低位都是1，不管正数还是负数。所以可以对1按位与运算
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = -1;
        boolean result = num % 2 != 0;
        boolean result1 = (num & 1) == 1;
        System.out.println(result);
        System.out.println(result1);
    }

}
