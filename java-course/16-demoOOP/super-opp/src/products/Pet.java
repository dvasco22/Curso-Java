
package products;

import enums.Category;

public class Pet extends Product {

    public Pet(String reference, int volume, int weight) {
        super(reference, volume, weight);

    }

    @Override
    public Category getCategory() {
        return Category.PETS;
    }

}