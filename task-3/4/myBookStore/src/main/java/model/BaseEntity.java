package main.java.model;

import org.springframework.stereotype.Component;


public abstract class BaseEntity {
    private long id;

    public BaseEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}

