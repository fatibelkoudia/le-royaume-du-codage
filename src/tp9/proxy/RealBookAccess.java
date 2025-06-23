package tp9.proxy;

import tp9.Book;

// Classe réelle
public class RealBookAccess implements BookAccess {
    private Book book;
    // Logic for reading the full book

    public RealBookAccess(Book book) {
        this.book = book;
    }

    @Override
    public String read() {
        return "Reading: " + book.getTitle();
    }

    @Override
    public String preview() {
        return book.preview();
    }

}