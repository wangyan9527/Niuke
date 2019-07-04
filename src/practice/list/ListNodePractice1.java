package practice.list;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class ListNodePractice1 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[] {1, 2, 3, 4, 5});
        ListNode result = FindKthToTail(listNode, 0);
        System.out.println(result);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k == 0) {
            return null;
        }
        int index = 1;
        ListNode result = null;
        ListNode newNode = head;
        while(head != null) {// 循环，作用是是循环次数为该链表的长度
            if (index >= k) {
                result = newNode;
                newNode = newNode.next;
            }
            head = head.next;
            index ++;
        }
        return result;
    }

}
