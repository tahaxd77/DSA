public class Main {
    public static void main(String[] args) {


            AVLTree tree = new AVLTree(5);
            tree.add(3);
            tree.add(7);
            tree.add(2);
            tree.add(4);
            tree.add(6);
            tree.add(8);
            tree.print();
            tree.printTreeInOrder();
            tree.printPostOrder();
            System.out.println(tree.getHeight());
            System.out.println(tree.getRoot());
    }
}