package ua.com.alevel;

public class Book {

    private int id;
    private String name;
    private String author;
    private int year;
    private String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new RuntimeException("Введите корректный id");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else throw new RuntimeException("Введите корректное имя книги");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isBlank()) {
            this.author = author;
        } else throw new RuntimeException("Введите корректно имя автора");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 0) {
            throw new RuntimeException("Не корректно введен год");
        }
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (language != null && !language.isBlank()) {
            this.language = language;
        }
        else throw new RuntimeException("Не существующий язык");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", language='" + language + '\'' +
                '}';
    }
}
