package practice.other;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Practice2 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(25));
    }

    /**
     * 采用递归的方法来实现,
     * 比如4级阶梯,可以通过1级阶梯直接跳到4级阶梯,也可通过2级直接跳,也可通过3级直接跳,所以结果为之前的所有次数的和
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int count = 0;
            for (int i = 1; i < target; i++) {
                count += JumpFloor(i);
            }
            return count + 1;// 直接跳n级,算一步
        }
    }

    /**
     * 递归的方式都可以换成数组来解决
     *
     * @param target
     * @return
     */
    public static int JumpFloor1(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int[] arr = new int[target];
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < arr.length; i++) {
                int i1 = i;
                while(i1 > 0) {
                    arr[i] += arr[--i1];
                }
                arr[i]++;// 加上一步
            }
            return arr[target - 1];
        }
    }

}
