package main.java.repository;

import main.java.model.Book;
import main.java.model.Request;
import main.java.model.RequestStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RequestRepositoryImpl implements RequestRepository {
    private List<Request> requests = new ArrayList<>();

    public RequestRepositoryImpl() {
        initRequest();
    }

    private void initRequest() {
        requests.add(new Request(new Book
                ("Иван царевич", "народ", 0, 0, true, LocalDate.of(2022, 2, 1)), RequestStatus.NEW));
    }

    /**
     * вернуть список запросов
     *
     * @return
     */
    @Override
    public List<Request> getRequest() {
        return requests;
    }

}






