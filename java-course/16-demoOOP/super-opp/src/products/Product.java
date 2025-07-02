
package products;

import containers.IContainer;

public abstract class Product implements IProduct {

    private String reference;
    private int volume;
    private int weight;

    public Product(String reference, int volume, int weight) {
        this.reference = reference;
        this.volume = volume;
        this.weight = weight;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean hasSpace(IContainer container) {
        // TODO Auto-generated method stub
        return false;
    }

    // @Override
    // public boolean hasSpace(IContainer container) {
    //////////return volume <= container.volumeAvailable();
    // }

    @Override
    public boolean isCompatible(IProduct p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void putInto(IContainer container) {
        container.getProducts().add(this);
    }

    @Override
    public String toString() {
        String message = "[%s] %s %s cm3 - %s g".formatted(
                getCategory().toString().toUpperCase(),
                reference, volume, weight);
        return message;
    }

}
