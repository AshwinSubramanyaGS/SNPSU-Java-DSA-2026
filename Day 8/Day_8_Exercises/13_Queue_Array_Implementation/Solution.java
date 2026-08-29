public class Solution {
    static class IntQueue {
        private final int[] data; private int front = 0, size = 0;
        IntQueue(int capacity) { data = new int[capacity]; }
        boolean enqueue(int value) { /* implement */ return false; }
        int dequeue() { /* implement */ return Integer.MIN_VALUE; }
        int peek() { /* implement */ return Integer.MIN_VALUE; }
        boolean isEmpty() { /* implement */ return true; }
        boolean isFull() { /* implement */ return false; }
    }
}
