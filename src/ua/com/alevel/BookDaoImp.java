package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao{

    private final List<Book> books = new ArrayList<>();

    @Override
    public void create(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book) {
        boolean exist = false;
        for (Book currentBook : books) {
            if (currentBook.getId() == book.getId()) {
                currentBook.setName(book.getName());
                currentBook.setAuthor(book.getAuthor());
                currentBook.setLanguage(book.getLanguage());
                currentBook.setYear(book.getYear());
                exist = true;
            }
        }
        if (!exist) {
            throw new RuntimeException("Книга не найдена");
        }
    }

    @Override
    public void delete(int id) {
        boolean exist = false;
        for (Book currentBook : books) {
            if (currentBook.getId() == id) {
                books.remove(currentBook);
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new RuntimeException("Книга не найдена");
        }
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getName().equals(name)) {
                tempBooks.add(currentBook);
            }
        }
        return tempBooks;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getAuthor().equals(author)) {
                tempBooks.add(currentBook);
            }
        }
        return tempBooks;
    }

    @Override
    public List<Book> findByYear(int year) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getYear() == year) {
                tempBooks.add(currentBook);
            }
        }
        return tempBooks;
    }

    @Override
    public List<Book> findByLanguage(String language) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getLanguage().equals(language)) {
                tempBooks.add(currentBook);
            }
        }
        return tempBooks;
    }

    @Override
    public List<Book> findByLanguageAndAuthor(String language, String author) {
        List<Book> tempBooks = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getLanguage().equals(language) && currentBook.getAuthor().equals(author)) {
                tempBooks.add(currentBook);
            }
        }
        return tempBooks;
    }

    @Override
    public Book findById(int id) {
        for (Book currentBook : books) {
            if (currentBook.getId() == id) {
                return currentBook;
            }
        }
        throw new RuntimeException("Книга не найдена");
    }
}
