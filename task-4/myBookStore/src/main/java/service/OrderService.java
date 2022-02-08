package service;




import model.Book;
import model.Order;
import model.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    /**
     * Создать заказ на книги
     *
     * @param localDate  дата заказа
     * @param idCustomer id покупателя
     * @param books      список книг по Id
     */
    void createOrder(LocalDate localDate, long idCustomer, long[] books);

    /**
     * переводит заказ в статус закрыт
     *
     * @param orderId
     */
    void cancelOrder(long orderId);

    /**
     * изменить статус заказа на статус который в параметре
     *
     * @param orderId
     * @param orderStatus статус на который изменить
     */
    void changeOrder(long orderId, OrderStatus orderStatus, LocalDate localDate);

    /**
     * получить общую стоимость одного заказа
     *
     * @param order по которому считается стоимость
     * @return сумму проданных книг в данном заказе
     */
    double getPriceOfSoldBooksByOrder(Order order);

    /**
     * получить сумму заказа
     *
     * @param idOrder
     * @return
     */
    double getPriceOfSoldBooksByOrderId(long idOrder);

    /**
     * сортирует заказы по дате исполнения
     *
     * @param orders
     * @return
     */
    List<Order> sortOrderByDate(List<Order> orders);

    /**
     * возвращает список заказов по указанному статусу
     *
     * @param orderStatus
     * @return
     */
    List<Order> getOrderByStatus(OrderStatus orderStatus);

    /**
     * сортировка списка заказов по статусу заказа
     *
     * @param orders
     * @return
     */
    List<Order> sortOrderByStatus(List<Order> orders);

    /**
     * сортировка списка заказов по цене
     * @param orders
     */
    void sortOrderByPrice(List<Order> orders);

    /**
     * получить список книг в конкретном заказе
     * @param idOrder
     */
    List<Book> getBookByOrder(long idOrder);

    /**
     * получить информацию из заказа о покупателе, книгах и сумме заказа
     * @param id
     */
    void getInfoOrder(long id);

    public List<Order> getOrderListByPeriod(LocalDate dateStart, LocalDate dateEnd);


}