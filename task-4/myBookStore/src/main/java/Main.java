import model.Book;
import model.Order;
import model.OrderStatus;
import model.Request;
import repository.*;
import service.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository, bookRepository, customerRepository);
        RequestRepository requestRepository = new RequestRepositoryImpl();
        RequestService requestService = new RequestServiceImpl(requestRepository, bookRepository);
        BookService bookService = new BookServiceImpl(bookRepository, requestService);

        //списать книгу со склада
        bookService.writeOffBook(8);
        for (Book book : bookRepository.getBooks()) {
            System.out.println(book.getId() + " " + book.getNameBook());
        }
        System.out.println();

        //создать заказ
        orderService.createOrder(LocalDate.of(2022, 2, 2), 8, new long[]{6, 8, 7, 11});
        orderService.createOrder(LocalDate.of(2022, 2, 2), 4, new long[]{6, 8, 7, 11});
        orderService.changeOrder(6, OrderStatus.CANCELLED, LocalDate.of(2022, 01, 15));
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order.getId() + " " + order.getOrderStatus() + " " + Arrays.toString(order.getBookId()));
        }
        System.out.println();

        //отменить заказ
        orderService.cancelOrder(8);
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order.getId() + " " + order.toString());
        }
        System.out.println();
        //изменить заказ
        orderService.changeOrder(0, OrderStatus.COMPLETED, LocalDate.of(2021, 2, 19));
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order.getId() + " " + order.getOrderStatus() + " " + Arrays.toString(order.getBookId()));
        }
        System.out.println();

        //добавить книгу на склад
        bookService.addBook(8);
        for (Book book : bookRepository.getBooks()) {
            System.out.println(book);
        }
        System.out.println();

        //оставить запрос на книгу
        requestService.createRequestBookById(12);
        requestService.createRequestBookById(12);
        requestService.createRequestBookById(12);
        requestService.createRequestBookById(12);
        requestService.createRequestBookById(1);
        requestService.createRequestBookById(2);
        requestService.createRequestBookById(3);
        requestService.createRequestBookById(4);
        requestService.createRequestBookById(5);
        for (Request request : requestRepository.getRequest()) {
            System.out.println(request.getId() + " " + request);
        }
        System.out.println();
        requestService.canceledRequestByBookId(5);
        for (Request request : requestRepository.getRequest()) {
            System.out.println(request.getId() + " " + request);
        }
        System.out.println();

        //Сортировка книг по названию
        bookService.sortingBookByName(bookRepository.getBooks());
        System.out.println();

        //Сортировка книг по цене
        bookService.sortingBookByPrice(bookRepository.getBooks());
        System.out.println();

        //сортировка книг по дате издания
        bookService.sortingBookByYearOfPublic(bookRepository.getBooks());
        System.out.println();

        //сортировка книг по наличию/отсутствию на складе
        bookService.sortBooksByStockAvailability(true);
        System.out.println();
        bookService.sortBooksByStockAvailability(false);
        System.out.println();

        //создание заказов
        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});

        for (Order order : orderRepository.getOrders()) {
            System.out.println(order);
        }

        System.out.println(bookService.getBookById(6));
        for (Request request : requestRepository.getRequest()) {
            System.out.println(request);
        }

        System.out.println(requestService.getRequestByBookId(5));
        System.out.println();

        for (Request request : requestRepository.getRequest()) {
            System.out.println(request);
        }
        System.out.println();

        System.out.println(requestService.sortRequestBookById(12));
        System.out.println(requestService.sortRequestBookByName("Железная вдова"));

        orderService.cancelOrder(5);
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order + " " + order.getOrderStatus());
        }

        orderService.getPriceOfSoldBooksByOrderId(1);
        orderService.changeOrder(4, OrderStatus.COMPLETED, LocalDate.of(2021, 5, 12));
        System.out.println(orderRepository.getOrderById(5));

        for (Order order : orderRepository.getOrders()) {
            System.out.println(order + " " + order.getOrderStatus());
        }
        System.out.println();

        orderService.sortOrderByDate(orderService.getOrderByStatus(OrderStatus.COMPLETED));
        System.out.println();

        for (Order order : orderRepository.getOrders()) {
            System.out.println(order + " " + order.getCompleteDate());

        }
        for (Request request : requestRepository.getRequest()) {
            System.out.println(request);
        }
        System.out.println("");

        requestService.sortRequestBookById(12);
        System.out.println();

        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.createOrder(LocalDate.now(), 5, new long[]{5, 8, 9, 11, 15, 3, 4});
        orderService.changeOrder(4, OrderStatus.COMPLETED, LocalDate.of(2021, 6, 26));
        orderService.changeOrder(5, OrderStatus.CANCELLED, LocalDate.of(2021, 7, 25));
        orderService.changeOrder(6, OrderStatus.COMPLETED, LocalDate.of(2021, 8, 24));
        orderService.changeOrder(7, OrderStatus.CANCELLED, LocalDate.of(2021, 9, 23));
        orderService.changeOrder(8, OrderStatus.COMPLETED, LocalDate.of(2021, 10, 22));
        orderService.changeOrder(9, OrderStatus.CANCELLED, LocalDate.of(2021, 11, 21));

        orderService.sortOrderByStatus(orderRepository.getOrders());
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order);
        }
        System.out.println(orderRepository.getBookByOrder(5));
//
        System.out.println();
        orderService.getInfoOrder(5);
        System.out.println();
//
//        orderService.getPriceOfSoldBooksByOrder(new Order(LocalDate.now(),3, new long[]{3,5,9,8}));
        orderService.changeOrder(1, OrderStatus.COMPLETED, LocalDate.of(2021, 10, 10));
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order);
        }
        System.out.println();

        //сортировка выполненных заказов за период времени
        for (Order order : orderService.getOrderListByPeriod(LocalDate.of(2021, 1, 11), LocalDate.of(2022, 1, 10))) {
            System.out.println(order);
        }
        System.out.println();

        //сортировка выполненных заказов за период времени по сумме заказа
        for (Order order : orderService.getOrderListCompletedByPrice(LocalDate.of(2021, 1, 11), LocalDate.of(2022, 1, 10))) {
            System.out.println(order + " сумма заказа = " + orderService.getPriceOfSoldBooksByOrderId(order.getId()));
        }
        System.out.println();

        // сортировка книг по наименованию
        bookService.sortingBookByName(bookRepository.getBooks());
        System.out.println();

        //получить общее количество книг со статусом в наличии
        System.out.println(bookService.getCountBookByRepository());

        // добавить новую книгу на склад
        bookRepository.addNewBookInRepository(new Book("Темная башня", "Стивен Кинг", 2012, 1013, true, LocalDate.of(2022, 2, 8)));
        System.out.println();

        //получить общее количество книг со статусом в наличии
        System.out.println(bookService.getCountBookByRepository());
        System.out.println();

       // отсортировать книги по id
        bookService.sortingBookById(bookRepository.getBooks());


    }
    // write your code here

}
