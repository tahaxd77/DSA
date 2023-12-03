import static com.sun.tools.javac.code.Kinds.KindSelector.NIL;

public class AVLTree {
    int value;
    int height;
    AVLTree left;
    AVLTree right;

    AVLTree (){
        left = this;
        right = this;
        height = -1;
    }
    AVLTree(int value) {
        this.value = value;
        left = null;
        right = null;
    }
    AVLTree(int value, AVLTree left, AVLTree right){
        this.value = value;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }
    public AVLTree grow(int value){
        if(value < this.value){
            if(left == null){
                left = new AVLTree(value);
            }else{
                left = left.grow(value);
            }
        }else{
            if(right == null){
                right = new AVLTree(value);
            }else{
                right = right.grow(value);
            }
        }
        return this;
    }
    public int getHeight(){
        int leftHeight = 0;
        int rightHeight = 0;
        if(left != null){
            leftHeight = left.getHeight();
        }
        if(right != null){
            rightHeight = right.getHeight();
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int getRoot(){
        return value;
    }
    private AVLTree deleteNode(AVLTree root, int x) {
        if (root == null)
            return null;

        if (x < root.value)
            root.left = deleteNode(root.left, x);
        else if (x > root.value)
            root.right = deleteNode(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children, get the inorder successor
            root.value = findMin(root.right);
            root.right = deleteNode(root.right, root.value);
        }

        root.rebalance();
        root.height = 1 + Math.max(root.left.height, root.right.height);
        return root;
    }
    private int findMin(AVLTree node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public AVLTree getLeft(){
        return left;
    }
    public AVLTree getRight(){
        return right;
    }
    public boolean add(int value){
        int oldHeight = getHeight();
        grow(value);
        return getHeight() > oldHeight;
    }
    public void print(){
        if(left != null){
            left.print();
        }
        System.out.println(value);
        if(right != null){
            right.print();
        }
    }
    public String ToString(){
        String result = "";
        if(left != null){
            result += left.ToString();
        }
        result += value + " ";
        if(right != null){
            result += right.ToString();
        }
        return result;
    }
    public void rebalance(){
        int leftHeight = 0;
        int rightHeight = 0;
        if(left != null){
            leftHeight = left.getHeight();
        }
        if(right != null){
            rightHeight = right.getHeight();
        }
        if(leftHeight > rightHeight + 1){
            if(left.left.getHeight() > left.right.getHeight()){
                // left left
                AVLTree newRoot = new AVLTree(left.value, left.left, new AVLTree(value, left.right, right));
                value = left.value;
                left = left.left;
                right = new AVLTree(value, left.right, right);
            }else{
                // left right
                AVLTree newRoot = new AVLTree(left.right.value, new AVLTree(left.value, left.left, left.right.left), new AVLTree(value, left.right.right, right));
                value = left.right.value;
                left = new AVLTree(left.value, left.left, left.right.left);
                right = new AVLTree(value, left.right.right, right);
            }
        }else if(rightHeight > leftHeight + 1){
            if(right.right.getHeight() > right.left.getHeight()){
                // right right
                AVLTree newRoot = new AVLTree(right.value, new AVLTree(value, left, right.left), right.right);
                value = right.value;
                left = new AVLTree(value, left, right.left);
                right = right.right;
            }else{
                // right left
                AVLTree newRoot = new AVLTree(right.left.value, new AVLTree(value, left, right.left.left), new AVLTree(right.value, right.left.right, right.right));
                value = right.left.value;
                left = new AVLTree(value, left, right.left.left);
                right = new AVLTree(right.value, right.left.right, right.right);
            }
        }
    }
    public void rotateLeft(){
        AVLTree newRoot = new AVLTree(value, left.right, right);
        value = left.value;
        left = left.left;
        right = newRoot;
    }
    public void rotateRight(){
        AVLTree newRoot = new AVLTree(value, left, right.left);
        value = right.value;
        right = right.right;
        left = newRoot;
    }
    public void printTreeInOrder() {
        printInOrder(this);
    }

    private void printInOrder(AVLTree node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(value);
    }

}
