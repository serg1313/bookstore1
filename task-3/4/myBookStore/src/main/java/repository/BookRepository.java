package main.java.repository;







import main.java.model.Book;

import java.util.List;

public interface BookRepository {
    /**
     * возвращает список книг на складе
     *
     * @return
     */
    List<Book> getBooks();

    /**
     * поиск книги по ее id
     *
     * @param id
     * @return
     */
    Book getBookById(long id);

    /**
     * добавляет книгу на склад
     *
     * @param book
     */
    void addBook(Book book);

    public void addNewBookInRepository(Book book);
}
