
package products;

import enums.Category;

public class Drugstore extends Product {

    public Drugstore(String reference, int volume, int weight) {
        super(reference, volume, weight);
    }

    @Override
    public Category getCategory() {
        return Category.DRUGSTORE;
    }

}
