public class Main {
    public static void main(String[] args) {
        int [] arr = {20,40,50,30,60,45,70,80};
            AVLTree tree = new AVLTree(arr);
            System.out.println(tree.contains(3));
    }
}