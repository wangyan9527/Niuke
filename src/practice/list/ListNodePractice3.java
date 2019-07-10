package practice.list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class ListNodePractice3 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(new int[] {1,2,3,4,5});
        ListNode list2 = new ListNode(new int[] {3,3,4,5,6});
        ListNode result = Merge1(list1, list2);
        System.out.println(result);
    }

    /**
     * 采用递归的方式
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        if (list1.val > list2.val) {
            result = list2;
            result.next = Merge(list1, list2.next);
        } else {
            result = list1;
            result.next = Merge(list1.next, list2);
        }
        return result;
    }

    /**
     * 采用非递归的方式
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        ListNode temp = null;// 用于循环处理
        // 取第一个小值
        if (list1.val > list2.val) {
            temp = list2;
            result = temp;
            list2 = list2.next;
        } else {
            temp = list1;
            result = temp;
            list1 = list1.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else if (list2 == null) {
            temp.next = list1;
        }
        return result;
    }

}
