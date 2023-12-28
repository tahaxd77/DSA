public class Main {
    public static void main(String[] args)
    {
        BinarySeachTree bst = new BinarySeachTree();
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 77);
        bst.root = bst.insert(bst.root, 55);
        bst.root = bst.insert(bst.root, 90);
        bst.root = bst.insert(bst.root, 100);
        bst.deleteNode(bst.root, 30);
        bst.Inorder(bst.root);
//        System.out.println(bst.findParent(bst.root, 40));
//        System.out.println(bst.height(bst.root, 100));
//        System.out.println(bst.numberOfNodes(bst.root));
//        System.out.println(bst.inOrderSuccessor(bst.root, 40));
        //System.out.println(bst.inOrderSuccessor(bst.root,20));
        //System.out.println(bst.LCA(bst.root, 60, 77));
    }
}