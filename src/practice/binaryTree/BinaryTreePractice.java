package practice.binaryTree;

/**
 *  已知二叉树的前序遍历序列和中序遍历序列(没有重复元素),计算出该二叉树
 */
public class BinaryTreePractice {

    public static void main(String[] args) {
        int[] pre = new int[] {1,2,4,7,3,5,6,8};
        int[] in = new int[] {4,7,2,1,5,3,8,6};
        Node node = getTreeNode(pre, in);
        System.out.println(node);
    }

    /**
     * 使用递归方式实现
     *
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @return
     */
    public static Node getTreeNode(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            // 证明该节点没有左节点和右节点
            return null;
        }
        // 取得根节点元素值
        int value = pre[0];
        // 获得该根节点在中序序列中的下标位置
        int index = 0;
        for (int i = 0; i< in.length; i++) {
            if (in[i] == value) {
                index = i;
                break;
            }
        }
        // 获取该根节点左边部分的前序序列
        int leftPre[] = new int[index];
        // 获取该根节点左边部分的中序序列
        int leftIn[] = new int[index];
        for (int i = 0; i < index; i++) {
            leftPre[i] = pre[i + 1];
            leftIn[i] = in[i];
        }
        // 获取该根节点右边部分的前序序列
        int rightPre[] = new int[in.length - index - 1];
        // 获取该根节点右边部分的中序序列
        int rightIn[] = new int[in.length - index - 1];
        for (int i = 0; i < rightPre.length; i++) {
            rightPre[i] = pre[i + index + 1];
            rightIn[i] = in[i + index + 1];
        }
        Node node = new Node();
        // 设置该节点的左节点
        node.setLeft(getTreeNode(leftPre, leftIn));
        // 设置该节点的有节点
        node.setRight(getTreeNode(rightPre, rightIn));
        node.setValue(value);
        return node;
    }

}


class Node {

    private Node left;// 左节点

    private Node right;// 右节点

    private int value;// 本节点的值

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ",  right=" + right +
                '}';
    }
}
