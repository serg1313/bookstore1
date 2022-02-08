package main.java;


import com.sun.org.apache.xpath.internal.operations.Or;
import main.java.model.Book;
import main.java.model.Order;
import main.java.model.OrderStatus;
import main.java.model.Request;
import main.java.repository.*;
import main.java.service.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository, bookRepository, customerRepository);
        RequestRepository requestRepository = new RequestRepositoryImpl();
        RequestService requestService = new RequestServiceImpl(requestRepository, bookRepository);
        BookService bookService = new BookServiceImpl(bookRepository, requestService);
//
//        //списать книгу со склада
//        bookService.writeOffBook(8);
//        for (Book book : bookRepository.getBooks()) {
//            System.out.println(book.getId() + " " + book.getNameBook());
//        }
//        System.out.println();
//
//        //создать заказ
//        orderService.createOrder(LocalDate.of(2022, 2, 2), 8, new long[]{6, 8, 7, 11});
//        orderService.createOrder(LocalDate.of(2022, 2, 2), 4, new long[]{6, 8, 7, 11});
//        orderService.changeOrder(6, OrderStatus.CANCELLED);
//        for (Order order : orderRepository.getOrders()) {
//            System.out.println(order.getId() + " " + order.getOrderStatus() + " " + Arrays.toString(order.getBookId()));
//        }
//        System.out.println();
//
//        //отменить заказ
//        orderService.cancelOrder(8);
//        for (Order order : orderRepository.getOrders()) {
//            System.out.println(order.getId() + " " + order.toString());
//        }
//        System.out.println();
//        //изменить заказ
//        orderService.changeOrder(0, OrderStatus.COMPLETED);
//        for (Order order : orderRepository.getOrders()) {
//            System.out.println(order.getId() + " " + order.getOrderStatus() + " " + Arrays.toString(order.getBookId()));
//        }
//        System.out.println();
//
//        //добавить книгу на склад
//        bookService.addBook(8);
//        for (Book book : bookRepository.getBooks()) {
//            System.out.println(book);
//        }
//        System.out.println();
//
//        //оставить запрос на книгу
//        requestService.createRequestBookById(12);
//        requestService.createRequestBookById(12);
//        requestService.createRequestBookById(12);
//        requestService.createRequestBookById(12);
//        requestService.createRequestBookById(1);
//        requestService.createRequestBookById(2);
//        requestService.createRequestBookById(3);
//        requestService.createRequestBookById(4);
//        requestService.createRequestBookById(5);
//        for (Request request : requestRepository.getRequest()) {
//            System.out.println(request.getId() + " " + request);
//        }
//        System.out.println();
//        requestService.canceledRequestByBookId(5);
//        for (Request request : requestRepository.getRequest()) {
//            System.out.println(request.getId() + " " + request);
//        }
//        System.out.println();
//
//        //Сортировка книг по названию
//        bookService.sortingBookByName(bookRepository.getBooks());
//        System.out.println();
//
//        //Сортировка книг по цене
//        bookService.sortingBookByPrice(bookRepository.getBooks());
//        System.out.println();
//
//        //сортировка книг по дате издания
//        bookService.sortingBookByYearOfPublic(bookRepository.getBooks());
//        System.out.println();
//
//        //сортировка книг по наличию/отсутствию на складе
//        bookService.sortBooksByStockAvailability(true);
//        System.out.println();
//        bookService.sortBooksByStockAvailability(false);
//        System.out.println();
//
//        //создание заказов
//        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
//        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
//        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
//        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
//        orderService.createOrder(LocalDate.now(), 5, new long[]{3, 6, 8, 15});
//        for (Order order : orderRepository.getOrders()) {
//            System.out.println(order);
//        }
//        System.out.println();
//
//        // сортировка заказов по дате исполнения
//        orderService.sortOrderByDate(orderRepository.getOrders());
//        System.out.println();
//
//        //сортировка заказов по статусу
//        orderService.sortOrderByStatus(orderRepository.getOrders());
//        for (Order order : orderRepository.getOrders()) {
//            System.out.println(order);
//        }
//        System.out.println();
//
//        //получить список заказов по указанному статусу
//        for (Order order: orderService.getOrderByStatus(OrderStatus.COMPLETED)) {
//            System.out.println(order);
//        }
//        System.out.println();
//
//        //получить количество запросов на книгу по ее id
//        requestService.sortRequestBookById(5);
//
//        // получить количество запросов на книгу по ее названию
//        int i = requestService.sortRequestBookByName("Мастер и Маргарита");
//        System.out.println(i);
//        System.out.println();

//        orderService.getInfoOrder(6);
        for (Order order:orderRepository.getOrders()){
            System.out.println(order);
        }

        orderService.changeOrder(6, OrderStatus.COMPLETED);
        System.out.println();
        for(Order order:orderService.getOrderListByPeriod(LocalDate.of(2021,2,3),LocalDate.now())){
            System.out.println(order);
        }



    }
    // write your code here

}
