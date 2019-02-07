package data;

import java.util.Objects;

public class Book extends Publication {
    private static final long serialVersionUID = 7907331751072277846L;//ID serializowanej klasy

    //poles
    private String author;
    private int pages;
    private String isbn;

    //setters and getters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(getTitle());
        sb.append("; ");
        sb.append(getAuthor());
        sb.append("; ");
        sb.append(getYear());
        sb.append("; ");
        sb.append(getPages());
        sb.append("; ");
        sb.append(getPublisher());
        sb.append("; ");
        sb.append(getIsbn());
        return sb.toString();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }

    public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn) {

        super(releaseDate, title, publisher); //wywołanie konstruktora z Publication.class
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);
    }

}