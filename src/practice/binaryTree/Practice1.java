package practice.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * **** 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 二叉树的广度优先
 */
public class Practice1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        while (true) {
            if (leftNode != null) {
                result.add(leftNode.val);
                leftNode = root.left;
                rightNode = root.right;
            }
        }
    }

    /**
     * 将二叉树的每个节点按要求的顺序进行添加进有序集合，每次取第一个元素出来计算，将该元素下的左右子元素按顺序添加进集合
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> tempList = new LinkedList<>();
        if (root != null) {
            tempList.add(root);
        }
        while (tempList.size() > 0) {
            TreeNode treeNode = tempList.remove(0);
            result.add(treeNode.val);
            if (treeNode.left != null) {
                tempList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                tempList.add(treeNode.right);
            }
        }
        return result;
    }

}
