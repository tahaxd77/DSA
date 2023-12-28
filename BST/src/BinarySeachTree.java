public class BinarySeachTree {
    BinarySeachTree() {
        root = null;
    }

    Node root;

    public Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public int height(Node root, int data){
        if(root == null){
            return -1;
        }
        if (root.data == data){
            return 0;
        }
        if (data > root.data){
            return 1 + height(root.right, data);
        }
        else{
            return 1 + height(root.left, data);
        }
    }
    public int height(Node root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public boolean bstCheck(Node root){
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.data > root.data){
            return false;
        }
        if(root.right != null && root.right.data < root.data){
            return false;
        }
        return bstCheck(root.left) && bstCheck(root.right);
    }
    public boolean sameLevel(Node root, int data1, int data2){
        if(root == null){
            return false;
        }
        if(height(root, data1) == height(root, data2)){
            return true;
        }
        return false;
    }
    public int numberOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
    }
    public int inOrderSuccessor(Node root, int data){
        if(root == null){
            return -1;
        }
        Node current = root;
        while(current != null){
            if(current.data == data){
                if(current.right != null){
                    Node temp = current.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    return temp.data;
                }
                else{
                    return -1;
                }
            }
            else if(data > current.data){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        return data;
    }
    public Node deleteNode(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = deleteNode(root.left, data);
        }
        else if(data > root.data){
            root.right = deleteNode(root.right, data);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            Node predecessor = getPredecessor(root.right);
            root.data = predecessor.data;
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }
    //delete node method iteratively
    public Node delete(Node root, int data){
        if(root == null){
            return null;
        }
        Node current = root;
        Node parent = null;
        while(current != null){
            if(current.data == data){
                break;
            }
            else if(data > current.data){
                parent = current;
                current = current.right;
            }
            else{
                parent = current;
                current = current.left;
            }
        }
        if(current == null){
            return root;
        }
        //Case 1: Delete a Leaf Node in BST.
        if(current.left == null && current.right == null){
            if(current == root){
                return null;
            }
            if(parent.left == current){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
        //Case 2: Delete a Node with One Child in BST.
        else if(current.left == null){
            if(current == root){
                return current.right;
            }
            if(parent.left == current){
                parent.left = current.right;
            }
            else{
                parent.right = current.right;
            }
        }
        else if(current.right == null){
            if(current == root){
                return current.left;
            }
            if(parent.left == current){
                parent.left = current.left;
            }
            else{
                parent.right = current.left;
            }
        }
        //Case 3: Delete a Node with Two Children in BST.
        else if (current != null && current.left != null && current.right != null) {
            Node predecessor = getPredecessor(current.left);
            current.data = predecessor.data;
            current.right = delete(current.right, predecessor.data);
        }
        return root;
    }
    //Helper method for delete method
    public Node getSuccessor(Node root){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    public Node getPredecessor(Node root){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }
     public Node inOrderSuccessor(Node root, Node node){
        if(root == null){
            return null;
        }
        if(node.right != null){
            return getSuccessor(node.right);
        }
        Node successor = null;
        Node current = root;
        while(current != null){
            if(node.data < current.data){
                successor = current;
                current = current.left;
            }
            else if(node.data > current.data){
                current = current.right;
            }
            else{
                break;
            }
        }
        return successor;
    }

    public void search(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found");
                return;
            } else if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public void FindMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Min: " + current.data);
    }

    public void FindMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Max: " + current.data);
    }

    public void PostOrder(Node root) {
        if (root == null) {
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void PreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.println(root.data + " ");
        Inorder(root.right);
    }

    public Boolean HasSibling(Node root, int data) {
        if (root == null || root.data == data) {
            return false;
        }
        Node parent = findParent(root, data);
        if (parent == null) {
            System.out.println("Batman");
        }
        if (parent.left != null && parent.right != null) {
            if (parent.left.data == data) {
                System.out.println("Sibling: " + parent.right.data);
                return true;
            } else if (parent.right.data == data) {
                System.out.println("Sibling: " + parent.left.data);
                return true;
            }
        }
        return false;
    }

    public Node findParent(Node root, int value) {
        if (root == null || root.data == value) {
            return null;
        }
        if ((root.left != null && root.left.data == value) || (root.right != null && root.right.data == value)) {
            return root;
        }
        Node left = findParent(root.left, value);
        if (left != null) {
            return left;
        }
        Node right = findParent(root.right, value);
        return right;
    }

    public boolean hasLeft(Node root, int data) {
        if (root == null) {
            return false;
        }
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                if (current.left != null) {
                    return true;
                } else {
                    return false;
                }
            } else if (data > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return false;
    }
    public boolean hasRight(Node root, int data) {
        if (root == null) {
            return false;
        }
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                if (current.right != null) {
                    return true;
                } else {
                    return false;
                }
            } else if (data > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return false;
    }
    public Node LCA(Node root, int data1, int data2){
       if(root == null){
           return null;
       }
       if(data1 == root.data || data2 == root.data){
           return root;
       }
       Node leftSubtree = LCA(root.left, data1, data2);
       Node rightSubtree = LCA(root.right, data1, data2);
       if(leftSubtree == null){
           return rightSubtree;
       }
       if(rightSubtree == null){
           return leftSubtree;
       }
         return root;
    }
//    int countLowerAncestors(Node root, int nodeKey) {
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.data >= nodeKey) {
//            return countLowerAncestors(root.left, nodeKey);
//        } else {
//            // 1 is added for the current root and counts ancestors in the left subtree
//            return 1 + countLowerAncestors(root.left, nodeKey) + countLowerAncestors(root.right, nodeKey);
//        }
//    }
}