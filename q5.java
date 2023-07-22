class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to merge two linked lists and sort the merged list
    public static LinkedList mergeAndSort(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        Node tail = null;

        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                if (tail == null) {
                    mergedList.head = curr1;
                    tail = curr1;
                } else {
                    tail.next = curr1;
                    tail = tail.next;
                }
                curr1 = curr1.next;
            } else {
                if (tail == null) {
                    mergedList.head = curr2;
                    tail = curr2;
                } else {
                    tail.next = curr2;
                    tail = tail.next;
                }
                curr2 = curr2.next;
            }
        }

        // Attach the remaining nodes of both lists, if any
        if (curr1 != null) {
            tail.next = curr1;
        }

        if (curr2 != null) {
            tail.next = curr2;
        }

        // Sort the merged list using quicksort algorithm
        mergedList.head = quickSort(mergedList.head);

        return mergedList;
    }

    // Method to perform quicksort on the linked list
    private static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pivot = head;
        Node curr = head.next;
        Node smallerHead = null;
        Node smallerTail = null;
        Node greaterHead = null;
        Node greaterTail = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if (curr.data <= pivot.data) {
                if (smallerHead == null) {
                    smallerHead = curr;
                    smallerTail = curr;
                } else {
                    smallerTail.next = curr;
                    smallerTail = curr;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = curr;
                    greaterTail = curr;
                } else {
                    greaterTail.next = curr;
                    greaterTail = curr;
                }
            }
            curr = next;
        }

        Node sortedSmaller = quickSort(smallerHead);
        Node sortedGreater = quickSort(greaterHead);

        if (sortedSmaller == null) {
            pivot.next = sortedGreater;
            return pivot;
        }

        Node sortedHead = sortedSmaller;
        while (sortedSmaller.next != null) {
            sortedSmaller = sortedSmaller.next;
        }
        sortedSmaller.next = pivot;
        pivot.next = sortedGreater;

        return sortedHead;
    }

    // Method to print the linked list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        // Add elements to list1
        list1.head = new Node(25);
        list1.head.next = new Node(35);
        list1.head.next.next = new Node(12);
        list1.head.next.next.next = new Node(4);
        list1.head.next.next.next.next = new Node(36);
        list1.head.next.next.next.next.next = new Node(48);

        // Add elements to list2
        list2.head = new Node(8);
        list2.head.next = new Node(32);
        list2.head.next.next = new Node(22);
        list2.head.next.next.next = new Node(45);
        list2.head.next.next.next.next = new Node(63);
        list2.head.next.next.next.next.next = new Node(49);

        // Merge and sort the linked lists
        LinkedList mergedList = LinkedList.mergeAndSort(list1, list2);

        // Print the sorted linked list
        mergedList.printList();
    }
}
