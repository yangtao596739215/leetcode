package 链表;

public class 删除链表中的重复节点 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNod2 = new ListNode(2);
        ListNode listNod3 = new ListNode(3);
        ListNode listNod4 = new ListNode(3);
        ListNode listNod5 = new ListNode(4);
        ListNode listNod6 = new ListNode(4);
        ListNode listNod7 = new ListNode(5);
        listNode1.next = listNod2;
        listNod2.next = listNod3;
        listNod3.next = listNod4;
        listNod4.next = listNod5;
        listNod5.next = listNod6;
        listNod6.next = listNod7;
        ListNode listNode = deleteDuplication(listNode1);
        System.out.println(listNode);
    }

    public static ListNode deleteDuplication(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        pre.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            int same = Integer.MIN_VALUE;
            while(cur.next != null && cur.val == cur.next.val){
                same = cur.val;
                cur.next = cur.next.next;
            }
            if(cur.next == null)  pre.next = null;
            else{
                if(same != cur.val) {
                    pre = cur;
                    cur = cur.next;
                }
                else{
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        return newHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }



    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
