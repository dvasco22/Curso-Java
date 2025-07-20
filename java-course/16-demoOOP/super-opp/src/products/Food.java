package products;

import enums.Category;

public class Food extends Product {

    public Food(String reference, int volume, int weight) {
        super(reference, volume, weight);
    }

    @Override
    public Category getCategory() {
        return Category.FOOD;
    }

    @Override
    public boolean isCompatible(IProduct product) {
        return product.getCategory() == Category.FOOD;
    }
}