package main;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;

public class Rose extends Flower {

    public Rose(Color color, int price) {
        super("Роза", color, price);
    }

    @Override
    public String toString() {
        return "Rose{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
