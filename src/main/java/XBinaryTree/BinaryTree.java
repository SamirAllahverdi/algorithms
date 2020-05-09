package XBinaryTree;

import java.util.*;

public class BinaryTree<K extends Comparable<K>, V> {

    class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // runner part
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // recursive part
    private Node add(Node x, K key, V value) {
        if (x == null) return new Node(key, value); // null -> creating
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key, value);   // <, go left
        else if (cmp > 0) x.right = add(x.right, key, value); // >, go right
        else x.value = value;                       // we found, need to replace
        return x;
    }

    // runner part
    public Optional<V> get(K key) {
        return get(root, key);
    }

    // recursive part
    private Optional<V> get(Node x, K key) {
        if (x == null) return Optional.empty();     // we didn't find
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);  // goto left
        else if (cmp > 0) return get(x.right, key); // goto right
        else return Optional.of(x.value);           // we found
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node x, K key) {
        // finish. not found
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = remove(x.left, key);
        else if (cmp > 0) x.right = remove(x.right, key);
        else {
            // left is empty. just pull-up right
            if (x.left == null) return x.right;
            // right is empty. just pull-up left
            if (x.right == null) return x.left;
            // both occupied, need more work.
            x = performNodeRemoval(x);
        }
        return x;
    }

    private Node performNodeRemoval(Node x) {
        // 1. save the left sub-tree. we will attach it in 4.3
        Node savedLeft = x.left;
        // 2. find the minimal in the right sub-tree.
        // It will be new instead of deleted
        Node newNode = findMinFrom(x.right);
        // 3. remove the minimal from the right sub-tree
        Node newRight = deleteMinAndPullUpFrom(x.right);
        // 4.2. attach new right
        newNode.right = newRight;
        // 4.3. attach saved left
        newNode.left = savedLeft;
        return newNode;
    }

    private Node findMinFrom(Node x) {
        return x.left == null ? x : findMinFrom(x.left);
    }

    private Node deleteMinAndPullUpFrom(Node x) {
        // left is empty. we found it. skip it. just pull-up right. return right sub-tree
        //   we link x.left and x.right which its x.left is null
//    we do not touch other side , at last we return modified Node
        if (x.left == null) return x.right;
        // we didn't find. need go left to find it
        x.left = deleteMinAndPullUpFrom(x.left);
        return x;
    }

    public Set<K> keys() {
        HashSet<K> keys = new HashSet<>();
        processNode(root, keys);
        return keys;
    }

    public void processNode(Node x, Set<K> acc) {
        if (x == null) return;
        acc.add(x.key);
        processNode(x.left, acc);
        processNode(x.right, acc);
    }


//    height of binary search tree
    public int height() {
        return Math.max(recursion(root.left), recursion(root.right));
    }


    public int recursion(Node root) {
        List<Integer> list = new ArrayList<>();
            if (root == null) {
            return 0;
        }
        return Math.max(recursion(root.left), recursion(root.right))+1;
    }


}

