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
}