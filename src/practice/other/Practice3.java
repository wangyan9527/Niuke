package practice.other;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Practice3 {

    public static void main(String[] args) {
        System.out.println(RectCover1(29));
    }

    /**
     * 与之前的青蛙跳阶梯一样,2*n可以从2*(n-1)或2*(n-2)两种情况得到
     * 所以也是类似斐波拉契数列
     * 以下通过递归方式来处理
     *
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    /**
     * 通过设置值得方式进行计算
     *
     * @param target
     * @return
     */
    public static int RectCover1(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int a = 1,b = 2,c = 0;
            for (int i = 3; i <= target; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

}
