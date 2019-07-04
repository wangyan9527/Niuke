package practice.list;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class ListNodePractice2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[] {1, 2, 3, 4, 5});
        ListNode result = ReverseList(listNode);
        System.out.println(result);
    }

    /**
     * 将某个节点的next指针指向前一个元素
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode preNode = null;
        while(head != null) {
            ListNode nextNode = head.next;// 获取下一个节点
            head.next = preNode;// 将当前节点的next指针指向上一个元素
            preNode = head;// 获取上一个节点,用于下一次循环
            head = nextNode;
        }
        return preNode;
    }

}
