package practice.sort;

import java.util.Arrays;

/**
 * 一副从1到n的牌,每次从牌堆顶取一张放桌子上,再取一张放牌堆底,直到手里没有牌.最后桌子上的牌是从1到n有序,设计程序,输入n,输出牌堆的顺序数组
 */
public class SortPractice1 {

    public static void main(String[] args) {
        int[] array = sort2(6);
        System.out.println("result = " + Arrays.toString(array));
    }

    /**
     * 逆向倒推，将桌子上已经排好序的牌反过来恢复到手中，得到结果
     * <p>
     * 第一步，将桌子上最后一张牌放到手中(也是数值为n的最大的牌)
     * 第二步，继续从桌子上拿最后一张牌，放到手中牌的最前面
     * 第三步，将手中牌的最后一张拿出并放到手中第一张牌的后面一个位置
     * 第四步，重复第二步和第三步，直到桌子上的牌拿完，最后手中牌的顺序为所需数组顺序
     * <p>
     * 这种方法不推荐
     *
     * @param n
     * @return
     */
    public static int[] sort1(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                array[n - 1] = n;
            } else {
                // 将新的牌插入到最上面
                array[n - i - 1] = n - i;
                // 记录最后一张牌的值
                int last = array[n - 1];
                // 新牌后面所有的牌向后移动一位
                for (int j = n - 1; j > n - i; j--) {
                    array[j] = array[j - 1];
                }
                // 将原来的最后一张牌放到新牌的后面
                array[n - i] = last;
            }
        }
        return array;
    }

    /**
     * 1.先将已排好序的牌按照题目要求进行重新排列，得到杂乱无章的牌
     * 2.按题目要求我们最终得到的是排好序的牌
     * 3.所以我们需要将第一步所得的杂乱无章的牌排成有序的，这样就会造成第一步原本有序的牌因为这次变动变得无序，而这就是我们需要的结果
     * 例：
     * 步骤1：拿到一副已经排好序了的牌a1
     * 步骤2：将a1这幅牌按照题目要求进行重排序得到a2
     * 步骤3：为了a2这幅牌满足题目最终要求变成有序的，需要对a2进行重排序为a3(有序)
     * 步骤4：由于步骤3的影响，或者说为了得到a3，我们需要对a1进行重排序来满足a1到a3的变化，所以此时a1变成无序的而a2变成有序的了
     * <p>
     * 刚开始有一副牌a1[1,2,3,4,5,6]按要求得到a2[1,3,5,2,6,4],由于题目要求我们最终得到的是a3[1,2,3,4,5,6]
     * 所以将a2转为a3，而由于这种转化会导致原来的a1发生变化，而变化后的a1就是我们要的结果
     * <p>
     * 以下是a2数组的下标以及对应的值(下标+1看起来更清晰)，
     * a2[1]=1,a2[2]=3,a2[3]=5,a2[4]=2,a2[5]=6,a2[6]=4,
     * 我们可以将a3看成a2的value,将a1看成a2的下标(并没有逻辑，只是为了方便，也可以通过两个数组来表示:[1,2,3,4,5,6]和[1,3,5,2,6,4])
     * <p>
     * 而将a2的value排成有序造成a2下标发生的变化就是步骤4的过程，最终得到的a2的下标就是我们所要的结果
     * a2[1]=1,a2[4]=2,a2[2]=3,a2[6]=4,a2[3]=5,a2[5]=6 所以结果是[1,4,2,6,3,5]
     *
     * 这种方法比第一种能适合更复杂的情况。
     *
     * @param n
     * @return
     */
    public static int[] sort2(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        // 按照题目要求进行重排序
        for (int i = 0; i < n - 1; i++) {
            // 将i+1位置的值放到最后面，同时后面的所有值前移一位
            int temp = array[i + 1];// 先将后一位的值保存起来
            System.arraycopy(array, i + 2, array, i + 1, n - i - 2);
            array[n - 1] = temp;
        }
        int[] result = new int[n];
        // 此时array为乱序，需要将array下标和值进行调换
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == array[j]) {
                    result[i - 1] = j + 1;
                }
            }
        }
        array = result;
        return array;
    }

}
