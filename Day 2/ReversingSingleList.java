//Leetcode 206 

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;

        return list.get(list.size() - 1);
    }
};
