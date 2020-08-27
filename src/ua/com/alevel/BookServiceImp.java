package ua.com.alevel;

import java.util.List;

public class BookServiceImp implements BookService{

    private final BookDao bookDao = new BookDaoImp();

    @Override
    public void create(Book book) {
        int size = bookDao.findAll().size();
        book.setId(++size);
        bookDao.create(book);
    }

    @Override
    public void update(Book book) {
        if (book.getId() <= 0) {
            throw new RuntimeException("Не верный id");
        }
        bookDao.update(book);
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new RuntimeException("Не верный id");
        }
        bookDao.delete(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByName(String name) {
        return bookDao.findByName(name);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookDao.findByAuthor(author);
    }

    @Override
    public List<Book> findByYear(int year) {
        return bookDao.findByYear(year);
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return bookDao.findByLanguage(language);
    }

    @Override
    public List<Book> findByLanguageAndAuthor(String language, String author) {
        return bookDao.findByLanguageAndAuthor(language, author);
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }
}
