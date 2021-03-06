package main.java;

import main.java.model.Book;
import main.java.model.Order;
import main.java.model.OrderStatus;
import main.java.model.Request;
import main.java.repository.*;
import main.java.service.*;

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

        requestService.createRequestBookById(8);
        requestService.createRequestBookById(8);
        requestService.createRequestBookById(8);
        requestService.createRequestBookById(8);
        requestService.createRequestBookById(8);
        requestService.createRequestBookById(4);
        requestService.createRequestBookById(4);
        requestService.createRequestBookById(4);
        requestService.createRequestBookById(3);
        requestService.createRequestBookById(6);
        requestService.createRequestBookById(5);
        requestService.createRequestBookById(5);
        requestService.createRequestBookById(5);
        requestService.createRequestBookById(1);
        requestService.createRequestBookById(1);
        requestService.createRequestBookById(1);

        System.out.println("Задание 1 - Список книг");
        System.out.println("Сортировка книг по названию");
        bookService.sortingBookByName(bookRepository.getBooks());
        System.out.println();

        System.out.println("Сортировка книг по дате издания");
        bookService.sortingBookByYearOfPublic(bookRepository.getBooks());
        System.out.println();

        System.out.println("Сортировка книг по цене");
        bookService.sortingBookByPrice(bookRepository.getBooks());
        System.out.println();

        System.out.println("Сортировка книг по наличию");
        bookService.sortBooksByStockAvailability(true);
        System.out.println();

        System.out.println("Сортировка книг по отсутствию");
        bookService.sortBooksByStockAvailability(false);
        System.out.println();

        System.out.println("Задание 2 - Список заказов");
        System.out.println("заказы по дате исполнения");
        for(Order order:orderService.sortOrderByDate(orderService.getOrderByStatus(OrderStatus.COMPLETED))){
            System.out.println(order);
        }
        System.out.println();

        System.out.println("Сортировка заказов по цене");
        for(Order order :orderService.sortOrderByPrice(orderRepository.getOrders())){
            System.out.println(order + " Сумма заказа = " + orderService.getPriceOfSoldBooksByOrderId(order.getId()));
        }
        System.out.println();

        System.out.println("Сортировка заказов по статусу");
        for (Order order: orderService.sortOrderByStatus(orderRepository.getOrders())){
            System.out.println(order);
        }
        System.out.println();

        System.out.println("Задание 3 - Список запросов на книгу");
        System.out.println("сортировка по количеству запросов");
        requestService.sortRequestByCount();
        System.out.println();
        System.out.println("сортировать запросы по имени книги");
        requestService.sortRequestBookByName();
        System.out.println();

        System.out.println("Задание 4 - Список выполненных заказов за период времени");
        System.out.println("Сортировка по дате");
        orderService.changeOrder(2, OrderStatus.COMPLETED, LocalDate.of(2021,10,10));
        orderService.changeOrder(3, OrderStatus.COMPLETED, LocalDate.of(2021,11,10));
        orderService.changeOrder(4, OrderStatus.COMPLETED, LocalDate.of(2021,9,10));
        for (Order order: orderService.getOrderListByPeriod(LocalDate.of(2021,1,1),LocalDate.now())){
            System.out.println(order);
        }
        System.out.println();

        System.out.println("Сортировка по цене");
        for (Order order: orderService.getOrderListCompletedByPrice(LocalDate.of(2021,2,2), LocalDate.now())){
            System.out.println(order);
        }
        System.out.println();

        System.out.println("Задание 5 - Сумма заработанных средств за период времени");
        System.out.println(orderService.getSummEarnedMoneyByPeriod(LocalDate.of(2021,5,10),LocalDate.of(2021,12,30)));
        System.out.println();

        System.out.println("Задание 6 - Количество выполненных заказов за период времени");
        System.out.println(orderService.getCountComletedOrdersByPeriod(LocalDate.of(2021,1,1),LocalDate.now()));
        System.out.println();

        System.out.println("Задание 7 - Список «залежавшихся» книг не проданы больше чем 6 мес.");
        System.out.println("Сортировка по дате поступления");
        for (Book book: bookService.sortByDateDeliveryOfStaleBooksNotSold(bookRepository.getBooks())){
            System.out.println(book);
        }
        System.out.println();

        System.out.println("Сортировка по цене");
        for (Book book: bookService.sortByPriceListOfStaleBooksNotSold(bookRepository.getBooks())){
            System.out.println(book);
        }
        System.out.println();

        System.out.println("Задание 8 - Посмотреть детали заказа (какие-либо данные заказчика + книги)");
        orderService.getInfoOrder(6);
        System.out.println();

        System.out.println("Задание 8 - Посмотреть описание книги");
        bookService.getDescriptionBook(6);




    }

}
