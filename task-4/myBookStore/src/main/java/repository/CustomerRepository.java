package repository;


import model.Customer;

import java.util.List;

public interface CustomerRepository {
    /**
     * возвращает список покупателей
     *
     * @return
     */
    List<Customer> getCustomers();

    Customer getCustomerById(long Id);
}