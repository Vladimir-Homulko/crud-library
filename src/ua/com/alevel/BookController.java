package ua.com.alevel;

import java.util.List;

public class BookController {

    private final BookService bookService = new BookServiceImp();

    void create(Book book) {
        bookService.create(book);
    }

    void update(Book book) {
        bookService.update(book);
    }

    void delete(int id) {
        bookService.delete(id);
    }

    List<Book> findAll() {
        return bookService.findAll();
    }

    List<Book> findByName(String name) {
        return bookService.findByName(name);
    }

    List<Book> findByAuthor(String author) {
        return bookService.findByAuthor(author);
    }

    List<Book> findByYear(int year) {
        return bookService.findByYear(year);
    }

    List<Book> findByLanguage(String language) {
        return bookService.findByLanguage(language);
    }

    List<Book> findByLanguageAndAuthor(String language, String author) {
        return bookService.findByLanguageAndAuthor(language, author);
    }

    Book findById(int id) {
        return bookService.findById(id);
    }
}
