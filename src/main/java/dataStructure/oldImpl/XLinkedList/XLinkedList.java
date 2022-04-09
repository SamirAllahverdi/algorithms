package dataStructure.oldImpl.XLinkedList;

public class XLinkedList {

    class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }


        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node head = null;

    public void prepend(String value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void append(String value) {
        Node newNode = new Node(value, null);
        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.setNext(newNode);
    }


    public void represent() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }


    public void insertBeforeValue(String lookForValue, String value) {
        Node newNode = new Node(value, null);
        Node curr = head;
//        Node curr
        while (curr.next.value == lookForValue) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }

    public String reverse_order() {
        Node curr = head;
        return represent_reverse(curr, curr.value);
    }

    public String represent_reverse(Node node, String joiner) {
        if (node.next == null) return joiner;
        return represent_reverse(node.next, node.next.value + joiner);
    }

    public String normal_order() {
        Node curr = head;
        return represent_normal(curr, curr.value);
    }

    public String represent_normal(Node node, String joiner) {
        if (node.next == null) return joiner;
        return represent_normal(node.next, joiner + node.next.value);
    }

    public void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node savedNext = current.next;
            current.next = previous;
            previous = current;
            current = savedNext;
        }
        head = previous;
    }

    void deleteHead() {
        head = head.next;
    }

    void deleteLast() {
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }

    void deleteAt(int index) {
        Node current = head;
        Node previous = null;
        int count = 1;
        if (index == 1) {
            head = head.next;
            return;
        }
        while (count != index) {
            previous = current;
            current = current.next;
            count++;
        }
        Node savedNext = current.next;
        current.next = null;
        previous.next = savedNext;

    }

}


