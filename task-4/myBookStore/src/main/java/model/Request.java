package main.java.model;

public class Request extends BaseEntity {
    private static long id = 0;
    private Book book;
    private main.java.model.RequestStatus requestStatus;

    public Request(Book book, main.java.model.RequestStatus requestStatus) {
        super(id++);
        this.book = book;
        this.requestStatus = requestStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public main.java.model.RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public static long getIdRequest() {
        return id;
    }

    @Override
    public String toString() {
        return "Request " + getId() + "{" +
                "book=" + book +
                ", requestStatus=" + requestStatus +
                '}';
    }
}


