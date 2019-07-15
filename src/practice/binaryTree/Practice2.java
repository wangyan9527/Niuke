package practice.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 后序遍历：左节点->右节点->根节点
 *
 * 二叉搜索数:又称二叉查找树，它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
 */
public class Practice2 {

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[] {4, 6, 7, 5}));
    }

    /**
     * 利用二叉搜索树的特点，左节点<根节点<右节点，后序排序的最后一个元素是主的根节点，
     * 将数组按大小拆分为左二叉树数组和右二叉树数组，进行递归
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return check(sequence);
    }

    private static boolean check(int [] arr) {
        if (arr.length == 0) {
            return true;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i ++) {
            if (arr[i] < arr[arr.length - 1]) {
                leftList.add(arr[i]);
                if (flag) {
                    return false;
                }
            } else {
                flag = true;
                rightList.add(arr[i]);
            }
        }
        return check(leftList.stream().mapToInt(Integer::intValue).toArray())
                && check(rightList.stream().mapToInt(Integer::intValue).toArray());
    }

}
