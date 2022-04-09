package dataStructure.oldImpl.XBinaryTree;

public class main {
    public static void main(String[] args) {

        BinaryTree<Integer,String> binaryTree = new BinaryTree<Integer, String>();

        binaryTree.add(3,"3");
        binaryTree.add(1,"1");
        binaryTree.add(7,"7");
        binaryTree.add(5,"5");
        binaryTree.add(4,"4");

        System.out.println("Height " + binaryTree.height());

        System.out.println(binaryTree.keys());

    }


}
