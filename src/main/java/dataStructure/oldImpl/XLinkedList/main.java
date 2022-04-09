package dataStructure.oldImpl.XLinkedList;

public class main {
    public static void main(String[] args) {
        XLinkedList xLinkedList = new XLinkedList();


        xLinkedList.prepend("8");
        xLinkedList.append("3");
        xLinkedList.append("2");
        xLinkedList.append("9");

        xLinkedList.represent();
        System.out.println();
//        xLinkedList.reverse();
//        xLinkedList.represent();
        xLinkedList.deleteAt(4);
        xLinkedList.represent();

//        xLinkedList.deleteLast();
////        xLinkedList.deleteHead();
//        xLinkedList.represent();


    }
}
