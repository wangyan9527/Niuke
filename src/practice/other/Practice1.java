package practice.other;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Practice1 {

    public static void main(String[] args) {
        System.out.println(JumpFloor1(29));
    }

    /**
     * 采用穷举法来计算
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        int totalCount = 0;
        // a表示1的个数,b表示2的个数
        for (int a = target, b = 0; b * 2 <= target; b += 1, a -= 2) {
            int jumpCount = a + b;// 总共跳多少次
            int c = b;
            long a1 = 1, a2 = 1;// a1和a2分别表示分子和分母,注意这里可能会越界,所以用long类型
            while (c > 0) {
                a1 *= jumpCount--;
                a2 *= c--;
            }
            totalCount += (a1 / a2);
        }
        return totalCount;

    }

    /**
     * 思路:
     * 因为每次可以跳1或者2，所以要计算跳到指定级数n的阶梯，前一步必然是在n-1阶梯或者n-2级阶梯
     * 所以就需要计算n-1和n-2级阶梯的跳发数量，一次类推，类似于斐波拉契数列
     *
     * @param target
     * @return
     */
    public static int JumpFloor1(int target) {
        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return a;
        } else if (target == 2) {
            return b;
        } else {
            for (int i = 3; i <= target; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
}
