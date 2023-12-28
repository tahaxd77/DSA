package com.example.library_management_system;

import java.util.ArrayList;
import java.util.*;

public class Library {
    Node root;
    Node Book;
    Node Author;
    Node Title;

    public Library() {
        root = null;
    }

    public Node addBook(Node root, Book book) {
        Node newNode = new Node(book);
        if (root == null) {
            root = newNode;
        } else if (book.getISBN().compareTo(root.book.getISBN()) < 0) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                addBook(root.left, book);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                addBook(root.right, book);
            }
        }
        return root;
    }

//    public void searchBook(Node root, String isbn) {
//        if (root == null) {
//            return;
//        }
//        if (root.book.getISBN().equals(isbn)) {
//            System.out.println(root.book);
//        }
//        searchBook(root.left, isbn);
//        searchBook(root.right, isbn);
//    }
//    public Book searchBook(Node root, String ISBN){
//        if(root == null){
//            return null;
//        }
//        Node current = root;
//        while(current != null){
//            if(current.book.getISBN().equals(ISBN)){
//                return current.book;
//            }
//            else if(ISBN.compareTo(current.book.getISBN())<0){
//                current = current.left;
//            }
//            else{
//                current = current.right;
//            }
//        }
//        return null;
//
//    }

    public Node searchBook(Node root, String ISBN) throws NullPointerException{
        if (root == null || root.book.getISBN().equals(ISBN)) {

            return root;
        }

        if (ISBN.compareTo(root.book.getISBN()) < 0) {
            return searchBook(root.left, ISBN);
        } else {
            return searchBook(root.right, ISBN);
        }
    }

    // function to display the books in the library
    public Book displayBooks(Node root) {
        if (root == null) {
            return null;
        }
        displayBooks(root.left);
        displayBooks(root.right);
        return root.book;
    }
    public Book displayBooksInOrder(Node root){

    }
    public Node deleteBook(Node root,String ISBN){
        if(root == null || root.book.getISBN().equals(ISBN)){
            return null;
        }
        if(ISBN.compareTo(root.book.getISBN())<0){
            root.left = deleteBook(root.left, ISBN);
        }
        else if(ISBN.compareTo(root.book.getISBN())>0){
            root.right = deleteBook(root.right, ISBN);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            root.book = getSuccessor(root.right).book;
            root.right = deleteBook(root.right, root.book.getISBN());
        }
        return root;
    }
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

    public static void main(String[] args) {
        Library library = new Library();
        com.example.library_management_system.Book book1 = new com.example.library_management_system.Book("The Alchemist", "Paulo Coelho", "22", 1988);
        library.root = library.addBook(library.root, book1);
    }

}
