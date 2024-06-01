import jdk.internal.classfile.components.ClassPrinter.ListNode;

class DoublyLinkedList {
    // previous, data, next
    
    public ListNode head;
    public ListNode tail;

    class ListNode {

        public ListNode previous;
        public int data;
        public ListNode next;

        // intialization
        ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // creating data
        dll.head = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(5)
        dll.tail = new ListNode(6);

        // connecting forward
        dll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = dll.tail;

        // connecting backwards
        dll.tail.previous = fourth;
        fourth.previous = third;
        third.previous = second;
        second.previous = dll.head;

    }

}
