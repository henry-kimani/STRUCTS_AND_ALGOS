public class SinglyLinkedList {

    // the head for the list that will be created 
    private ListNode head;

    // Creates the list nodes
    private static class ListNode {
        // instance variables

        // the variable that holds the data in the node
        private int data; // should be a generic type

        // the variable that help point to the next node
        private ListNode next;

        // When creating an instance of the class, it will require the data to store
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printSinglyLinkedList() {
        
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int lengthOfSinglyLinkedList() {
        ListNode current = head; // used as the cursor to iterate the list

        int length = 0; // keep track of the length
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    public static void main(String args[]){
        // creating a list
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(5);

        // connecting the list
        sll.head.next = second; // head's next will point to second
        second.next = third;
        third.next = fourth;

        sll.printSinglyLinkedList();
        int length = sll.lengthOfSinglyLinkedList();
        System.out.println(length);
    }
}
