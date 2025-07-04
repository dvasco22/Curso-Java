
package containers;

import java.util.Set;
import products.IProduct;

public abstract class Container implements IContainer {

    private String reference;
    protected int resistance;
    protected int height;

    private Set<IProduct> products;

    public Container(String reference) {
        this.reference = reference;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public Set<IProduct> getProducts() {
        return products;
    }

    @Override
    public int calculateVolume() {
        return calculateSurface() * height;
    }

    @Override
    public boolean canInsert(IProduct product) {

        // Es resistente
        if (!this.isResistantTo(product)) {
            return false;
        }

        // Tiene espacio
        if (!product.hasSpace(this)) {
            return false;
        }

        // Los productos son compatibles

        for (IProduct element : products) {
            if (!product.isCompatible(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isResistantTo(IProduct product) {
        return true;
    }

    @Override
    public int volumeAvailable() {

        int totalVolume = calculateVolume();
        int usedVolume = 0;
        for (IProduct product : products) {
            usedVolume += product.getVolume();
        }
        return totalVolume - usedVolume;
    }

    @Override
    public String toString() {
        String message = """
                %s ref. %s
                Hash: %s
                """.formatted(
                getType(),
                reference,
                super.toString());

        return message;
    }

}