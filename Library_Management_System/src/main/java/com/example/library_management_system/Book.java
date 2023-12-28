package com.example.library_management_system;
public class Book implements Comparable<Book>{
    private String title;
    private String author;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    private String ISBN;
    private int publicationYear;

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    @Override
    public int compareTo(Book otherBook) {
        return this.ISBN.compareTo(otherBook.getISBN());
    }

    @Override

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
