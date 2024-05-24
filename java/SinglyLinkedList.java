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

    public void print() {
        
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        ListNode current = head; // used as the cursor to iterate the list

        int length = 0; // keep track of the length
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // insert a newNode in the begining of the list
    public void unshift(int value) {
        ListNode newNode = new ListNode(value);

        newNode.next = head;
        head = newNode;
    }

    // add a newNode at the end of the list
    public void append(int value) {
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
    
    // add a newNode at a specified position
    public void insert(int position, int value) {
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

    public int deleteFirst() {
        if (head == null) {
            System.out.println("Deletion while head is null");
            return 1;
        }

        ListNode hold = head.next;
        head = hold;
        return 0;
    }

    public int deleteLast() {
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

    // remove a node from a specified position
    public int delete(int position) {
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

    public boolean isExists(int searchKey) {
        ListNode current = head; 
        
        while (current.next != null) {
            if (current.data == searchKey) {
                return true;
            } 
            current = current.next;
        }
        return false;
    }

    public SinglyLinkedList reversed() {
        // returns a reversed list
        SinglyLinkedList reversedList = new SinglyLinkedList();

        ListNode current = head;
        while( current != null) {
            // append to reversedList
            reversedList.unshift(current.data);// add the node to the begining
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

    // Floyd's loop detection algorithm
    public ListNode detectLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        // fastPtr -> 2 steps : slowPtr -> 1 step
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next; // 2 steps
            slowPtr = slowPtr.next; // 1 step

            // if they meet
            if ( fastPtr == slowPtr) {
                return getStartingOfLoopedList(slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartingOfLoopedList(ListNode slowPtr) {
        ListNode tmp = head;

        while ( tmp != slowPtr){
            tmp = tmp.next;
            slowPtr = slowPtr.next;
        }

        return tmp;
    }
    

    private SinglyLinkedList createLoopedList () {
        SinglyLinkedList loopedList = new SinglyLinkedList();

        // creating the list
        loopedList.head = new ListNode(1); // creating the head
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        // connecting the list
        loopedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return loopedList;
    }

    public static void main(String args[]){
        // creating a list
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(6); // required

        sll.append(8);
        sll.append(4);
        sll.append(3);
        sll.unshift(4);
        sll.unshift(9);
        sll.unshift(7);
        sll.insert(3, 12);

        // created a looping linked list
        SinglyLinkedList loopedList = sll.createLoopedList();
        ListNode startPoint = loopedList.detectLoop();

        System.out.println(startPoint.data);
    }
}
