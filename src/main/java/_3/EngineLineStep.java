package _3;

public class EngineLineStep implements ILineStep {


    @Override
    public IProductPart buildProductPart() {
        return new EnginePart();
    }
}
