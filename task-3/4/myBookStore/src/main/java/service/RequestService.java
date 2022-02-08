package main.java.service;


import main.java.model.Request;


public interface RequestService {
    /**
     * создатьзапрос на книгу по автору и названию книги
     *
     * @param nameBook
     * @param authorBook
     */
    void createRequestBook(String nameBook, String authorBook);

    /**
     * создать запрос на книгу по ее id
     *
     * @param iD
     */
    void createRequestBookById(long iD);

    /**
     * вернуть запрос по id книги
     *
     * @param id
     * @return
     */
    Request getRequestByBookId(long id);

    /**
     * перевести статус запроса на статус закрыт по id книги
     *
     * @param id
     */
    void canceledRequestByBookId(long id);

    /**
     * вернуть количество запросов на книгу по ее id
     *
     * @param idBook
     * @return
     */
    int sortRequestBookById(long idBook);

    /**
     * вернуть количество запросов на книгу по ее названию
     * @param nameBook
     * @return
     */
    int sortRequestBookByName(String nameBook);
}
