package com.example.library_management_system;
public class Node {
    Book book;
    Node left;
    Node right;

    public Node(Book book) {
        this.book = book;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "book=" + book +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
