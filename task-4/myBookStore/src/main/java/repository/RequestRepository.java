package main.java.repository;

import main.java.model.Request;

import java.util.List;

public interface RequestRepository {

    /**
     * вернуть список запросов
     *
     * @return
     */
    List<Request> getRequest();

}
