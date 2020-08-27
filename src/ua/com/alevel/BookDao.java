package ua.com.alevel;

import java.util.List;

public interface BookDao {

    void create(Book book);

    void update(Book book);

    void delete(int id);

    List<Book> findAll();

    List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByYear(int year);

    List<Book> findByLanguage(String language);

    List<Book> findByLanguageAndAuthor(String language, String author);

    Book findById(int id);
}
