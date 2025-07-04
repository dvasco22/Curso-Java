package products;

import enums.Category;

public class Hygiene extends Product {

    public Hygiene(String reference, int volume, int weight) {
        super(reference, volume, weight);
    }

    @Override
    public Category getCategory() {
        return Category.HYGIENE;
    }

    @Override
    public boolean isCompatible(IProduct products) {
        return products.getCategory() == Category.PETS || products.getCategory() == Category.HYGIENE;
    }
}