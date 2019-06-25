package practice.other;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Practice5 {

    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    /**
     * 求次方可以通过指数来求
     * 例:10的14次方,14的二进制为1110,10的14次方可以分解为10的1000次方*10的100次方*10的10次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        } else {
            double result = 1;
            int positive = Math.abs(exponent);
            for (int i = 1; i <= positive; i <<= 1) {
                if ((i & positive) == i) {
                    result *= Math.pow(base, i);
                }
            }
            return exponent > 0 ? result : 1 / result;
        }
    }

}
