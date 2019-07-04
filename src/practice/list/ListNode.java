package practice.list;

public class ListNode {

    public ListNode next;

    public int value;

    @Override
    public String toString() {
        return getValue(this);
    }

    private String getValue(ListNode listNode) {
        if (listNode == null) {
            return "";
        }
        return String.valueOf(listNode.value) + "," + getValue(listNode.next);
    }

    public ListNode(int[] value) {
        if (value == null || value.length == 0) {
            return;
        }
        ListNode listNode = null;
        for (int i = value.length - 1; i > 0; i--) {
            listNode = new ListNode(listNode, value[i]);
        }
        this.next = listNode;
        this.value = value[0];
    }

    public ListNode(ListNode next, int value) {
        this.next = next;
        this.value = value;
    }
}
