package practice.stack;

import java.util.Arrays;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 3,5,4,2,1是正确的
 */
public class Practice {

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[] {1}, new int[]{2, 1}));
    }

    /**
     * 出栈顺序只能是上一个出栈的前一个元素或则后面的元素，不能是前一个元素之前的元素
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        for (int i = 0, lastIndex = -1; i < popA.length; i++) {
            for (int j = 0; j < pushA.length; j++) {
                if (pushA[j] == popA[i]) {
                    if (lastIndex != -1 && j < lastIndex - 1) {
                        return false;
                    } else {
                        lastIndex = j;
                    }
                }
            }
            if (lastIndex == -1) {
                return false;
            }
            // 把取出的元素从pushA中删除,同时数组缩容
            System.arraycopy(pushA, lastIndex + 1, pushA, lastIndex, pushA.length - lastIndex - 1);
            pushA = Arrays.copyOf(pushA, pushA.length - 1);
        }
        return true;

    }

}
