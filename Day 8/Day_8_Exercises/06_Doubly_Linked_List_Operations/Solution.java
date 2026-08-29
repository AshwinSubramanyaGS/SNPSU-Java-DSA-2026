public class Solution {
    static class Node {
        int value; Node prev, next;
        Node(int value) { this.value = value; }
    }
    static class DoublyList {
        Node head, tail;
        void addFirst(int value) { /* implement */ }
        void addLast(int value) { /* implement */ }
        boolean removeFirst(int value) { /* implement */ return false; }
        int[] toArray() { /* implement */ return new int[0]; }
    }
}
