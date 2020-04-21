package XBinaryTree;

public class main {
    public static void main(String[] args) {

        BinaryTree<Integer,String> binaryTree = new BinaryTree<Integer, String>();

        binaryTree.add(4,"4");
        binaryTree.add(5,"5");
        binaryTree.add(1,"1");
        binaryTree.add(2,"2");
        binaryTree.add(7,"7");
        binaryTree.add(65,"7");

        System.out.println(binaryTree.get(4));
        System.out.println(binaryTree.get(5));
        System.out.println(binaryTree.get(1));
        System.out.println(binaryTree.get(2));
        System.out.println(binaryTree.get(7));
        binaryTree.remove(65);


        System.out.println(binaryTree.keys());

    }
}
