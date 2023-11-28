public class Main {
    public static void main(String[] args)
    {
        BinarySeachTree bst = new BinarySeachTree();
        bst.root = bst.insert(bst.root, 10);
        bst.root = bst.insert(bst.root, 13);
        bst.root = bst.insert(bst.root, 25);
        bst.root = bst.insert(bst.root, 38);
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 77);
        bst.root = bst.insert(bst.root, 90);
        bst.root = bst.insert(bst.root, 100);
        bst.FindMax();
        System.out.println(bst.hasRight(bst.root, 10));
        bst.Inorder(bst.root);
        bst.PostOrder(bst.root);
        System.out.println("///////////////////////");
        bst.PreOrder(bst.root);
        System.out.println(bst.HasSibling(bst.root, 25));
        bst.search(25);


    }
}