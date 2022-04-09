package dataStructure.oldImpl.XHashMap;

import java.util.NoSuchElementException;

public class XHashMap {
    private final int[] keys;
    private final Node[] hashNodes;

    public XHashMap(int size) {
        this.keys = new int[size];
        this.hashNodes = new Node[size];
    }

    static class Node {
        String value;
        Node next;
        int key;

        public Node(int key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
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

    public void put(int key, String value) {
        int index = index(key);

        keys[index] = key;
        if( get(key) != null){
            get(key).setValue(value);
        }
        if (hashNodes[index] != null) {
            sendToNodeList(key, index, value);
        } else {
            hashNodes[index] = new Node(key, value, null);

        }
        hashNodes[index].setValue(value);
    }

    private void sendToNodeList(int key, int index, String value) {


        Node curent = hashNodes[index];
        Node newNode = new Node(key, value, null);


        while (curent.next != null) {
            curent = curent.next;
        }
        curent.next = newNode;

    }

    private int index(int key) {
        return key % 16;
    }

    public Node get(int key) {
        int index = index(key);
        if (keys[index] == 0) throw new NoSuchElementException();

            Node current = hashNodes[index];
            while (current != null) {
                if (current.key == key) return current;
                current = current.next;
            }

        return null;
    }
}
