
package orders;

import java.util.Set;

import containers.IContainer;
import products.IProduct;

public class Order implements IOrder {

    private String reference;
    private Set<IContainer> containers;
    private Set<IProduct> products;

    public Order(String reference) {
        this.reference = reference;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public Set<IContainer> getContainers() {
        return containers;
    }

    @Override
    public Set<IProduct> getProducts() {
        return products;
    }

    @Override
    public void addContainer(IContainer container) {
        containers.add(container);

    }

    @Override
    public IContainer addProduct(IProduct product) {
        products.add(product);
        // TODO Añadir al container
        return null;
    }

}
