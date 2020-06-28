ipackage org.example;

public class CircularDeque {
    class ListNode{
        ListNode next;
        ListNode prev;
        int val;

        public ListNode(int val) {
            this.next = null;
            this.prev = null;
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    int cnt; // count of all the nodes
    int max;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        this.cnt = 0;
        this.max = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        // already inserted all of the values!
        if (this.cnt == this.max)
            return false;

        ListNode tmp = new ListNode(value);
        // new head element!
        if (this.cnt == 0) {
            this.head = tmp;
            this.tail = tmp;
        } else {
            this.head.prev = tmp; // point back to our new head
            tmp.next = this.head; // new head points forward
            this.head = tmp; // update the root to the new head!
        }

        this.cnt++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.cnt == this.max)
            return false;

        ListNode tmp = new ListNode(value);
        if (this.cnt == 0) {
            this.head = tmp;
            this.tail = tmp;
        } else {
            this.tail.next = tmp;
            tmp.prev = this.tail;
            this.tail = tmp;
        }

        this.cnt++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.cnt == 0)
            return false;

        if (this.cnt == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null; // remove the pointer
        }

        this.cnt--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.cnt == 0)
            return false;

        if (this.cnt == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.cnt--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return this.cnt == 0 ? -1 : this.head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return this.cnt == 0 ? -1 : this.tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.max == this.cnt;
    }
}

