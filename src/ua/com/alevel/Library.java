package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Library {

    BookController controller = new BookController();

    public void run() {


        String strLine = "";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Пожалуйста, выберите метод который вы хотите использовать:");
            System.out.println("0: Завершить програму.");
            System.out.println("1: Добавить книгу в библиотеку.");
            System.out.println("2: Обновить существующую книгу.");
            System.out.println("3: Удалить книгу из библиотеки.");
            System.out.println("4: Показать все книги в библиотеке.");
            System.out.println("5: Найти книгу по имени.");
            System.out.println("6: Найти книги по автору.");
            System.out.println("7: Найти книги по языку.");
            System.out.println("8: Найти книги по году.");
            System.out.println("9: Найти книги по языку и автору.");
            System.out.println("10: Найти книгу по id.");

            while ((line = reader.readLine()) != null) {

                if (line.equals("0")) {
                    System.exit(1);
                }
                if (line.equals("1")) {
                    createBook(line, reader);
                }
                if (line.equals("2")) {
                    updateBook(line, reader);
                }
                if (line.equals("3")) {
                    deleteBook(line, reader);
                }
                if (line.equals("4")) {
                    findAll();
                }
                if (line.equals("5")) {
                    findByName(line, reader);
                }
                if (line.equals("6")) {
                    findByAuthor(line, reader);
                }
                if (line.equals("7")) {
                    findByLanguage(line, reader);
                }
                if (line.equals("8")) {
                    findByYear(line, reader);
                }

                System.out.println("Пожалуйста, выберите метод который вы хотите использовать:");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createBook(String line, BufferedReader reader) {
        try {
            System.out.println("Введите название книги: ");
            line = reader.readLine();
            String name = line;
            System.out.println("Введите имя автора: ");
            String author = reader.readLine();
            System.out.println("Введите год выпуска книги: ");
            int year = Integer.parseInt(reader.readLine());
            System.out.println("Введите язык книги: ");
            String language = reader.readLine();
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setYear(year);
            book.setLanguage(language);
            controller.create(book);
            controller.findAll().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBook(String line, BufferedReader reader) {
        try {
            System.out.println("Введите id: ");
            line = reader.readLine();
            int id = Integer.parseInt(line);
            System.out.println("Введите название книги: ");
            line = reader.readLine();
            String name = line;
            System.out.println("Введите имя автора: ");
            String author = reader.readLine();
            System.out.println("Введите год выпуска книги: ");
            int year = Integer.parseInt(reader.readLine());
            System.out.println("Введите язык книги: ");
            String language = reader.readLine();
            Book book = controller.findById(id);
            book.setName(name);
            book.setAuthor(author);
            book.setYear(year);
            book.setLanguage(language);
            controller.update(book);
            controller.findAll().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBook(String line, BufferedReader reader) {
        try {
            System.out.println("Введите id книги: ");
            line = reader.readLine();
            int id = Integer.parseInt(line);
            controller.delete(id);
            controller.findAll().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAll() {
        List<Book> books = controller.findAll();
        books.forEach(System.out::println);
    }

    private void findByName(String line, BufferedReader reader) {
        try {
            System.out.println("Введите название книги: ");
            line = reader.readLine();
            List<Book> books = controller.findByName(line);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByAuthor(String line, BufferedReader reader) {
        try {
            System.out.println("Введите автора книги: ");
            line = reader.readLine();
            List<Book> books = controller.findByAuthor(line);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByLanguage(String line, BufferedReader reader) {
        try {
            System.out.println("Введите язык книги: ");
            line = reader.readLine();
            List<Book> books = controller.findByLanguage(line);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByYear(String line, BufferedReader reader) {
        try {
            System.out.println("Введите год выпуска книги: ");
            line = reader.readLine();
            int year = Integer.parseInt(line);
            List<Book> books = controller.findByYear(year);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByLanguageAndAuthor(String line, BufferedReader reader) {
        try {
            System.out.println("Введите язык книги: ");
            line = reader.readLine();
            System.out.println("Введите автора книги: ");
            String author = reader.readLine();
            List<Book> books = controller.findByLanguageAndAuthor(line, author);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findById(String line, BufferedReader reader) {
        try {
            System.out.println("Введите id книги: ");
            line = reader.readLine();
            int id = Integer.parseInt(line);
            Book book = controller.findById(id);
            System.out.println(book.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
