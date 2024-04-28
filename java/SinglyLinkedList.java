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

    public void insertAtBegining(int value) {
        ListNode newNode = new ListNode(value);

        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);

        if ( head == null ) {
            head = newNode;
        }

        ListNode current = head; // act the cursor to traverse the list

        // traverse till we reach the end
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode; // the last node to point to new node
    }
    
    public void insertAtPosition(int position, int value) {
        ListNode newNode = new ListNode(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        }

        ListNode previous = head; 
        
        int i = 1;
        while (i < position - 1 ) {
            previous = previous.next;
            i++;
        }
        ListNode current = previous.next;
        previous.next = newNode;
        newNode.next = current;
    }

    public int deleteAtBegining() {
        if (head == null) {
            System.out.println("Deletion while head is null");
            return 1;
        }

        ListNode hold = head.next;
        head = hold;
        return 0;
    }

    public int deleteAtEnd() {
        if (head == null) {
            System.out.println("Deletion while head is null");
            return 1;
        }
        ListNode current = head;

        while(current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return 0;
    }

    public int deleteAtPosition(int position) {
        // check if head is null
        if (head == null) {
            System.out.println("Deletion while head is null");
            return 1;
        }

        if (position == 1) {
            ListNode hold = head.next; 
            head = hold;
        }

        ListNode previous = head;
        int count = 1;

        while (count < position - 1) {
            // traverse till previous is behind by one value 
            previous = previous.next;
            count++;
        }

        ListNode current = previous.next;
        ListNode hold = current.next; // hold the rest of the list while we delete
        previous.next = null; // breaking with the next node
        current.next = null; // breaking with the node to delete with the rest of the list
        previous.next = hold; // connecting with the rest of the list
        return 0;
    }   

    public boolean search(int searchKey) {
        ListNode current = head; 
        
        while (current.next != null) {
            if (current.data == searchKey) {
                return true;
            } 
            current = current.next;
        }
        return false;
    }

    public SinglyLinkedList reverse() {
        // returns a reversed list
        SinglyLinkedList reversedList = new SinglyLinkedList();

        ListNode current = head;
        while( current != null) {
            // append to reversedList
            reversedList.insertAtBegining(current.data);
            current = current.next;
        }
        return reversedList;
    }

    public int findValueAtPosition(int position) {
        ListNode current = head;
        
        int count = 1;
        while ( count < position ) {
            current = current.next;
            count++;
        }
        return current.data;
    }

    public static void main(String args[]){
        // creating a list
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(6); // required

        sll.insertAtEnd(8);
        sll.insertAtEnd(4);
        sll.insertAtEnd(3);
        sll.insertAtBegining(4);
        sll.insertAtBegining(9);
        sll.insertAtBegining(7);
        sll.insertAtPosition(3, 12);

        sll.printSinglyLinkedList();
        System.out.println(sll.findValueAtPosition(2));

    }
}
