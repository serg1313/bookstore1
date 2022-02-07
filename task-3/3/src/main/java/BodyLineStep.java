package main.java;

public class BodyLineStep implements ILineStep {

    public IProductPart buildProductPart() {
        return new BodyPart();
    }
}
